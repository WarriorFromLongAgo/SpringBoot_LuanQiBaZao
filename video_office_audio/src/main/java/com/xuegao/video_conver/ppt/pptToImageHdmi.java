package com.xuegao.video_conver.ppt;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.*;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.xslf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver
 * <br/> @ClassName：pptToImageHdmi
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/20 10:36
 */
@SuppressWarnings("all")
public class pptToImageHdmi {
    private static final Logger log = LoggerFactory.getLogger(pptToImageHdmi.class);

    public static void main(String[] args) throws IOException {
        // File pptxFile = new File("d:\\user\\80004960\\桌面\\pptx.pptx");
        File pptxFile = new File("d:\\user\\80004960\\桌面\\仙鹤中国风潮PPT模板 - 副本.pptx");

        // File pptFile = new File("d:\\user\\80004960\\桌面\\ppt.ppt");
        // File pptFile = new File("d:\\user\\80004960\\桌面\\MySQL体系结构.ppt");
        File pptFile = new File("d:\\user\\80004960\\桌面\\10 MySQL体系结构 - 副本.ppt");
        String newFile = "F:\\file\\";

        // long l = System.currentTimeMillis();
        // pptToImageHdmi(pptFile, newFile);
        // long l1 = System.currentTimeMillis();
        // System.out.println("总共 = " + (l1 - l));

        long l22 = System.currentTimeMillis();
        pptxToImageHdmi(pptxFile, newFile);
        long l222 = System.currentTimeMillis();
        System.out.println("总共 = " + (l222 - l22));
    }

    private static int pptToImageHdmi(File file, String outputFile) throws IOException {
        String targetAddress = file.getAbsolutePath();
        if (!targetAddress.endsWith(File.separator)) {
            targetAddress = targetAddress + File.separator;
        }
        File descDir = new File(targetAddress);
        if (!descDir.exists()) {
            boolean mkdirs = descDir.mkdirs();
            if (mkdirs) {
                System.out.println("mkdirs");
            }
        }

        InputStream inputStream = new FileInputStream(file);
        SlideShow slideShow = new HSLFSlideShow(inputStream);
        Dimension pageSize = slideShow.getPageSize();
        List<HSLFSlide> slideList = slideShow.getSlides();
        inputStream.close();

        for (HSLFSlide hslfSlide : slideList) {
            long l = System.currentTimeMillis();
            List<HSLFShape> shapeList = hslfSlide.getShapes();
            for (int i = 0; i < shapeList.size(); i++) {
                Shape shape = shapeList.get(i);
                if (shape instanceof HSLFTextBox) {
                    System.out.println(" 第 " + (i + 1) + " 页 ");
                    System.out.println(shape);
                } else if (shape instanceof HSLFAutoShape) {
                    System.out.println(" 第 " + (i + 1) + " 页 ");
                    // continue;
                } else if (shape instanceof HSLFGroupShape) {
                    System.out.println(" 第 " + (i + 1) + " 页 ");
                } else if (shape instanceof HSLFLine) {
                    System.out.println(" 第 " + (i + 1) + " 页 ");
                } else if (shape instanceof HSLFTextShape) {
                    System.out.println(" 第 " + (i + 1) + " 页 ");
                    HSLFTextShape hslfTextShape = (HSLFTextShape) shape;
                    for (HSLFTextParagraph textParagraph : hslfTextShape.getTextParagraphs()) {
                        List<HSLFTextRun> textRuns = textParagraph.getTextRuns();
                        for (HSLFTextRun hslfTextRun : textRuns) {
                            hslfTextRun.setFontFamily("宋体");
                        }
                    }
                }
            }
            int width = (int) Math.ceil(pageSize.width * 2);
            int height = (int) Math.ceil(pageSize.height * 2);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.setToScale(2, 2);
            Graphics2D graphics = bufferedImage.createGraphics();
            // DrawFactory.getInstance(graphics).fixFonts(graphics);
            graphics.setPaint(Color.WHITE);
            graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width, pageSize.height));
            graphics.setTransform(affineTransform);
            // default rendering options
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            graphics.scale(1, 1);
            hslfSlide.draw(graphics);

