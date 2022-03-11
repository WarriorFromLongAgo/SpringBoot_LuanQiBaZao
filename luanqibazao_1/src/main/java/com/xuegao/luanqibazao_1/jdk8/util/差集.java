package com.xuegao.luanqibazao_1.jdk8.util;

import java.util.*;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util
 * <br/> @ClassName：差集
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/19 15:41
 */
public class 差集 {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("c");
        stringList.add("d");

        Set<String> stringList3 = new HashSet<>(Arrays.asList("a,b,c".split(",")));
        stringList.removeAll(stringList3);
        System.out.println("差集1: " + stringList);

        stringList3.removeAll(stringList);
        System.out.println("差集1: " + stringList3);
        // 差集1: [d]
        // 差集1: [a, b, c]
    }
}