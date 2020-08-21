package com.xuegao.video_conver.filedeal;


import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

/**
 * <br/> @PackageName：com.xuegao.video_conver.filedeal
 * <br/> @ClassName：WarDeal
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/12 17:33
 */
public class WarDeal {

    public static void main(String[] args) throws IOException, InterruptedException {
        // File targetFile = new File("G:\\kms-80004960\\kms-mserver\\target\\kms-mserver.war");
        // File jboosDefaultDeployFile = new File("E:\\IDE\\jboss-as\\server\\default\\deploy\\kms-mserver.war");
        //
        // // 删除文件
        // File sourceFileTest = new File("E:\\IMG20200811_144957.jpg");
        // File targetFileTest = new File("E:\\IMG20200811_144957 - 副本.jpg");
        //
        // // 删除文件夹
        // // File testFile = new File("E:\\哈工大哈大三");
        // kmsJetty(sourceFileTest, targetFileTest);


        // File zipfile = new File("E:\\adadaa\\kms-mserver.war");
        // String zipfilePath = "E:\\adadaa\\kms-mserver.war";
        // File unZipfile = new File("E:\\adasdadsadad\\kms-mserver.war\\");
        // String unZipfilePath = "E:\\adasdadsadad\\kms-mserver.war\\";

        // unzip(zipfilePath, unZipfilePath);

        // Boolean aBoolean = deleteAllFile(new File(unZipfilePath));
        // Thread.sleep(5000);
        // unzip2(zipfilePath, unZipfilePath);


        File source = new File("d:\\user\\80004960\\桌面\\深入理解Java虚拟机.PPT");
        String target = "F:\\file\\";
        copy(source, target);
        // copy2(source, target);
        // copy3(source, target);
        // copy4(source, target);
        // copy5(source, target);
    }

    public static Boolean kmsJetty(File targetFile, File jboosDefaultDeployFile) {
        Boolean aBoolean1 = deleteFile(jboosDefaultDeployFile);
        System.out.println(" jboosDefaultDeployFile = " + aBoolean1);
        // File targetFileTest = new File("E:\\IMG20200811_144957 - 副本 1111 .jpg");
        Boolean aBoolean = copyFile(targetFile, jboosDefaultDeployFile);
        System.out.println("");
        return true;
    }

    private static Boolean copyFile(File source, File target) {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(target).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputChannel != null) {
                try {
                    inputChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputChannel != null) {
                try {
                    outputChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public static void copy(File source, String target) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(target + source.getName()), System.getProperty("file.encoding")));

        //一致，防止中文乱码
        //循环按行读取文件

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            bufferedWriter.write(line); //按行写入内容
            bufferedWriter.newLine(); //换行
            bufferedWriter.flush();   //避免文件太大刷新不及时
        }
        String encoding = new OutputStreamWriter(new FileOutputStream(target + source.getName()), System.getProperty("file.encoding")).getEncoding();
        System.out.println(encoding);
    }

    public static void copy2(File source, String target) throws IOException {
        InputStream inputStream = new FileInputStream(source);
        byte[] buffer = new byte[1024];
        int len;
        FileOutputStream outputStream = new FileOutputStream(target + source.getName());
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,
                System.getProperty("file.encoding"));

        while ((len = inputStream.read(buffer)) > 0) {
            outputStreamWriter.write(new String(buffer, StandardCharsets.UTF_8), 0, len);
            outputStreamWriter.flush();
        }
    }

    public static void copy3(File source, String target) throws IOException {
        // 可以使用
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target + source.getName()));
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        bis.close();
        bos.close();
    }

    public static void copy4(File source, String target) throws IOException {
        // 可以使用
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target + source.getName()));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bis.close();
        bos.close();
    }

    public static void copy5(File source, String target) throws IOException {
        // 可以使用
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target + source.getName()));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            String s1 = new String(buffer, 0, len, StandardCharsets.UTF_8);
            String s2 = new String(buffer, 0, len);
            System.out.println(s1);
            System.out.println(s2);
            bos.write(buffer, 0, len);
        }
        bis.close();
        bos.close();
    }

    public static void copy6(File source, String target) throws IOException {

    }


    private static Boolean deleteFile(File deleteFile) {
        if (null != deleteFile) {
            if (!deleteFile.exists()) {
                System.out.println(" 文件不存在 ");
                return true;
            }
            if (deleteFile.isFile()) {
                // 删除文件
                boolean delete = deleteFile.delete();
                System.out.println(" 删除文件成功 = " + delete);
                int tryCount = 0;
                while (!delete && tryCount++ < 10) {
                    System.gc(); // 回收资源
                    delete = deleteFile.delete();
                }
            }
        }
        return true;
    }

    private static Boolean deleteAllFile(File deleteFile) {
        if (null != deleteFile) {
            if (!deleteFile.exists())
                return true;
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
                for (int i = 0; i < files.length; i++) {
                    deleteAllFile(files[i]);
                }
            }
            boolean delete = deleteFile.delete();
        }
        return true;
    }

    private static Boolean unZipFile(File zipFile) {

        return true;
    }

    public static void unzip(String warPath, String unzipPath) {
        File warFile = new File(warPath);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(warFile));
            ArchiveInputStream inputStream = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.JAR,
                    bufferedInputStream);

            JarArchiveEntry entry = null;
            while ((entry = (JarArchiveEntry) inputStream.getNextEntry()) != null) {
                if (entry.isDirectory()) {
                    new File(unzipPath, entry.getName()).mkdir();
                } else {
                    OutputStream outputStream = new FileOutputStream(new File(unzipPath, entry.getName()));
                    IOUtils.copy(inputStream, outputStream);
                    outputStream.close();
                }
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("未找到war文件");
        } catch (ArchiveException e) {
            e.printStackTrace();
            System.err.println("不支持的压缩格式");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("文件写入发生错误");
        }
    }

    public static void unzip2(String fileAddress, String unZipAddress) throws IOException {
        //解压zip的包
        //zip文件路径（路径格式如：C:\\Users\\45335\\Desktop\\testZip.zip）
        // String fileAddress = "E:\\adadaa\\kms-mserver.war";
        //zip文件解压路径
        // String unZipAddress = "E:\\adasdadsadad\\kms-mserver.war\\";
        //去目录下寻找文件
        File file = new File(fileAddress);
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(file, "GBK");//设置编码格式
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

    public static void createNewFile() {

    }
}