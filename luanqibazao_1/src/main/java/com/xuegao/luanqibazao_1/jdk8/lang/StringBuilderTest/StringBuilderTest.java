package com.xuegao.luanqibazao_1.jdk8.lang.StringBuilderTest;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.StringBuilderTest
 * <br/> @ClassName：StringBuilderTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/22 13:47
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        add();
        add2();
        append();
        append2();
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
}