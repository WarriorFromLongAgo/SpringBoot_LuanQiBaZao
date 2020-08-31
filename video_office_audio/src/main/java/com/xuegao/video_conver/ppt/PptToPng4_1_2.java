package com.xuegao.video_conver.ppt;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
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
 * <br/> @ClassName：PptToPng4_1_2
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/31 21:44
 */
public class PptToPng4_1_2 {
    private static final Logger log = LoggerFactory.getLogger(pptToImageHdmi.class);
    private static final String FILE_MODULE_HEAD = "D:\\nfsc\\KMS\\train.homework\\";

    public static void main(String[] args) throws IOException {
        // File pptxFile = new File("d:\\user\\80004960\\桌面\\pptx.pptx");
        File pptxFile = new File("d:\\user\\80004960\\桌面\\仙鹤中国风潮PPT模板 - 副本.pptx");

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

    private static void pptToImageHdmi1(File pptFile, String newFile) {

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

            for (XSLFSlide xslfSlide : slideList) {
                // 根据幻灯片大小生成图片
                BufferedImage bufferedImage = new BufferedImage(pageSize.width, pageSize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = bufferedImage.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pageSize.width, pageSize.height));
                // 最核心的代码
                xslfSlide.draw(graphics);

                String fileSaveName = System.currentTimeMillis() + ".png";
                String fullPath = FILE_MODULE_HEAD + fileSaveName;
                ImageIO.write(bufferedImage, "png", new File(fullPath));
            }
        } catch (Exception e) {
            System.out.println();
        }
    }


}