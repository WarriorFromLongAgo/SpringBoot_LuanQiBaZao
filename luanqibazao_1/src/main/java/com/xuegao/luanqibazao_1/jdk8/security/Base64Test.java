package com.xuegao.luanqibazao_1.jdk8.security;

import java.util.Base64;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.security
 * <br/> @ClassName：Base64
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/02 11:41
 */
public class Base64Test {
    public static void main(String[] args) {
        String s = "xuegao";
        System.out.println(s);
        String s1 = stringToBase64(s);
        System.out.println(s1);
        String s2 = base64ToString(s1);
        System.out.println(s2);

    }

    public static String base64ToString(String str){
        byte[] decode = Base64.getDecoder().decode(str);
        String s = new String(decode);
        return s;
    }

    public static String stringToBase64(String str){
        String s = Base64.getEncoder().encodeToString(str.getBytes());
        return s;
    }
}