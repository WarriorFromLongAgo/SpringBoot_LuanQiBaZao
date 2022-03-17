package com.xuegao.luanqibazao_1.commonlang3;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/3/12 10:59
 */
public class TestNumberUtils {
    public static void main(String[] args) {
        String str1 = "1211111111111111111111111111113.456";
        String str2 = "-12311111111111111111111111111.456";
        String str3 = "123111111111111111111111111111";
        String str4 = "-12311111111111111111111111111";

        System.out.println("str1 = " + str1);
        System.out.println("NumberUtils.isCreatable(str1) = " + NumberUtils.isCreatable(str1));
        System.out.println("NumberUtils.toInt(str1) = " + NumberUtils.toInt(str1));
        System.out.println("NumberUtils.isDigits(str1) = " + NumberUtils.isDigits(str1));
        System.out.println("NumberUtils.isParsable(str1) = " + NumberUtils.isParsable(str1));

        System.out.println("==============================================");

        System.out.println("str2 = " + str2);
        System.out.println("NumberUtils.isCreatable(str2) = " + NumberUtils.isCreatable(str2));
        System.out.println("NumberUtils.toInt(str2) = " + NumberUtils.toInt(str2));
        System.out.println("NumberUtils.isDigits(str2) = " + NumberUtils.isDigits(str2));
        System.out.println("NumberUtils.isParsable(str2) = " + NumberUtils.isParsable(str2));

        System.out.println("==============================================");

        System.out.println("str3 = " + str3);
        System.out.println("NumberUtils.isCreatable(str3) = " + NumberUtils.isCreatable(str3));
        System.out.println("NumberUtils.toInt(str3) = " + NumberUtils.toInt(str3));
        System.out.println("NumberUtils.isDigits(str3) = " + NumberUtils.isDigits(str3));
        System.out.println("NumberUtils.isParsable(str3) = " + NumberUtils.isParsable(str3));

        System.out.println("==============================================");

        System.out.println("str4 = " + str4);
        System.out.println("NumberUtils.isCreatable(str4) = " + NumberUtils.isCreatable(str4));
        System.out.println("NumberUtils.toInt(str4) = " + NumberUtils.toInt(str4));
        System.out.println("NumberUtils.isDigits(str4) = " + NumberUtils.isDigits(str4));
        System.out.println("NumberUtils.isParsable(str4) = " + NumberUtils.isParsable(str4));
    }
}