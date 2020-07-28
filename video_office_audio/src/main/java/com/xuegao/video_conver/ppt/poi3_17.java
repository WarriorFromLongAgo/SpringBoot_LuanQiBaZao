package com.xuegao.video_conver.ppt;

import com.google.common.collect.Lists;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.hslf.model.HeadersFooters;
import org.apache.poi.hslf.record.*;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.sl.usermodel.Resources;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.ppt
 * <br/> @ClassName：poi3_17
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/28 11:43
 */
public class poi3_17 {
    public static void main(String[] args) throws IOException {
        File pptxFile = new File("d:\\user\\80004960\\桌面\\pptx.pptx");
        // File pptFile = new File("d:\\user\\80004960\\桌面\\ppt.ppt");
        File pptFile = new File("d:\\user\\80004960\\桌面\\MySQL体系结构.ppt");
        String newFile = "F:\\file\\";
        // pptConvertPng3(pptFile, newFile);
        pptConvertPng5(pptFile, newFile);
    }

    public static void checkTargetAddress(String targetAddress) {
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
    }

    public static ByteArrayOutputStream gainBufferdImageStream(Integer width, Integer height, Slide slide) {
        int imageWidth = (int) Math.ceil(width * 2);
        int imageHeight = (int) Math.ceil(height * 2);
        BufferedImage img = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.setToScale(2, 2);
        Graphics2D graphics = img.createGraphics();
        graphics.setPaint(Color.WHITE);
        // DrawFactory.getInstance(graphics).fixFonts(graphics);
        graphics.fill(new Rectangle2D.Float(0, 0, width, height));
        graphics.setTransform(affineTransform);
        // default rendering options
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics.scale(1, 1);

        // draw stuff
        slide.draw(graphics);
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "png", bs);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            graphics.dispose();
            img.flush();
        }
        return bs;
    }

    public static void handlePptPageDetail(List<Shape> shapeList) {
        for (Shape shape : shapeList) {
            if (shape instanceof XSLFTextShape) {
                XSLFTextShape txtshape = (XSLFTextShape) shape;
                for (XSLFTextParagraph textPara : txtshape.getTextParagraphs()) {
                    List<XSLFTextRun> textRunList = textPara.getTextRuns();
                    for (XSLFTextRun textRun : textRunList) {
                        textRun.setFontFamily("宋体");
                    }
                }
            } else if (shape instanceof HSLFTextShape) {
                HSLFTextShape hslfTextShape = (HSLFTextShape) shape;
                for (HSLFTextParagraph textParagraph : hslfTextShape.getTextParagraphs()) {
                    List<HSLFTextRun> textRuns = textParagraph.getTextRuns();
                    for (HSLFTextRun hslfTextRun : textRuns) {
                        hslfTextRun.setFontFamily("宋体");
                    }
                }
            }
        }
    }

    // 3.14
    private static int pptConvertPng5(File file, String outputFile) throws IOException {
        checkTargetAddress(file.getAbsolutePath());
        String pptAddress = file.getAbsolutePath();
        String pptDetailPair = "PPT";

        InputStream inputStream = new FileInputStream(file);
        SlideShow slideShow = new HSLFSlideShow(inputStream);
        List<ByteArrayOutputStream> picStreamList = new ArrayList<>();

        Dimension pageSize = slideShow.getPageSize();
        List<Slide> slideList = slideShow.getSlides();

        for (Slide slide : slideList) {
            List shapes = slide.getShapes();
            for (int i = 0; i < shapes.size(); i++) {
                Shape shape = (Shape) shapes.get(i);
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape txtshape = (XSLFTextShape) shape;
                    for (XSLFTextParagraph textPara : txtshape.getTextParagraphs()) {
                        List<XSLFTextRun> textRunList = textPara.getTextRuns();
                        for (XSLFTextRun textRun : textRunList) {
                            textRun.setFontFamily("宋体");
                        }
                    }
                } else if (shape instanceof HSLFTextShape) {
                    HSLFTextShape hslfTextShape = (HSLFTextShape) shape;
                    for (HSLFTextParagraph textParagraph : hslfTextShape.getTextParagraphs()) {
                        List<HSLFTextRun> textRuns = textParagraph.getTextRuns();
                        for (HSLFTextRun hslfTextRun : textRuns) {
                            hslfTextRun.setFontFamily("宋体");
                        }
                    }
                }
            }

            ByteArrayOutputStream byteArrayOutputStream = gainBufferdImageStream(
                    (int) pageSize.getWidth(),
                    (int) pageSize.getHeight(),
                    slide);

            picStreamList.add(byteArrayOutputStream);
        }

        for (ByteArrayOutputStream picStream : picStreamList) {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(picStream.toByteArray()));
            try {
                File picFile = new File(outputFile + System.currentTimeMillis() + ".png");
                ImageIO.write(bufferedImage, "png", picFile);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                bufferedImage.flush();
            }
        }
        return 0;
    }

    public static List<String> pptConvertPng33(File file, String outputFolder) {
        List<String> newFileList = Lists.newArrayList();
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        HSLFSlideShow SlideShow = null;

        try {
            inputStream = new FileInputStream(file);
            HSLFSlideShow hslfSlideShow = new HSLFSlideShow(inputStream);
            Dimension pageSize = hslfSlideShow.getPageSize();
            List<HSLFSlide> slideList = hslfSlideShow.getSlides();
            inputStream.close();

            int i = 0;
            for (HSLFSlide hslfSlide : slideList) {
                BufferedImage img = new BufferedImage(pageSize.width, pageSize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width, pageSize.height));
                hslfSlide.draw(graphics);
                FileOutputStream out = new FileOutputStream("slide-3.17-" + i + ".png");
                ImageIO.write(img, "png", out);
                out.close();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileList;
    }

    public static List<String> pptConvertPng3(File file, String outputFolder) {
        List<String> newFileList = Lists.newArrayList();
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        StringBuilder content = null;
        try {
            inputStream = new FileInputStream(file);
            HSLFSlideShow hslfSlideShow = new HSLFSlideShow(inputStream);
            List<HSLFSlide> slideList = hslfSlideShow.getSlides();
            inputStream.close();
            content = new StringBuilder();

            Document documentRecord = hslfSlideShow.getDocumentRecord();
            System.out.println("documentRecord = " + documentRecord);
            System.out.println("=======================================");


            HSLFObjectData[] embeddedObjects = hslfSlideShow.getEmbeddedObjects();
            System.out.println("embeddedObjects = " + Arrays.toString(embeddedObjects));
            System.out.println("=======================================");

            Record[] mostRecentCoreRecords = hslfSlideShow.getMostRecentCoreRecords();
            System.out.println("mostRecentCoreRecords = " + Arrays.toString(mostRecentCoreRecords));
            System.out.println("=======================================");

            List<HSLFNotes> notesList = hslfSlideShow.getNotes();
            System.out.println("notesList = " + notesList);
            System.out.println("=======================================");

            HeadersFooters notesHeadersFooters = hslfSlideShow.getNotesHeadersFooters();
            System.out.println("notesHeadersFooters = " + notesHeadersFooters);
            System.out.println("=======================================");

            int numberOfFonts = hslfSlideShow.getNumberOfFonts();
            System.out.println("numberOfFonts = " + numberOfFonts);
            System.out.println("=======================================");

            Dimension pageSize = hslfSlideShow.getPageSize();
            System.out.println("pageSize = " + pageSize);
            System.out.println("=======================================");

            List<HSLFPictureData> pictureData = hslfSlideShow.getPictureData();
            System.out.println("pictureData = " + pictureData);
            System.out.println("=======================================");

            Resources resources = hslfSlideShow.getResources();
            System.out.println("resources = " + resources);
            System.out.println("=======================================");

            HSLFSoundData[] soundData = hslfSlideShow.getSoundData();
            System.out.println("soundData = " + Arrays.toString(soundData));
            System.out.println("=======================================");

            List<HSLFTitleMaster> titleMasters = hslfSlideShow.getTitleMasters();
            System.out.println("titleMasters = " + titleMasters);
            System.out.println("=======================================");

            // HSLFSlideShowImpl slideShowImpl = hslfSlideShow.getSlideShowImpl();
            // System.out.println("slideShowImpl = " + slideShowImpl);
            System.out.println("=======================================");

            List<HSLFSlideMaster> slideMasters = hslfSlideShow.getSlideMasters();
            System.out.println("slideMasters = " + slideMasters);
            System.out.println("=======================================");

            System.out.println("=======================================");
            System.out.println("=======================================");
            System.out.println("=======================================");
            System.out.println("=======================================");
            System.out.println("=======================================");

            for (HSLFSlide hslfSlide : slideList) {
                HSLFBackground background = hslfSlide.getBackground();
                System.out.println("background = " + background);
                System.out.println("=======================================");

                ColorSchemeAtom colorScheme = hslfSlide.getColorScheme();
                System.out.println("colorScheme = " + colorScheme);
                System.out.println("=======================================");


                HSLFMasterSheet masterSheet = hslfSlide.getMasterSheet();
                System.out.println("masterSheet = " + masterSheet);
                System.out.println("=======================================");

                HSLFNotes notes = hslfSlide.getNotes();
                System.out.println("notes = " + notes);
                System.out.println("=======================================");

                StyleTextProp9Atom[] numberedListInfo = hslfSlide.getNumberedListInfo();
                System.out.println("numberedListInfo = " + Arrays.toString(numberedListInfo));
                System.out.println("=======================================");

                // Slide slideRecord = hslfSlide.getSlideRecord();
                // System.out.println("slideRecord = " + slideRecord);
                System.out.println("=======================================");

                EscherTextboxWrapper[] textboxWrappers = hslfSlide.getTextboxWrappers();
                System.out.println("textboxWrappers = " + Arrays.toString(textboxWrappers));
                System.out.println("=======================================");

                List<List<HSLFTextParagraph>> textParagraphs = hslfSlide.getTextParagraphs();
                for (List<HSLFTextParagraph> textParagraph : textParagraphs) {
                    for (HSLFTextParagraph hslfTextRuns : textParagraph) {
                        System.out.println("hslfTextRuns = " + hslfTextRuns);
                        content.append(hslfTextRuns);
                    }
                }
                System.out.println("=======================================");

                String title = hslfSlide.getTitle();
                System.out.println("title = " + title);
                System.out.println("=======================================");

                PPDrawing ppDrawing = hslfSlide.getPPDrawing();
                System.out.println("ppDrawing = " + ppDrawing);
                System.out.println("=======================================");

                String programmableTag = hslfSlide.getProgrammableTag();
                System.out.println("programmableTag = " + programmableTag);
                System.out.println("=======================================");

                List<HSLFShape> shapes = hslfSlide.getShapes();
                for (HSLFShape shape : shapes) {
                    System.out.println("shape = " + shape);
                }
                System.out.println("=======================================");

                SheetContainer sheetContainer = hslfSlide.getSheetContainer();
                System.out.println("sheetContainer = " + sheetContainer);
                System.out.println("=======================================");

                HSLFSlideShow slideShow = hslfSlide.getSlideShow();
                System.out.println("slideShow = " + slideShow);
                System.out.println("=======================================");

            }

            System.out.println(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        return newFileList;
    }
}


