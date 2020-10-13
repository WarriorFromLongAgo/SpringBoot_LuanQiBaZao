package com.xuegao.video_conver.filedeal;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileUtil {

    private static List<String> filPathLists = new ArrayList<String>();

    private static final String FILE_PATH = "/Users/zxb/Desktop/doc";

    private static final String DST_PATH = "/Users/zxb/Desktop/copyDIR";

    private static final String EXTENSION_NAME = "pdf";

    private static final String FILE_PATH_NAME = "/Users/zxb/Desktop/doc/test.rtf";

    public static void main(String[] args) {
//        List<String> filePathList = getFileUnderFolderCursively(FILE_PATH, EXTENSION_NAME);
//        for (int i = 0; i < filePathList.size(); i++) {
//            System.out.println(filePathList.get(i));
//        }
//        copyFilesUnderFolderCursively(FILE_PATH, EXTENSION_NAME, DST_PATH);
    }

    /**
     * 查找指定路径下指定后缀的所有文件(非递归查找）
     *
     * @param filePath      文件目录
     * @param extensionName 文件扩展名
     */
    public static List<String> getFileUnderFolder(String filePath, String extensionName) {
        List<String> filPathList = new ArrayList<String>();
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        for (File f : fileList) {
            if (f.isFile() && f.getName().endsWith(extensionName)) {
                filPathList.add(f.getAbsolutePath());
            }
        }
        return filPathList;
    }

    /**
     * 查找指定路径下指定后缀的所有文件(递归查找）
     *
     * @param filePath      文件目录
     * @param extensionName 文件扩展名
     */
    public static List<String> getFileUnderFolderCursively(String filePath, String extensionName) {
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        for (File f : fileList) {
            if (f.isFile() && f.getName().endsWith(extensionName)) {
                filPathLists.add(f.getAbsolutePath());
            } else if (f.isDirectory()) {
                getFileUnderFolderCursively(f.getAbsolutePath(), extensionName);
            }
        }
        return filPathLists;
    }

    /**
     * 递归复制指定路径下指定后缀的所有文件到指定目录
     *
     * @param filePath
     * @param extensionName
     */
    public static void copyFilesUnderFolderCursively(String filePath, String extensionName, String dstPath) {
        File file = new File(filePath);
        File[] fileList = file.listFiles();
        for (File f : fileList) {
            if (f.isFile() && f.getName().endsWith(extensionName)) {
                try {
                    FileUtils.copyFileToDirectory(f, new File(dstPath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (f.isDirectory()) {
                copyFilesUnderFolderCursively(f.getAbsolutePath(), extensionName, dstPath);
            }
        }
    }

    /**
     * 读取文件内容
     *
     * @param filePath
     * @param charsetName 编码格式
     * @return
     */
    public static String readFileContent(String filePath, String charsetName) {
        String content = "";
        File file = new File(filePath);
        if (file.exists()) {
            Long fileLength = file.length();
            byte[] fileContent = new byte[fileLength.intValue()];
            try {
                FileInputStream in = new FileInputStream(file);
                in.read(fileContent);
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                content = new String(fileContent, charsetName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 读取文件内容
     * @param filePath
     * @param charsetName
     * @return
     */
    public static ArrayList<String> readFileContentByLine(String filePath, String charsetName) {
        ArrayList<String> list = new ArrayList<String>();
        String str = "";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; // 用于包装InputStreamReader,提高处理性能，因为BufferedReader有缓冲，InputStreamReader则没有

        try {
            fis = new FileInputStream(filePath); // FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis, charsetName);// InputStreamReader是字节流通往字符流的桥梁
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容，封装了一个new
            while ((str = br.readLine()) != null) {
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 判断文件是否存在
     *
     * @param filePath
     * @return
     */
    public static boolean exists(String filePath) {
        boolean exists = false;
        File file = new File(filePath);
        if (file.exists()) {
            exists = true;
        }
        return exists;
    }

    /**
     * 删除指定文件夹
     *
     * @param filePath
     */
    public static void deleteDirectory(String filePath) {
        FileUtils.deleteQuietly(new File(filePath));
    }

    /**
     * 删除指定文件
     * @param filePath
     */
    public static void deleteFile(String filePath) {
        try {
            FileUtils.forceDelete(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// 作者：陈奕迅是信仰
// 链接：https://juejin.im/post/6882312545961852942
// 来源：掘金
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。