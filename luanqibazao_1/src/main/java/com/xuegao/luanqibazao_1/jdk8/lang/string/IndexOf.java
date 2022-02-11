package com.xuegao.luanqibazao_1.jdk8.lang.string;

import org.springframework.util.StringUtils;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/11 16:22
 */
public class IndexOf {
    public static void main(String[] args) {
        String str = "999.99";
        System.out.println(str.indexOf("."));
        System.out.println(str.lastIndexOf("."));
        System.out.println(sssss(str));
        str = "999.9";
        System.out.println(str.indexOf("."));
        System.out.println(str.lastIndexOf("."));
        System.out.println(sssss(str));
        str = "999";
        System.out.println(str.indexOf("."));
        System.out.println(str.lastIndexOf("."));
        System.out.println(sssss(str));


    }

    public static int sssss(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        for (int i = chars.length; i > 0; i--) {
            char aChar = chars[i - 1];
            if (aChar == '.') {
                return index;
            }
            index++;
        }
        return -1;
    }
}