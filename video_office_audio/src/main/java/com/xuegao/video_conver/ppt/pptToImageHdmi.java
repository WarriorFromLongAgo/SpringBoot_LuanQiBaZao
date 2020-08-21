package com.xuegao.video_conver.ppt;

import com.google.common.collect.Lists;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
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
        File pptxFile = new File("d:\\user\\80004960\\桌面\\Flink入门.pptx");

        // File pptFile = new File("d:\\user\\80004960\\桌面\\ppt.ppt");
        // File pptFile = new File("d:\\user\\80004960\\桌面\\MySQL体系结构.ppt");
        File pptFile = new File("d:\\user\\80004960\\桌面\\深入理解Java虚拟机.PPT");
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
                if (shape instanceof HSLFTextShape) {
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
            DrawFactory.getInstance(graphics).fixFonts(graphics);
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

        for (XSLFSlide xslfSlide : slideList) {
            // 解决乱码问题
            List<XSLFShape> shapeList = xslfSlide.getShapes();
            for (XSLFShape shape : shapeList) {
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape sh = (XSLFTextShape) shape;
                    List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();

                    for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
                        List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
                        for (XSLFTextRun xslfTextRun : textRuns) {
                            xslfTextRun.setFontFamily("宋体");
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
            DrawFactory.getInstance(graphics).fixFonts(graphics);
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
        }

    }

}