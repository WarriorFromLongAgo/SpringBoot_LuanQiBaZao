package com.xuegao.video_conver.ppt;

import com.google.common.collect.Lists;
import org.apache.poi.hslf.model.*;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.ppt
 * <br/> @ClassName：PptToImage
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/27 17:09
 */
public class PptToImage {
    private static final Logger log = LoggerFactory.getLogger(PptToImage.class);

    public static void main(String[] args) {
        File pptxFile = new File("d:\\user\\80004960\\桌面\\pptx.pptx");
        // File pptFile = new File("d:\\user\\80004960\\桌面\\ppt.ppt");
        File pptFile = new File("d:\\user\\80004960\\桌面\\MySQL体系结构.ppt");
        String newFile = "F:\\file\\";

        // 文字未出来
        // List<String> strings = pptConvertPng(pptFile, newFile);
        // List<String> strings = pptConvertPng2(pptFile, newFile);
        // List<String> strings = pptConvertPng3(pptFile, newFile);
        pptConvertPng5(pptFile, newFile);
        // strings.parallelStream().forEach(System.out::println);
        // boolean b = doPPTtoImage(pptFile, newFile);


        // List<String> strings1 = pptxConvertPng(pptxFile, newFile);
        // strings1.parallelStream().forEach(System.out::println);
    }


    // 3.14
    private static void setHSLFTxtFontFamily(HSLFShape shape) {
        HSLFTextShape txtshape = (HSLFTextShape) shape;
        for (HSLFTextParagraph textPara : txtshape.getTextParagraphs()) {
            List<HSLFTextRun> textRunList = textPara.getTextRuns();
            for (HSLFTextRun textRun : textRunList) {
                textRun.setFontFamily("微软雅黑");
            }
        }
    }

    public static void mksFile(String filePath) {
        if (!isExists(filePath)) {
            new File(filePath).mkdirs();
        }
    }

    public static boolean isExists(String filePath) {
        if (new File(filePath).exists()) {
            return true;
        }
        return false;
    }


    // 3.14
    //
    private static <T> FileOutputStream drawImage(String outputFile, int size, Dimension pgsize,
                                                  XSLFSlide xslfSlide, HSLFSlide hslfSlide) throws FileNotFoundException, IOException {
        FileOutputStream out = null;
        BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
        graphics.setPaint(Color.white);
        if (null != xslfSlide) {
            xslfSlide.getSlideShow();
            // render
            xslfSlide.draw(graphics);
        }
        if (null != hslfSlide) {
            hslfSlide.getSlideShow();
            // render
            hslfSlide.draw(graphics);
        }
        // save the output
        mksFile(outputFile);
        out = new FileOutputStream(outputFile + File.separator + size + ".png");
        ImageIO.write(img, "png", out);
        return out;

        // ImageIO.write(img, "jpg", outputStream);
        // ppt.write(outputStream);
        // System.out.println("Image successfully created");
    }


