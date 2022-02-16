package com.xuegao.luanqibazao_1.jdk8.lang.string;

/**
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/2/11 15:08
 */
public class StringLength {
    public static final int LENGTH = 100;
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            stringBuilder.append(1);
        }
        String s = stringBuilder.toString();
        System.out.println(s.length());
        System.out.println(s);
    }
}