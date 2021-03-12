package com.xuegao.video_conver.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.video_conver.pdf
 * <br/> @ClassName：pdfToImage
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/28 13:37
 */
public class pdfToImage {
    private final static Logger log = LoggerFactory.getLogger(pdfToImage.class);

    private static final String pdfPathPptx = "D:\\nfsc\\KMS\\train.homework\\10 Flink入门.pptx";
    // private static final String pdfPathPpt = "d:\\user\\80004960\\桌面\\户口\\教育部学籍在线验证报告_费久猛.pdf";
    private static final String pdfPathPpt = "d:\\user\\80004960\\桌面\\户口\\广州工业大学 研究生.pdf";
    private static final String imagePath = "D:\\nfsc\\KMS\\train.homework\\";

    public static void main(String[] args) throws IOException {
        File pdfFile = new File(pdfPathPpt);
        PDDocument pdfDocument = PDDocument.load(pdfFile);
        int pageCount = pdfDocument.getNumberOfPages();
        PDFRenderer pdfRenderer = new PDFRenderer(pdfDocument);
        List<String> imagePathList = new ArrayList<>();
        String fileParent = pdfFile.getParent();
        for (int pageIndex = 0; pageIndex < pageCount; pageIndex++) {
            String imgPath = fileParent + File.separator + System.currentTimeMillis() + ".png";
            BufferedImage image = pdfRenderer.renderImageWithDPI(pageIndex, 105, ImageType.RGB);
            ImageIO.write(image, "png", new File(imgPath));
            imagePathList.add(imgPath);
            log.info("第{}张生成的图片路径为：{}", pageIndex, imgPath);
        }
        pdfDocument.close();
        System.out.println("============================");
        System.out.println("============================");
        for (String s : imagePathList) {
            System.out.println(s);
        }
    }
}