            FileOutputStream outputStream = new FileOutputStream(outputFile + System.currentTimeMillis() + ".png");
            ImageIO.write(bufferedImage, "png", outputStream);
            graphics.dispose();
            bufferedImage.flush();
            outputStream.close();
        }

        return 0;
    }

    private static void pptxToImageHdmi(File file, String outputFile) throws IOException {
        String targetAddress = file.getAbsolutePath();
        if (!targetAddress.endsWith(File.separator)) {
            targetAddress = targetAddress + File.separator;
        }
        File descDir = new File(targetAddress);
        if (!descDir.exists()) {
            boolean mkdirs = descDir.mkdirs();
            if (mkdirs) {
                System.out.println("mkdirs");
            }
        }

        InputStream inputStream = new FileInputStream(file);
        XMLSlideShow slideShow = new XMLSlideShow(inputStream);
        List<XSLFSlide> slideList = slideShow.getSlides();
        Dimension pageSize = slideShow.getPageSize();
        inputStream.close();

        int index = 1;
        for (XSLFSlide xslfSlide : slideList) {

            List<XSLFShape> shapeList = xslfSlide.getShapes();
            for (XSLFShape shape : shapeList) {
                check(index, shape);
            }
            int width = (int) Math.ceil(pageSize.width * 2);
            int height = (int) Math.ceil(pageSize.height * 2);
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            AffineTransform affineTransform = new AffineTransform();
            affineTransform.setToScale(2, 2);
            Graphics2D graphics = bufferedImage.createGraphics();
            // DrawFactory.getInstance(graphics).fixFonts(graphics);
            graphics.setPaint(Color.WHITE);
            graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width, pageSize.height));
            graphics.setTransform(affineTransform);
            // default rendering options
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            xslfSlide.draw(graphics);
            graphics.scale(1, 1);

            // draw stuff
            xslfSlide.draw(graphics);

            FileOutputStream outputStream = new FileOutputStream(outputFile + System.currentTimeMillis() + ".png");
            ImageIO.write(bufferedImage, "png", outputStream);
            graphics.dispose();
            bufferedImage.flush();
            outputStream.close();
            ++index;
        }

    }

    private static void check(int index, XSLFShape shape) {
        if (shape instanceof XSLFPictureShape) {
            System.out.println("======================================================");
            XSLFPictureShape xslfPictureShape = (XSLFPictureShape) shape;
            XSLFPictureData pictureData = xslfPictureShape.getPictureData();
            System.out.println(pictureData);
            URI pictureLink = xslfPictureShape.getPictureLink();
            System.out.println(pictureLink);
            Insets clipping = xslfPictureShape.getClipping();
            System.out.println(clipping);
            System.out.println(" 第 " + index + " 页 " + xslfPictureShape);
        } else if (shape instanceof XSLFGroupShape) {
            System.out.println("======================================================");
            XSLFGroupShape xslfGroupShape = (XSLFGroupShape) shape;
            List<XSLFShape> xslfShapeList = xslfGroupShape.getShapes();
            for (XSLFShape xslfShape : xslfShapeList) {
                System.out.println(xslfShape);
                check(index, xslfShape);
            }
            System.out.println(" 第 " + index + " 页 " + xslfGroupShape);
        } else if (shape instanceof XSLFTextBox) {
            XSLFTextBox xslfTextBox = (XSLFTextBox) shape;
            // for (XSLFTextParagraph textParagraph : xslfTextBox.getTextParagraphs()) {
            //     for (XSLFTextRun textRun : textParagraph.getTextRuns()) {
            //         //字体风格
            //         textRun.setFontFamily("宋体");
            //         //加粗
            //         // textRun.setBold(true);
            //         //字号
            //         // textRun.setFontSize((double) 44);
            //         //颜色
            //         // textRun.setFontColor(Color.BLACK);
            //         //文本信息
            //         textRun.setText("这\r\n是\r\n文\r\n本\r\n框\r\n里\r\n面\r\n的\r\n大\r\n字");
            //         //如果不改文本样式可以直接 textBox1.setText("这是一份PPT")
            //     }
            // }
            System.out.println(" 第 " + index + " 页 " + xslfTextBox);
        } else if (shape instanceof XSLFAutoShape) {
            XSLFAutoShape xslfAutoShape = (XSLFAutoShape) shape;
            System.out.println(" 第 " + index + " 页 " + xslfAutoShape);
            // xslfAutoShape.setRotation();
            // double rotation = xslfAutoShape.getRotation();
            double rotation1 = xslfAutoShape.getRotation();
            System.out.println("xslfAutoShape = " + xslfAutoShape);
            Double textRotation1 = xslfAutoShape.getTextRotation();
            System.out.println("xslfAutoShape = " + textRotation1);
            // xslfAutoShape.setTextDirection(TextShape.TextDirection.VERTICAL);

            for (XSLFTextParagraph xslfTextParagraph : xslfAutoShape) {
                int index2 = 1;
                XSLFTextShape xslfTextShape = xslfTextParagraph.getParentShape();
                TextShape.TextAutofit textAutofit = xslfTextShape.getTextAutofit();
                System.out.println("TextAutofit =  " + textAutofit);
                xslfAutoShape.setTextDirection(TextShape.TextDirection.VERTICAL);

                TextShape.TextPlaceholder textPlaceholder = xslfTextShape.getTextPlaceholder();
                System.out.println("textPlaceholder =  " + textPlaceholder);
                Placeholder textType = xslfTextShape.getTextType();
                System.out.println("textType = " + textType);
                TextParagraph.TextAlign textAlign = xslfTextParagraph.getTextAlign();
                System.out.println("textAlign = " + textAlign);
                String text = xslfTextParagraph.getText();
                System.out.println("text = " + text);
                TextParagraph.FontAlign fontAlign = xslfTextParagraph.getFontAlign();
                System.out.println(" fontAlign " + fontAlign);
                String bulletFont = xslfTextParagraph.getBulletFont();
                System.out.println("bulletFont = " + bulletFont);

                for (XSLFTextRun textRun : xslfTextParagraph.getTextRuns()) {
                    textRun.setFontFamily("宋体");
                    textRun.setText("这是文本框里面的小字 xslfAutoShape  " + index2);
                    index2++;
                }
            }
            StrokeStyle strokeStyle = xslfAutoShape.getStrokeStyle();
            System.out.println(" strokeStyle = " + strokeStyle);
            if (strokeStyle instanceof XSLFSimpleShape) {
                XSLFSimpleShape xslfSimpleShape = (XSLFSimpleShape) strokeStyle;
                double rotation = xslfSimpleShape.getRotation();
                System.out.println("strokeStyle = rotation = " + rotation);
            }
            if (ObjectUtils.isNotEmpty(xslfAutoShape.getTextRotation())) {
                Double textRotation = xslfAutoShape.getTextRotation();
                xslfAutoShape.setTextRotation(textRotation);
            }
            if (ObjectUtils.isNotEmpty(xslfAutoShape.getRotation())) {
                double rotation = xslfAutoShape.getRotation();
                xslfAutoShape.setRotation(rotation);
            }
        } else if (shape instanceof XSLFConnectorShape) {
            XSLFConnectorShape xslfConnectorShape = (XSLFConnectorShape) shape;
            System.out.println(" 第 " + index + " 页 " + xslfConnectorShape);
        } else if (shape instanceof XSLFTextShape) {
            XSLFTextShape sh = (XSLFTextShape) shape;
            List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();
            for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
                List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
                for (XSLFTextRun xslfTextRun : textRuns) {
                    xslfTextRun.setFontFamily("宋体");
                }
            }
        } else {
            System.out.println("===================================================================");
            System.out.println("===================================================================");
            System.out.println(shape);
            System.out.println("===================================================================");
            System.out.println("===================================================================");
        }
    }

}