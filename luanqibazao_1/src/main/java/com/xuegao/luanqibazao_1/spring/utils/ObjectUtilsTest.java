package com.xuegao.luanqibazao_1.spring.utils;

import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/13 19:42
 */
public class ObjectUtilsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        Integer[] arr = {};
        Integer integer = null;
        String str1 = null;
        String str2 = "";
        String str3 = "s";
        System.out.println("list = " + ObjectUtils.isEmpty(list));
        System.out.println("set = " + ObjectUtils.isEmpty(set));
        System.out.println("map = " + ObjectUtils.isEmpty(map));
        System.out.println("arr = " + ObjectUtils.isEmpty(arr));
        System.out.println("integer = " + ObjectUtils.isEmpty(integer));
        System.out.println("str1 = " + ObjectUtils.isEmpty(str1));
        System.out.println("str2 = " + ObjectUtils.isEmpty(str2));
        System.out.println("str3 = " + ObjectUtils.isEmpty(str3));
    }
}