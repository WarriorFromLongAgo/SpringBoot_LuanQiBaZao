package com.xuegao.luanqibazao_1.jdk8.io;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.io
 * <br/> @ClassName：FileTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/28 14:30
 */
public class FileTest {
    public static void main(String[] args) {
        // File file = new File("D:\\user\\6565.545");
        // String file11 = createFile1(file);
        // System.out.println(file11);
        File file1 = new File("D:\\user\\6565.545\\IMG20200811_144945.jpg");
        String file2 = createFile2(file1);
        System.out.println(file2);
    }

    private static String createFile1(File file) {
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);

        String absolutePath1 = file.getParentFile().getAbsolutePath();
        System.out.println(absolutePath1);

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String newFilePath = file.getParentFile().getAbsolutePath() + "\\" + format + "\\";
        File file1 = new File(newFilePath);
        boolean mkdirs = file1.mkdirs();
        if (Boolean.FALSE.equals(mkdirs)) {
            System.out.println("创建文件夹失败");
        }
        return newFilePath;
    }

    private static String createFile2(File file) {
        String absolutePath = file.getParentFile().getAbsolutePath();
        System.out.println(absolutePath);

        String absolutePath1 = file.getParentFile().getParentFile().getAbsolutePath();
        System.out.println(absolutePath1);

        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String newFilePath = file.getParentFile().getParentFile().getAbsolutePath() + "\\" + format + "\\";
        File file1 = new File(newFilePath);
        boolean mkdirs = file1.mkdirs();
        if (Boolean.FALSE.equals(mkdirs)) {
            System.out.println("创建文件夹失败");
        }
        return newFilePath;
    }
}