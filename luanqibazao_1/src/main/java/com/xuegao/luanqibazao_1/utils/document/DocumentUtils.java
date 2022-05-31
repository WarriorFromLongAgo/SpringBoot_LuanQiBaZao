package com.xuegao.luanqibazao_1.utils.document;

public class DocumentUtils {

    /**
     * isDocumentByFileName
     * 是否是压缩包结尾
     *
     * @return boolean
     * @author xuegao
     * @date 2022/6/1 0:38
     */
    public static boolean isDocumentByFileName(String fileName) {
        return fileName.endsWith(".pdf");
    }

    public static void main(String[] args) {


    }
}