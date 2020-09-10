package com.xuegao.video_conver.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.ppt
 * <br/> @ClassName：PptSpli
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/10 14:37
 */
public class PptSplit {
    public static void main(String[] args) {
        // File pptxFile = new File("d:\\user\\80004960\\桌面\\pptx.pptx");
        File pptxFile = new File("d:\\user\\80004960\\桌面\\仙鹤中国风潮PPT模板.pptx");

        // File pptFile = new File("d:\\user\\80004960\\桌面\\MySQL体系结构.ppt");
        File pptFile = new File("d:\\user\\80004960\\桌面\\10 MySQL体系结构 - 副本.ppt");
        String newFile = "F:\\file\\";

        // long l = System.currentTimeMillis();
        // pptToImageHdmi1(pptFile, newFile);
        // long l1 = System.currentTimeMillis();
        // System.out.println("总共 = " + (l1 - l));

        long l22 = System.currentTimeMillis();
        pptxToImageHdmi(pptxFile, newFile);
        long l222 = System.currentTimeMillis();
        System.out.println("总共 = " + (l222 - l22));

    }

    private static void pptxToImageHdmi(File pptxFile, String newFile) {
        FileInputStream inputStream = null;
        StringBuilder ipFilePath = new StringBuilder();
        try {
            inputStream = new FileInputStream(pptxFile.getAbsolutePath());
            XMLSlideShow xmlSlideShow = new XMLSlideShow(inputStream);
            // 获取大小
            Dimension pageSize = xmlSlideShow.getPageSize();
            // 获取幻灯片
            List<XSLFSlide> slideList = xmlSlideShow.getSlides();
            inputStream.close();

            XMLSlideShow newPptx = new XMLSlideShow();
            for (int i = 0; i < slideList.size(); i++) {
                XSLFSlide xslfSlide = slideList.get(i);
                newPptx.createSlide().importContent(xslfSlide);
            }
            newPptx.write(new FileOutputStream("F:\\file\\仙鹤中国风潮PPT模板_java.pptx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}