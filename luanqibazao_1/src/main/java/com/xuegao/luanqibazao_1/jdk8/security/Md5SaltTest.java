package com.xuegao.luanqibazao_1.jdk8.security;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.security
 * <br/> @ClassName：Md5SaltTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/02 12:34
 */
public class Md5SaltTest {
    private static String salt = "123";

    public static void main(String[] args) {
        String qq23612244896 = Md5Test.string2MD5("qq23612244896");
        System.out.println(qq23612244896);
        String s = Md5Test.convertMD5(Md5Test.convertMD5("qq23612244896"));
        System.out.println(s);

        String base64 = Base64Test.stringToBase64("qq23612244896");
        System.out.println(base64);
        String string = Base64Test.base64ToString(base64);
        System.out.println(string);

        String s2 = Md5Test.string2MD5(base64 + "123");
        System.out.println(s2);
        String s3 = Md5Test.string2MD5("123" + s2);
        System.out.println(s3);

        String s4 = Md5Test.convertMD5(s3);
        System.out.println(s4);
        String s5 = Md5Test.convertMD5(s4);
        System.out.println(s5);
        String s6 = Md5Test.convertMD5(s5);
        System.out.println(s6);

        String s1 = Md5Test.convertMD5(Md5Test.convertMD5("qq23612244896" + "123"));
        System.out.println(s1);

        String substring = s1.substring(0, s1.indexOf("123"));
        System.out.println(substring);

        String s7 = Md5Test.convertMD5("123" + Md5Test.convertMD5("qq23612244896" + "123"));
        System.out.println(s7);

        String s8 = Md5Test.convertMD5(s7);
        System.out.println(s8);

        String substring1 = s8.substring(3);
        System.out.println(substring1);

        String s9 = Md5Test.convertMD5(substring1);
        System.out.println(s9);

    }
}