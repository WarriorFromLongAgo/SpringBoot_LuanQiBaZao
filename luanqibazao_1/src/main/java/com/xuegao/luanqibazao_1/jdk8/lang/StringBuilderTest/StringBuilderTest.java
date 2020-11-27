package com.xuegao.luanqibazao_1.jdk8.lang.StringBuilderTest;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.StringBuilderTest
 * <br/> @ClassName：StringBuilderTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/22 13:47
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        // add();
        // add2();
        // append();
        // append2();
        subString();
    }

    public static void add() {
        for (int i = 0; i < 3; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("2");
            stringBuilder.append("2");
            stringBuilder.append("2");
            String aaaa = "a";
            String bbb = stringBuilder + aaaa;
            System.out.println(bbb);
        }
    }

    public static void add2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("1");
        stringBuilder.append("1");
        for (int i = 0; i < 3; i++) {
            String aaaa = "a";
            String s = stringBuilder + aaaa;
            System.out.println(s);
        }
    }

    public static void append() {
        for (int i = 0; i < 3; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("2");
            stringBuilder.append("2");
            stringBuilder.append("2");
            String aaaa = "a";
            String s = stringBuilder.append(aaaa).toString();
            System.out.println(s);
        }
    }

    public static void append2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("1");
        stringBuilder.append("1");
        for (int i = 0; i < 3; i++) {
            String aaaa = "a";
            String s = stringBuilder.append(aaaa).toString();
            System.out.println(s);
        }
    }

    public static void subString() {
        ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 3);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : arrayList) {
            stringBuilder.append(integer).append(",");
        }
        String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
        System.out.println(substring);
    }
}