package com.xuegao.luanqibazao_1.jdk8.lang.string;

/**
 * @version 1.0
 * @date 2021/11/19 20:24
 */
public class spli {
    public static void main(String[] args) {
        String str = "1637320531042-crm3rdc4_1637324496470";
        String[] split = str.split("[_]");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }
}