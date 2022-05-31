package com.xuegao.luanqibazao_1.utils.zip;

public class ZipUtils {
    /**
     * isCompressByFileName
     * 是否是压缩包结尾
     *
     * @return boolean
     * @author xuegao
     * @date 2022/6/1 0:38
     */
    public static boolean isCompressByFileName(String fileName) {
        return fileName.endsWith(".rar") || fileName.endsWith(".zip") || fileName.endsWith(".7z");
    }

    public static void main(String[] args) {

    }
}
