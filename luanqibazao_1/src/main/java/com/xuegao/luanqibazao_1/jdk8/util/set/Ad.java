package com.xuegao.luanqibazao_1.jdk8.util.set;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/3/4 10:12
 */
public class Ad {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(10);
        boolean a = set.add("a");
        boolean b = set.add("b");
        boolean b1 = set.add("b");
        System.out.println(a);
        System.out.println(b);
        System.out.println(b1);


    }
}