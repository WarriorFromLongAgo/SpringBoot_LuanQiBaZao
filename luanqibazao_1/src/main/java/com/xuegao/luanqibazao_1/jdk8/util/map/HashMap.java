package com.xuegao.luanqibazao_1.jdk8.util.map;

import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.map
 * <br/> @ClassName：HashMap
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/04 23:03
 */
public class HashMap {
    public static void main(String[] args) {

    }

    private static void getOrDefault() {
        Map<Integer, Integer> map = new java.util.HashMap<>(2);
        map.put(1, 1);
        Integer orDefault = map.getOrDefault(2, 2);
        System.out.println(orDefault);
        System.out.println(map);
        System.out.println("======================");
        Integer orDefault2 = map.getOrDefault(1, 2);
        System.out.println(orDefault2);
        System.out.println(map);

        // 2
        // {1=1}
        // ======================
        // 1
        // {1=1}
    }
}