    // 3.14
    private static int pptConvertPng5(File file, String outputFile) {

        List<String> newFileList = Lists.newArrayList();
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(file);
            HSLFSlideShow hslfSlideShow = new HSLFSlideShow(inputStream);
            Dimension pageSize = hslfSlideShow.getPageSize();
            List<HSLFSlide> slideList = hslfSlideShow.getSlides();
            inputStream.close();

            // List<HSLFSlide> slide = ppt.getSlides();
            for (int i = 0; i < slideList.size(); i++) {
                for (HSLFShape shape : slideList.get(i).getShapes()) {
                    if (shape instanceof HSLFTextShape) {
                        setHSLFTxtFontFamily(shape);
                    } else if (shape instanceof HSLFGroupShape) {
                        HSLFGroupShape xslfGroupShape = (HSLFGroupShape) shape;
                        List<HSLFShape> xslfShapes = xslfGroupShape.getShapes();
                        for (HSLFShape xslfShape : xslfShapes) {
                            if (xslfShape instanceof HSLFTextShape) {
                                setHSLFTxtFontFamily(xslfShape);
                            }
                        }
                    } else {
                        // System.out.println(shape);
                    }
                }
                outputStream = drawImage(outputFile, i, pageSize, null, slideList.get(i));
                hslfSlideShow.write(outputStream);

                HeadersFooters header = slideList.get(i).getHeadersFooters();
                if (header.isFooterVisible()) {
                    String footerText = header.getFooterText();
                    System.out.println(footerText);
                }
                if (header.isUserDateVisible()) {
                    String customDate = header.getDateTimeText();
                    System.out.println(customDate);
                }
                if (header.isSlideNumberVisible()) {
                    int slideNUm = slideList.get(i).getSlideNumber();
                    System.out.println(slideNUm);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    // public static List<String> pptConvertPng0(File file, String dir) {
    //
    //     long start = System.currentTimeMillis();
    //
    //     File dirFile = new File(dir);
    //     if (!dirFile.exists()) {
    //         dirFile.mkdirs();
    //     }
    //
    //     List<String> images = new LinkedList<String>();
    //     int isppt = checkFile(file);
    //     if (isppt < 0) {
    //         System.out.println("this file isn't ppt or pptx.");
    //         return null;
    //     }
    //     try {
    //         FileInputStream is = new FileInputStream(file);
    //         Dimension pgsize = null;
    //         Object[] slide = null;
    //
    //         if (isppt == 0) {
    //             SlideShow ppt = new SlideShow(is);
    //             is.close();
    //             pgsize = ppt.getPageSize();
    //             slide = ppt.getSlides();
    //         } else if (isppt == 1) {
    //             XMLSlideShow xppt = new XMLSlideShow(is);
    //             is.close();
    //             pgsize = xppt.getPageSize();
    //             slide = xppt.getSlides();
    //         }
    //
    //         for (int i = 0; i < slide.length; i++) {
    //             System.out.println("Processing Page " + (i + 1) + "... ");
    //             BufferedImage img = new BufferedImage(pgsize.width,
    //                     pgsize.height, BufferedImage.TYPE_INT_RGB);
    //             Graphics2D graphics = img.createGraphics();
    //             graphics.setPaint(Color.white);
    //             graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,
    //                     pgsize.height));
    //
    //             if (isppt == 0) {
    //                 Slide ss = (Slide) slide[i];
    //                 ss.draw(graphics);
    //             } else {
    //                 XSLFSlide xss = (XSLFSlide) slide[i];
    //                 xss.draw(graphics);
    //             }
    //
    //             String filename = (i + 1) + ".jpg";
    //             File imgFile = new File(dir, filename);
    //             images.add(imgFile.getAbsolutePath());
    //             FileOutputStream out = new FileOutputStream(imgFile);
    //             javax.imageio.ImageIO.write(img, "jpg", out);
    //             out.close();
    //         }
    //         System.out.println("completed in " + (System.currentTimeMillis() - start) + " ms.");
    //     } catch (FileNotFoundException e) {
    //         System.out.println(e);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     return images;
    // }

    public static int checkFile(File file) {
        int isppt = -1;
        String filename = file.getName();
        String suffixname = null;
        if (filename != null && filename.indexOf(".") != -1) {
            suffixname = filename.substring(filename.indexOf("."));
            if (suffixname.equals(".ppt")) {
                isppt = 0;
            } else if (suffixname.equals(".pptx")) {
                isppt = 1;
            }
        }
        return isppt;
    }


    // public static List<String> pptConvertPng2(File file, String outputFolder) {
    //     // TODO 校验输入文件是否存在 以及是否为PPT
    //     List<String> newFileList = Lists.newArrayList();
    //     FileInputStream inputStream = null;
    //     FileOutputStream outputStream = null;
    //     try {
    //         inputStream = new FileInputStream(file);
    //
    //         SlideShow ppt = new SlideShow(inputStream);
    //         inputStream.close();
    //         Dimension pgsize = ppt.getPageSize();
    //         org.apache.poi.hslf.model.Slide[] slide = ppt.getSlides();
    //         for (int i = 0; i < slide.length; i++) {
    //             TextRun[] truns = slide[i].getTextRuns();
    //             for (int k = 0; k < truns.length; k++) {
    //                 RichTextRun[] rtruns = truns[k].getRichTextRuns();
    //                 for (int l = 0; l < rtruns.length; l++) {
    //                     rtruns[l].setFontIndex(1);
    //                     rtruns[l].setFontName("宋体");
    //                 }
    //             }
    //             BufferedImage img = new BufferedImage(pgsize.width, pgsize.height,
    //                     BufferedImage.TYPE_INT_RGB);
    //             Graphics2D graphics = img.createGraphics();
    //             graphics.setPaint(Color.BLUE);
    //             graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
    //             slide[i].draw(graphics);
    //             // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
    //             File path = new File("F:\\file");
    //             if (!path.exists()) {
    //                 path.mkdir();
    //             }
    //             FileOutputStream out = new FileOutputStream(path + "/" + (i + 1) + ".jpg");
    //             javax.imageio.ImageIO.write(img, "png", out);
    //             out.close();
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (inputStream != null) {
    //             try {
    //                 inputStream.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         if (outputStream != null) {
    //             try {
    //                 outputStream.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    //     return newFileList;
    // }


//     public static boolean doPPTtoImage(File file, String output) {
//         try {
//             FileInputStream is = new FileInputStream(file);
//             SlideShow ppt = new SlideShow(is);
//             is.close();
//             Dimension pgsize = ppt.getPageSize();
//             org.apache.poi.hslf.model.Slide[] slide = ppt.getSlides();
//             for (int i = 0; i < slide.length; i++) {
//                 TextRun[] truns = slide[i].getTextRuns();
//                 for (int k = 0; k < truns.length; k++) {
//                     RichTextRun[] rtruns = truns[k].getRichTextRuns();
//                     for (int l = 0; l < rtruns.length; l++) {
//                         rtruns[l].setFontIndex(1);
//                         rtruns[l].setFontName("宋体");
//                     }
//                 }
//                 BufferedImage img = new BufferedImage(pgsize.width, pgsize.height,
//                         BufferedImage.TYPE_INT_RGB);
//                 Graphics2D graphics = img.createGraphics();
//                 graphics.setPaint(Color.BLUE);
//                 graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
//                 slide[i].draw(graphics);
//                 // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
//                 File path = new File(output);
//                 if (!path.exists()) {
//                     path.mkdir();
//                 }
//                 // 可测试多种图片格式
// //                    FileOutputStream out = new FileOutputStream(path + "/" + (i + 1) + ".jpg");
// //                    javax.imageio.ImageIO.write(img, "jpeg", out);
//                 FileOutputStream out = new FileOutputStream(path + "/" + (i + 1) + ".jpg");
//                 javax.imageio.ImageIO.write(img, "png", out);
//                 out.close();
//             }
//             System.out.println("success!!");
//             return true;
//         } catch (FileNotFoundException e) {
//             System.out.println(e);
//         } catch (IOException e) {
//
//         }
//         return false;
//     }
//
//
//     public static List<String> pptConvertPng(File file, String outputFolder) {
//         // TODO 校验输入文件是否存在 以及是否为PPT
//         List<String> newFileList = Lists.newArrayList();
//         FileInputStream inputStream = null;
//         FileOutputStream outputStream = null;
//         try {
//             inputStream = new FileInputStream(file);
//             SlideShow slideShow = new SlideShow(inputStream);
//             Slide[] slideArr = slideShow.getSlides();
//             Dimension pageSize = slideShow.getPageSize();
//             inputStream.close();
//
//             BufferedImage img;
//             for (int i = 0; i < slideArr.length; i++) {
//                 img = new BufferedImage(pageSize.width, pageSize.height, BufferedImage.TYPE_INT_RGB);
//                 Graphics2D graphics = img.createGraphics();
//                 graphics.setPaint(Color.white);
//                 graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width, pageSize.height));
//                 slideArr[i].draw(graphics);
//                 //creating an image file as output
//                 outputStream = new FileOutputStream(i + "ppt_image.jpg");
//                 ImageIO.write(img, "jpg", outputStream);
//                 slideShow.write(outputStream);
//                 System.out.println("Image successfully created");
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         } finally {
//             if (inputStream != null) {
//                 try {
//                     inputStream.close();
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//             if (outputStream != null) {
//                 try {
//                     outputStream.close();
//                 } catch (IOException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }
//         return newFileList;
//     }

    // public static List<String> pptxConvertPng(File file, String outputFolder) {
    //     // TODO 校验输入文件是否存在 以及是否为PPT
    //     List<String> newFileList = Lists.newArrayList();
    //     FileInputStream inputStream = null;
    //     FileOutputStream outputStream = null;
    //     try {
    //         File outPut = createDirIfNotExist(outputFolder);
    //
    //         inputStream = new FileInputStream(file);
    //         XMLSlideShow pptx = new XMLSlideShow(inputStream);
    //         Dimension pageSize = pptx.getPageSize();
    //         XSLFSlide[] slideArr = pptx.getSlides();
    //
    //         inputStream.close();
    //
    //         BufferedImage img;
    //         for (int i = 0; i < slideArr.length; i++) {
    //             img = new BufferedImage(pageSize.width, pageSize.height, BufferedImage.TYPE_INT_RGB);
    //             Graphics2D graphics = img.createGraphics();
    //             graphics.setPaint(Color.white);
    //             graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width, pageSize.height));
    //             slideArr[i].draw(graphics);
    //             //creating an image file as output
    //             outputStream = new FileOutputStream(i + "pptx_image.jpg");
    //             ImageIO.write(img, "jpg", outputStream);
    //             pptx.write(outputStream);
    //             System.out.println("Image successfully created");
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     } finally {
    //         if (inputStream != null) {
    //             try {
    //                 inputStream.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //         if (outputStream != null) {
    //             try {
    //                 outputStream.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    //     return newFileList;
    // }

    /**
     * 检查是否为ppt文件
     *
     * @param file
     * @return
     */
    public static boolean checkIsPPTFile(File file) {
        boolean isppt = false;
        String filename = file.getName();
        String suffixname = null;
        if (filename != null && filename.contains(".")) {
            suffixname = filename.substring(filename.lastIndexOf("."));
            if (suffixname.equals(".ppt") || suffixname.equals(".pptx")) {
                isppt = true;
            }
            return isppt;
        } else {
            return isppt;
        }
    }

    /**
     * 创建文件如果路径不存在则创建对应的文件夹
     *
     * @param file
     * @return
     */
    public static File createDirIfNotExist(String file) {
        File fileDir = new File(file);
        if (!fileDir.exists()) {
            boolean mkdirs = fileDir.mkdirs();
            log.info("mkdirs = {}, file = {}", mkdirs, file);
        }
        return fileDir;
    }


    // /**
    //  * ppt2003 文档的转换 后缀名为.ppt
    //  * @param pptFile ppt文件
    //  * @param imgFile 图片将要保存的目录（不是文件）
    //  * @return
    //  */
    // public static boolean doPPT2003toImage(File pptFile,File imgFile,List<String> list) {
    //
    //
    //     try {
    //
    //         FileInputStream is = new FileInputStream(pptFile);
    //         SlideShow ppt = new SlideShow(is);
    //
    //         //及时关闭掉 输入流
    //         is.close();
    //
    //         Dimension pgsize = ppt.getPageSize();
    //         Slide[] slide = ppt.getSlides();
    //
    //         for (int i = 0; i < slide.length; i++) {
    //
    //             log.info("第" + i + "页。");
    //
    //             TextRun[] truns = slide[i].getTextRuns();
    //
    //             for (int k = 0; k < truns.length; k++) {
    //
    //                 RichTextRun[] rtruns = truns[k].getRichTextRuns();
    //
    //                 for (int l = 0; l < rtruns.length; l++) {
    //
    //                     // 原有的字体索引 和 字体名字
    //                     int index = rtruns[l].getFontIndex();
    //                     String name = rtruns[l].getFontName();
    //
    //                     log.info("原有的字体索引 和 字体名字: "+index+" - "+name);
    //
    //                     // 重新设置 字体索引 和 字体名称 是为了防止生成的图片乱码问题
    //                     rtruns[l].setFontIndex(1);
    //                     rtruns[l].setFontName("宋体");
    //                 }
    //
    //             }
    //
    //             //根据幻灯片大小生成图片
    //             BufferedImage img = new BufferedImage(pgsize.width,pgsize.height, BufferedImage.TYPE_INT_RGB);
    //             Graphics2D graphics = img.createGraphics();
    //
    //             graphics.setPaint(Color.white);
    //             graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,pgsize.height));
    //             slide[i].draw(graphics);
    //
    //             // 图片的保存位置
    //             String absolutePath = imgFile.getAbsolutePath()+"/"+ (i + 1) + ".jpeg";
    //             File jpegFile = new File(absolutePath);
    //             // 图片路径存放
    //             list.add((i + 1) + ".jpeg");
    //
    //             // 如果图片存在，则不再生成
    //             if (jpegFile.exists()) {
    //                 continue;
    //             }
    //
    //             // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
    //             FileOutputStream out = new FileOutputStream(jpegFile);
    //
    //             ImageIO.write(img, "jpeg", out);
    //
    //             out.close();
    //
    //         }
    //
    //         log.error("PPT转换成图片 成功！");
    //
    //         return true;
    //
    //     } catch (Exception e) {
    //         log.error("PPT转换成图片 发生异常！", e);
    //     }
    //
    //     return false;
    //
    // }
    //
    //
    // /**
    //  * ppt2007文档的转换 后缀为.pptx
    //  * @param pptFile PPT文件
    //  * @param imgFile 图片将要保存的路径目录（不是文件）
    //  * @param list 存放文件名的 list
    //  * @return
    //  */
    // public static boolean doPPT2007toImage(File pptFile, File imgFile, List<String> list) {
    //
    //
    //     FileInputStream is = null ;
    //
    //
    //     try {
    //
    //         is = new FileInputStream(pptFile);
    //
    //         XMLSlideShow xmlSlideShow = new XMLSlideShow(is);
    //
    //         is.close();
    //
    //         // 获取大小
    //         Dimension pgsize = xmlSlideShow.getPageSize();
    //
    //         // 获取幻灯片
    //         java.util.List<XSLFSlide> slides = xmlSlideShow.getSlides();
    //
    //         for (int i = 0 ; i < slides.length ; i++) {
    //
    //
    //             // 解决乱码问题
    //             XSLFShape[] shapes = slides[i].getShapes();
    //             for (XSLFShape shape : shapes) {
    //
    //                 if (shape instanceof XSLFTextShape) {
    //                     XSLFTextShape sh = (XSLFTextShape) shape;
    //                     List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();
    //
    //                     for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
    //                         List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
    //                         for (XSLFTextRun xslfTextRun : textRuns) {
    //                             xslfTextRun.setFontFamily("宋体");
    //                         }
    //                     }
    //                 }
    //             }
    //
    //
    //             //根据幻灯片大小生成图片
    //             BufferedImage img = new BufferedImage(pgsize.width,pgsize.height, BufferedImage.TYPE_INT_RGB);
    //             Graphics2D graphics = img.createGraphics();
    //
    //             graphics.setPaint(Color.white);
    //             graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,pgsize.height));
    //
    //             // 最核心的代码
    //             slides[i].draw(graphics);
    //
    //             //图片将要存放的路径
    //             String absolutePath = imgFile.getAbsolutePath()+"/"+ (i + 1) + ".jpeg";
    //             File jpegFile = new File(absolutePath);
    //             // 图片路径存放
    //             list.add((i + 1) + ".jpeg");
    //
    //             //如果图片存在，则不再生成
    //             if (jpegFile.exists()) {
    //                 continue;
    //             }
    //             // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
    //             FileOutputStream out = new FileOutputStream(jpegFile);
    //
    //             // 写入到图片中去
    //             ImageIO.write(img, "jpeg", out);
    //
    //             out.close();
    //
    //         }
    //
    //
    //         log.error("PPT转换成图片 成功！");
    //
    //         return true;
    //
    //     } catch (Exception e) {
    //         log.error("PPT转换成图片 发生异常！", e);
    //     }
    //
    //
    //     return false;
    //
    // }
}