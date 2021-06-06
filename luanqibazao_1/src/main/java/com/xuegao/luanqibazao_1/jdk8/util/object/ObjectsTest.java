package com.xuegao.luanqibazao_1.jdk8.util.object;

import java.util.Objects;

/**
 * <br/> @ClassName：ObjectsTest
 * <br/> @Description：
 * <br/> @date：2021/6/6 12:47
 */
public class ObjectsTest {
    public static void main(String[] args) {

        Object o1 = null;
        Object o2 = null;
        boolean equals = Objects.equals(o1, o2);
        System.out.println(equals);
        o1 = new Object();
        equals = Objects.equals(o1, o2);
        System.out.println(equals);
        equals = o1.equals(o2);
        System.out.println(equals);

    }
}