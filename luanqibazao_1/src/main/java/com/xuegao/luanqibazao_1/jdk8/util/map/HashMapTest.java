package com.xuegao.luanqibazao_1.jdk8.util.map;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.map
 * <br/> @ClassName：HashMap
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/04 23:03
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        String remove = map.remove("1");
        System.out.println(remove);


        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            map.remove(stringStringEntry.getKey());
        }
        System.out.println(map);
        map.forEach((s, s2) -> map.remove(s));
        System.out.println(map);
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