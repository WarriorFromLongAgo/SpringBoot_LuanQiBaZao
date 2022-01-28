package com.xuegao.luanqibazao_1.jdk8.util.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/1/28 11:50
 */
public class NullList {
    public static void main(String[] args) {
        Object o = null;
        List<Object> objects = Arrays.asList(o);
        List<Object> objects2 = Collections.singletonList(o);
        System.out.println(objects);
        System.out.println(objects.size());
        System.out.println(objects2);
        System.out.println(objects2.size());

        for (Object object : objects) {
            System.out.println(object.toString());
        }

    }
}