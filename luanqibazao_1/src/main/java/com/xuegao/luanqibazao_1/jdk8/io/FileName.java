package com.xuegao.luanqibazao_1.jdk8.io;

public class FileName {
    public static void main(String[] args) {
        String fileName1 = "aa.pdf";
        String fileName2 = "aa";

        String delSuffix1 = delSuffix(fileName1);
        System.out.println("1 " + delSuffix1);
        String delSuffix2 = delSuffix(fileName2);
        System.out.println("2 " + delSuffix2);
    }

    public static String delSuffix(String fileName) {
        if (!fileName.contains(".")) {
            return fileName;
        }
        return fileName.substring(0, fileName.lastIndexOf("."));
    }
}
