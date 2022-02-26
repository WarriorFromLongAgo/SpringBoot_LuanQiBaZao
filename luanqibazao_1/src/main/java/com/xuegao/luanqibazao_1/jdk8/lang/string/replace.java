package com.xuegao.luanqibazao_1.jdk8.lang.string;

import org.apache.commons.lang3.StringUtils;

public class replace {
    // String str = "--/鞍山市/--/辽阳市/--";
    //     System.out.println(str);
    // str = replace(str, "--/", "");
    //     System.out.println(str);
    // str = replace(str, "/--", "");
    //     System.out.println(str);
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

    public static String replace(String str, String newStr, String... oldStrArr) {
        if (StringUtils.isAllBlank(str)) {
            return str;
        }
        // String area = "--/鞍山市/--/辽阳市/--";
        // System.out.println(area);
        // area = area.replace("--/", "");
        // System.out.println(area);
        // area = area.replace("/--", "");
        // str = str.replace(oldStr, newStr);
        // System.out.println(area);
        for (String oldStr : oldStrArr) {
            str = str.replace(oldStr, newStr);
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "--/鞍山市/--/辽阳市/--";
        System.out.println(str);
        str = replace(str, "", "--/", "/--");
        System.out.println(str);
    }


}
