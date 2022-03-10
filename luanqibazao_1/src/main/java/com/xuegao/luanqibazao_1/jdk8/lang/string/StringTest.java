package com.xuegao.luanqibazao_1.jdk8.lang.string;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.string
 * <br/> @ClassName：StringTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/20 15:08
 */
public class StringTest {
    public static final String MATCHES_CHAR_AND_WORD = "[A-Za-z0-9\\u4e00-\\u9fa5]+";
    
    public static void main(String[] args) {

    }

    private static void extracted4() {
        String a = "1.2";
        String b = "1-2";
        String c = "1,2";
        boolean contains = a.contains(".");
        System.out.println(contains);
        contains = b.contains(".");
        System.out.println(contains);
        contains = c.contains(".");
        System.out.println(contains);
    }


    private static void extracted3() {
        boolean match = match("123", MATCHES_CHAR_AND_WORD);
        System.out.println(match);
        match = match("aaa", MATCHES_CHAR_AND_WORD);
        System.out.println(match);
        match = match("AA", MATCHES_CHAR_AND_WORD);
        System.out.println(match);
        match = match("aa!", MATCHES_CHAR_AND_WORD);
        System.out.println(match);
        match = match(" ", MATCHES_CHAR_AND_WORD);
        System.out.println(match);
        match = match("d啊爱德华", MATCHES_CHAR_AND_WORD);
        System.out.println(match);
    }

    public static boolean match(String str, String regex) {
        if (StringUtils.isBlank(str)) {
            return true;
        } else {
            return str.matches(regex);
        }
    }

    private static void subString() {
        String aaa = "-0755-021-020-022-";
        System.out.println(aaa);
        if (aaa.startsWith("-")) {
            aaa = aaa.substring(1);
            System.out.println(aaa);
            String s = trimAreaCodeSeparator("--0027--");
        }
    }

    private static void extracted2() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(1);
        }
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());

    }

    private static void extracted1() {
        String join = String.join("-", "a", "b");
        System.out.println(join);
    }

    private static void extracted() {
        String a = "12";
        if (StringUtils.isBlank(a)) {
            System.out.println("      aaaaaaa           ");
        } else {
            String substring = a.substring(0, a.length() - 1);
            System.out.println("substring = " + substring);
        }


        String strArr = "1,2,3";

        List<String> split = split(strArr);
        System.out.println(split);

        strArr = "";
        List<String> split1 = split(strArr);
        System.out.println(split1);

        strArr = null;
        List<String> split2 = split(strArr);
        System.out.println(split2);
    }

    private static List<String> split(String split) {
        if (StringUtils.isBlank(split)) {
            return new ArrayList<>();
        }
        return Arrays.asList(split.split(","));
    }

    private static String trimAreaCodeSeparator(String areaCode){
        areaCode = areaCode.replaceAll("^-*", "");
        System.out.println("111 = "+areaCode);
        areaCode = areaCode.replaceAll("-+$", "");

        System.out.println("222 = "+areaCode);
        return areaCode;
    }

    public static String trimEndZeroAndSpot(String str) {
        str = str.replaceAll(0 + "+$", "");
        str = str.replaceAll("\\." + "+$", "");
        return str;
    }

}