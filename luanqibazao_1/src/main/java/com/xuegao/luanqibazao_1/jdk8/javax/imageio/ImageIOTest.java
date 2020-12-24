package com.xuegao.luanqibazao_1.jdk8.javax.imageio;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.javax.imageio
 * <br/> @ClassName：ImageIOTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/24 17:23
 */
public class ImageIOTest {
    private static int DPI = 300;

    public static void main(String[] args) {
        String path = "G:\\1.jpg";
        File file = new File(path);
        handleDpi(file, DPI, DPI);
    }

    /**
     * 改变图片DPI
     *
     * @param file
     * @param xDensity
     * @param yDensity
     */
    public static void handleDpi(File file, int xDensity, int yDensity) {
        try {
            BufferedImage image = ImageIO.read(file);
            JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(new FileOutputStream(file));
            JPEGEncodeParam jpegEncodeParam = jpegEncoder.getDefaultJPEGEncodeParam(image);
            jpegEncodeParam.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
            jpegEncoder.setJPEGEncodeParam(jpegEncodeParam);
            jpegEncodeParam.setQuality(0.75f, false);
            jpegEncodeParam.setXDensity(xDensity);
            jpegEncodeParam.setYDensity(yDensity);
            jpegEncoder.encode(image, jpegEncodeParam);
            image.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}