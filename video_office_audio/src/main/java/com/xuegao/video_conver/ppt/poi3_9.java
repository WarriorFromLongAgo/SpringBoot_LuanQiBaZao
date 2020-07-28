// package com.xuegao.video_conver.ppt;
//
// import com.google.common.collect.Lists;
// import org.apache.poi.hslf.HSLFSlideShow;
// import org.apache.poi.hslf.model.Picture;
// import org.apache.poi.hslf.model.Slide;
// import org.apache.poi.hslf.model.SlideMaster;
// import org.apache.poi.hslf.model.TextRun;
// import org.apache.poi.hslf.usermodel.RichTextRun;
// import org.apache.poi.hslf.usermodel.SlideShow;
// import org.apache.poi.sl.usermodel.PictureData;
//
// import javax.imageio.ImageIO;
// import java.awt.*;
// import java.awt.geom.Rectangle2D;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.util.Arrays;
// import java.util.List;
//
// /**
//  * <br/> @PackageName：com.xuegao.video_conver.ppt
//  * <br/> @ClassName：poi3_9
//  * <br/> @Description：
//  * <br/> @author：80004960
//  * <br/> @date：2020/7/28 11:34
//  */
// public class poi3_9 {
//
//     private static SlideShow ppt;
//
//     public static void main(String[] args) {
//         File pptxFile = new File("d:\\user\\80004960\\桌面\\pptx.pptx");
//         // File pptFile = new File("d:\\user\\80004960\\桌面\\ppt.ppt");
//         File pptFile = new File("d:\\user\\80004960\\桌面\\MySQL体系结构.ppt");
//         String newFile = "F:\\file\\";
//         // pptConvertPng3(pptFile, newFile);
//         pptConvertPng33(pptFile, newFile);
//     }
//
//     // 3.9 不行，少东西
//     public static List<String> pptConvertPng3(File file, String outputFolder) {
//         List<String> newFileList = Lists.newArrayList();
//         FileInputStream inputStream = null;
//         FileOutputStream outputStream = null;
//
//         try {
//             inputStream = new FileInputStream(file);
//             SlideShow ppt = new SlideShow(inputStream);
//             Slide[] slideArr = ppt.getSlides();
//             inputStream.close();
//             StringBuilder content = new StringBuilder();
//
//             SlideMaster[] slidesMasters = ppt.getSlidesMasters();
//             System.out.println("soundData = " + Arrays.toString(slidesMasters));
//             System.out.println("=======================================");
//
//             for (int i = 0; i < slideArr.length; i++) {
//                 TextRun[] textRunArr = slideArr[i].getTextRuns();
//                 for (int k = 0; k < textRunArr.length; k++) {
//                     RichTextRun[] rtrunArr = textRunArr[k].getRichTextRuns();
//                     for (int l = 0; l < rtrunArr.length; l++) {
//                         rtrunArr[l].setFontIndex(1);
//                         content.append(rtrunArr[l].getText());
//                     }
//                 }
//             }
//             System.out.println(content.toString());
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return newFileList;
//     }
//
//     public static List<String> pptConvertPng33(File file, String outputFolder) {
//         List<String> newFileList = Lists.newArrayList();
//         FileInputStream inputStream = null;
//         FileOutputStream outputStream = null;
//         HSLFSlideShow SlideShow = null;
//
//         try {
//             inputStream = new FileInputStream(file);
//             ppt = new SlideShow(new HSLFSlideShow(inputStream));
//             Slide[] slideArr = ppt.getSlides();
//             Dimension pageSize = ppt.getPageSize();
//             inputStream.close();
//
//             SlideMaster[] slidesMasters = ppt.getSlidesMasters();
//             System.out.println("soundData = " + Arrays.toString(slidesMasters));
//             System.out.println("=======================================");
//             int picIndex = getIndex(file.getAbsolutePath(), Picture.PNG);
//             for (SlideMaster slideMaster : ppt.getSlidesMasters()) {
//                 setBackground(slideMaster, picIndex);
//             }
//
//             for (int i = 0; i < slideArr.length; i++) {
//
//                 TextRun[] truns = slideArr[i].getTextRuns();
//                 for (int k = 0; k < truns.length; k++) {
//                     RichTextRun[] rtruns = truns[k].getRichTextRuns();
//                     for (int l = 0; l < rtruns.length; l++) {
//                         rtruns[l].setFontIndex(1);
//                         rtruns[l].setFontName("宋体");
//                     }
//                 }
//                 BufferedImage img = new BufferedImage(pageSize.width, pageSize.height, BufferedImage.TYPE_INT_RGB);
//                 Graphics2D graphics = img.createGraphics();
//                 // clear the drawing area
//                 graphics.setPaint(Color.white);
//                 graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width, pageSize.height));
//                 // render
//                 slideArr[i].draw(graphics);
//                 // save the output
//                 FileOutputStream out = new FileOutputStream("slide-" + i + ".png");
//                 ImageIO.write(img, "png", out);
//                 ppt.write(new FileOutputStream("slide-" + i + ".ppt"));
//                 out.close();
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return newFileList;
//     }
//
//     private static void setBackground(SlideMaster master, int picIndex) {
//         // 设置图片位置
//         Picture background = new Picture(picIndex);
//         background.setAnchor(new Rectangle(0, 0, ppt.getPageSize().width, ppt.getPageSize().height));
//         master.addShape(background);
//     }
//
//     private static int getIndex(String imgPath, int imgType) {
//         int picIndex = 0;
//         try {
//             picIndex = ppt.addPicture(new File(imgPath), imgType);
//         } catch (IOException e) {
//             System.out.println(e);
//         }
//         return picIndex;
//     }
// }