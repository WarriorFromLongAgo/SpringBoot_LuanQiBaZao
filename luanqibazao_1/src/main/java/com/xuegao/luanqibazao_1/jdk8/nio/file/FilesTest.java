package com.xuegao.luanqibazao_1.jdk8.nio.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.nio.file
 * <br/> @ClassName：FilesTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/10/09 16:12
 */
public class FilesTest {
    public static void main(String[] args) {
        // createFile(Path filePath，FileAttribute attrs) - Files类提供了使用指定路径创建文件的方法。
        // copy(InputStream in，Path target，CopyOption?options)   - 此方法用于将所有字节从指定的输入流复制到指定的目标文件，
        //     并返回读取或写入的字节数作为该参数的long value.LinkOption，具有以下值-
        //     COPY_ATTRIBUTES                - 将属性复制到新文件，如最后修改时间属性。
        //     REPLACE_EXISTING              - 替换现有文件(如果存在)。
        //     NOFOLLOW_LINKS                - 如果文件是符号链接，则复制链接本身而不是链接目标。
        // createDirectories(Path dir， FileAttribute<?>...attrs)  - 该方法用于通过创建所有不存在的父目录来使用给定路径创建目录。
        // delete(Path path)                 - 此方法用于从指定路径中删除文件。
        // exists(Path path)                  - 此方法用于判断文件是否存在于指定路径。
        // readAllBytes(Path path)      - 此方法用于从给定路径的文件中读取所有字节，并返回包含从文件中读取的字节的字节数组。
        // size(Path path)              - 此方法用于获取指定路径上文件的大小(以字节为单位)。
        // write(Path path，byte [] bytes，OpenOption…options) - 此方法用于将字节写入指定路径的文件。


    }

    public static void test0() {
        //initialize Path object
        Path path = Paths.get("D:file.txt");
        //create file
        try {
            Path createdFilePath = Files.createFile(path);
            System.out.println("Created a file at : " + createdFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test1() {
        Path sourceFile = Paths.get("D:file.txt");
        Path targetFile = Paths.get("D:fileCopy.txt");
        try {
            Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.err.format("I/O Error when copying file");
        }
        Path wiki_path = Paths.get("D:fileCopy.txt");
        // Charset charset = Charset.forName("ISO-8859-1");
        Charset charset = StandardCharsets.ISO_8859_1;
        try {
            List<String> lines = Files.readAllLines(wiki_path, charset);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readLine() {
        Path wiki_path = Paths.get("D:file.txt");
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            List<String> lines = Files.readAllLines(wiki_path, charset);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void write() {
        Path path = Paths.get("D:file.txt");
        String question = "To be or not to be?";
        Charset charset = Charset.forName("ISO-8859-1");
        try {
            Files.write(path, question.getBytes());
            List<String> lines = Files.readAllLines(path, charset);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}