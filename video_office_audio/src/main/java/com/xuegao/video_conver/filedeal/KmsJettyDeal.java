package com.xuegao.video_conver.filedeal;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

/**
 * <br/> @PackageName：com.xuegao.video_conver.filedeal
 * <br/> @ClassName：KmsJettyDeal
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/12 19:03
 */
public class KmsJettyDeal {

    private static final String JBOSS_PATH = "jboss-as\\server\\default\\deploy\\kms-mserver.war\\";
    private static final String IDEA_PATH = "kms-mserver\\target\\kms-mserver.war";

    public static void main(String[] args) throws InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = LocalDateTime.now().format(formatter);
        System.out.println("====================================");
        System.out.println(format);

        // 压缩包所在，也就是 idea 的编译目录
        String zipfilePath = "G:\\kms-80004960\\kms-mserver\\target\\kms-mserver.war";
        // Jboss default 目录
        String unZipfilePath = "E:\\IDE\\jboss-as\\server\\default\\deploy\\kms-mserver.war";

        kmsJetty(zipfilePath, unZipfilePath);

        String format1 = LocalDateTime.now().format(formatter);
        System.out.println(format1);
        System.out.println("====================================");
    }

    /**
     * <br/> @Title: 先删除Jboss下的目录文件，然后把idea下的war包直接解压缩过去
     * <br/> @MethodName:  kmsJetty
     * <br/> @param zipfilePath:
     * <br/> @param unZipfilePath:
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/8/12 19:21
     */
    private static void kmsJetty(String zipfilePath, String unZipfilePath) throws InterruptedException {
        if (!unZipfilePath.endsWith("\\")) {
            System.out.println(unZipfilePath);
            unZipfilePath = unZipfilePath + "\\";
            System.out.println(unZipfilePath);
            System.out.println("成功添加目录后缀 \\ ");
        }
        if (!zipfilePath.contains(IDEA_PATH)) {
            System.out.println(" 压缩包所在，也就是 idea 的编译目录 选择异常 ");
            return;
        }
        if (!unZipfilePath.contains(JBOSS_PATH)) {
            System.out.println(" Jboss default 目录 异常，请重新选择目录");
            return;
        }
        try {
            System.out.println(unZipfilePath);
            Boolean aBoolean = deleteAllFile(new File(unZipfilePath));
            System.out.println(" aBoolean = " + aBoolean);
            Thread.sleep(1_000);
            unzip2(zipfilePath, unZipfilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" 已完成操作 ");
    }

    private static Boolean deleteAllFile(File deleteFile) {
        if (null != deleteFile) {
            if (!deleteFile.exists()) {
                return true;
            }
            if (deleteFile.isFile()) {
                // 删除文件
                boolean result = deleteFile.delete();
                int tryCount = 0;
                while (!result && tryCount++ < 10) {
                    System.gc(); // 回收资源
                    result = deleteFile.delete();
                }
            }
            File[] files = deleteFile.listFiles();
            if (null != files) {
                for (File file : files) {
                    deleteAllFile(file);
                }
            }
            boolean delete = deleteFile.delete();
        }
        return true;
    }

    private static void unzip2(String fileAddress, String unZipAddress) throws IOException {
        File file = new File(fileAddress);
        ZipFile zipFile = null;
        try {
            //设置编码格式
            zipFile = new ZipFile(file, "GBK");
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("解压文件不存在!");
        }

        Enumeration<ZipArchiveEntry> enumeration = zipFile.getEntries();
        while (enumeration.hasMoreElements()) {
            ZipArchiveEntry zipArchiveEntry = enumeration.nextElement();
            if (zipArchiveEntry.isDirectory()) {
                String name = zipArchiveEntry.getName();
                name = name.substring(0, name.length() - 1);
                File f = new File(unZipAddress + name);
                f.mkdirs();
            } else {
                File f = new File(unZipAddress + zipArchiveEntry.getName());
                f.getParentFile().mkdirs();
                f.createNewFile();
                InputStream is = zipFile.getInputStream(zipArchiveEntry);
                FileOutputStream fos = new FileOutputStream(f);
                int length = 0;
                byte[] b = new byte[1024];

                while ((length = is.read(b, 0, 1024)) != -1) {
                    fos.write(b, 0, length);
                }
                is.close();
                fos.close();
            }
        }
        if (zipFile != null) {
            zipFile.close();
        }
        // file.deleteOnExit();//解压完以后将压缩包删除
    }
}