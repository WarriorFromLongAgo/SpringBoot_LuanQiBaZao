package com.xuegao.luanqibazao_1.jdk8.util.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.map
 * <br/> @ClassName：HashMap
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/04 23:03
 */
public class HashMapTest {
    public static void main(String[] args) {

    }

    private static void getOrDefault() {
        Map<Integer, Integer> map = new HashMap<>(2);
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


        map.put(1, 1);
        if (Boolean.FALSE.equals(map.containsKey(1))) {

        }
        if (Boolean.TRUE.equals(map.containsKey(1))) {

        }
    }
}