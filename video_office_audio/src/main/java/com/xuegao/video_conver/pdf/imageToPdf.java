package com.xuegao.video_conver.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTextParagraph;
import org.apache.poi.hslf.usermodel.HSLFTextRun;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * <br/> @PackageName：com.xuegao.video_conver.pdf
 * <br/> @ClassName：imageToPdf
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/21 17:27
 */
public class imageToPdf {

    public static void main(String[] args) {
        File pptFile = new File("d:\\user\\80004960\\桌面\\深入理解Java虚拟机.PPT");
        String fileName = pptFile.getName();
        if (fileName.endsWith("ppt")) {
            // resObj = upload(file,flag);
            // FilesUtil f = new FilesUtil();
            // String pptPath = resObj.get("msg").toString();
            // String[] pptArr = pptPath.split(".ppt");
            // String arr = pptArr[0];
            // List<String> result = converPPTtoImage(pptPath, arr+"/", "jpg", 8);
            //
            // resObj.put("msg",FILE_PATH + fileName.substring(0, fileName.lastIndexOf("."))+".pdf");
            // resObj.put("fileName",fileName.substring(0, fileName.lastIndexOf("."))+".pdf");
            // f.imageToPdf(result,FILE_PATH + fileName.substring(0, fileName.lastIndexOf("."))+".pdf");
        }
    }

    public File imageToPdf(List<String> imageUrllist, String mOutputPdfFileName) {

        // Document doc = new Document(PageSize.A4, 20, 20, 20, 20);
        // try {
        //     PdfWriter.getInstance(doc, new FileOutputStream(mOutputPdfFileName));
        //     doc.open();
        //     for (int i = 0; i < imageUrllist.size(); i++) {
        //         doc.newPage();
        //         Image png1 = Image.getInstance(imageUrllist.get(i));
        //         float heigth = png1.getHeight();
        //         float width = png1.getWidth();
        //         int percent = getPercent2(heigth, width);
        //         png1.setAlignment(Image.MIDDLE);
        //         png1.scalePercent(percent + 3);// 表示是原来图像的比例;
        //         doc.add(png1);
        //     }
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (DocumentException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }finally {
        //     doc.close();
        // }
        File mOutputPdfFile = new File(mOutputPdfFileName);
        if (!mOutputPdfFile.exists()) {
            mOutputPdfFile.deleteOnExit();
            return null;
        }
        return mOutputPdfFile;
    }

    private int getPercent2(float h, float w) {
        int p = 0;
        float p2 = 0.0f;
        p2 = 530 / w * 100;
        p = Math.round(p2);
        return p;
    }


    /**
     * 将PPT 文件转换成image
     * @param orignalPPTFileName    //PPT文件路径 如：d:/demo/demo1.ppt
     * @param targetImageFileDir    //转换后的图片保存路径 如：d:/demo/pptImg
     * @param imageFormatNameString //图片转化的格式字符串 ，如："jpg"、"jpeg"、"bmp" "png" "gif" "tiff"
     * @return 图片名列表
     * 生成图片放大的倍数,倍数越高，清晰度越高
     */
    @SuppressWarnings("resource")
    public static List<String> converPPTtoImage(String orignalPPTFileName, String targetImageFileDir,
                                                String imageFormatNameString, int times) {
        List<String> imgList = new ArrayList<>();
        List<String> imgNamesList = new ArrayList<String>();// PPT转成图片后所有名称集合
        FileInputStream orignalPPTFileInputStream = null;
        FileOutputStream orignalPPTFileOutStream = null;
        HSLFSlideShow oneHSLFSlideShow = null;
        //创建文件夹
        createDirIfNotExist(targetImageFileDir);
        try {
            try {
                orignalPPTFileInputStream = new FileInputStream(orignalPPTFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
            try {
                oneHSLFSlideShow = new HSLFSlideShow(orignalPPTFileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
            // 获取PPT每页的大小（宽和高度）
            Dimension onePPTPageSize = oneHSLFSlideShow.getPageSize();
            // 获得PPT文件中的所有的PPT页面（获得每一张幻灯片）,并转为一张张的播放片
            List<HSLFSlide> pptPageSlideList = oneHSLFSlideShow.getSlides();
            // 下面循环的主要功能是实现对PPT文件中的每一张幻灯片进行转换和操作
            for (int i = 0; i < pptPageSlideList.size(); i++) {
                // 这几个循环只要是设置字体为宋体，防止中文乱码，
                List<List<HSLFTextParagraph>> oneTextParagraphs = pptPageSlideList.get(i).getTextParagraphs();
                for (List<HSLFTextParagraph> list : oneTextParagraphs) {
                    for (HSLFTextParagraph hslfTextParagraph : list) {
                        List<HSLFTextRun> HSLFTextRunList = hslfTextParagraph.getTextRuns();
                        for (int j = 0; j < HSLFTextRunList.size(); j++) {
                            // 如果PPT在WPS中保存过，则
                            // HSLFTextRunList.get(j).getFontSize();的值为0或者26040，
                            // 因此首先识别当前文本框内的字体尺寸是否为0或者大于26040，则设置默认的字体尺寸。

                            // 设置字体大小
                            Double size = HSLFTextRunList.get(j).getFontSize();
                            if ((size <= 0) || (size >= 26040)) {
                                HSLFTextRunList.get(j).setFontSize(20.0);
                            }
                            // 设置字体样式为宋体
                            // String
                            // family=HSLFTextRunList.get(j).getFontFamily();
                            HSLFTextRunList.get(j).setFontFamily("宋体");

                        }
                    }

                }
                // 创建BufferedImage对象，图像的尺寸为原来的每页的尺寸*倍数times
                BufferedImage oneBufferedImage = new BufferedImage(onePPTPageSize.width * times,
                        onePPTPageSize.height * times, BufferedImage.TYPE_INT_RGB);
                Graphics2D oneGraphics2D = oneBufferedImage.createGraphics();
                // 设置转换后的图片背景色为白色
                oneGraphics2D.setPaint(Color.white);
                oneGraphics2D.scale(times, times);// 将图片放大times倍
                oneGraphics2D
                        .fill(new Rectangle2D.Float(0, 0, onePPTPageSize.width * times, onePPTPageSize.height * times));
                pptPageSlideList.get(i).draw(oneGraphics2D);
                // 设置图片的存放路径和图片格式，注意生成的图片路径为绝对路径，最终获得各个图像文件所对应的输出流对象
                try {
                    String imgName = (i + 1) + "_" + UUID.randomUUID().toString() + "." + imageFormatNameString;
                    imgNamesList.add(imgName);// 将图片名称添加的集合中
                    imgList.add(targetImageFileDir + imgName);
                    orignalPPTFileOutStream = new FileOutputStream(targetImageFileDir + imgName);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return Collections.emptyList();
                }
                // 转换后的图片文件保存的指定的目录中
                try {
                    ImageIO.write(oneBufferedImage, imageFormatNameString, orignalPPTFileOutStream);
                } catch (IOException e) {
                    e.printStackTrace();
                    return Collections.emptyList();
                }

            }

        } finally {
            try {
                if (orignalPPTFileInputStream != null) {
                    orignalPPTFileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (orignalPPTFileOutStream != null) {
                    orignalPPTFileOutStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return imgList;
    }

    /**
     * 创建文件如果路径不存在则创建对应的文件夹
     */
    public static File createDirIfNotExist(String file) {
        File fileDir = new File(file);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir;
    }

}