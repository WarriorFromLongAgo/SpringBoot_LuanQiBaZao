package com.xuegao.luanqibazao_1.jdk8.text;

import java.text.DecimalFormat;

/**
 * <br/> @ClassName：DecimalFormatTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/6/24 17:27
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        DecimalFormat df   = new DecimalFormat("#.##");

        double d1 = 3.23456;
        double d2 = 0.0;
        double d3 = 2.0;
        double d4 = 9999999.9999999;

        String format = df.format(d1);
        System.out.println(format);
        String format1 = df.format(d2);
        System.out.println(format1);
        String format2 = df.format(d3);
        System.out.println(format2);
        String format4 = df.format(d4);
        System.out.println(format4);
    }
}