package com.xuegao.luanqibazao_1.jdk8.lang.string;

public class replace {
    public static String replace(String str, String oldStr, String newStr) {
        // String area = "--/鞍山市/--/辽阳市/--";
        // System.out.println(area);
        // area = area.replace("--/", "");
        str = str.replace(oldStr, newStr);
        // System.out.println(area);
        // area = area.replace("/--", "");
        str = str.replace(oldStr, newStr);
        // System.out.println(area);
        return str.replaceAll(oldStr, newStr);
    }

    public static void main(String[] args) {
        String str = "--/鞍山市/--/辽阳市/--";
        System.out.println(str);
        str = replace(str, "--/", "");
        System.out.println(str);
        str = replace(str, "/--", "");
        System.out.println(str);
    }


}
