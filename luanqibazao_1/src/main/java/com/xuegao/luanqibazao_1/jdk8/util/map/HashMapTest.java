package com.xuegao.luanqibazao_1.jdk8.util.map;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.map
 * <br/> @ClassName：HashMap
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/04 23:03
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Set<String>> map = Maps.newHashMap();
        map.put("1", Sets.newHashSet("value1", "value2"));
        System.out.println(map);

        if (map.containsKey("1")) {
            Set<String> strings = map.get("1");
            strings.add("value3");
        }
        System.out.println(map);

        Set<String> keySet = map.keySet();
        System.out.println(keySet);

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