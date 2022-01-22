package com.xuegao.luanqibazao_1.jdk8.util.map;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.map
 * <br/> @ClassName：HashMap
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/04 23:03
 */
public class HashMapGroup {
    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("1", "2", "3", "4");

        Map<String, List<String>> collect = list.stream().collect(Collectors.groupingBy(new Function<String, String>() {
            @Override
            public String apply(String s) {
                if (s.equals("1")) {
                    return "1";
                } else if (s.equals("2")) {
                    return "1";
                } else if (s.equals("3")) {
                    return "3";
                } else if (s.equals("4")) {
                    return "3";
                } else {
                    return null;
                }
            }
        }));
        for (Map.Entry<String, List<String>> stringListEntry : collect.entrySet()) {
            System.out.println("==========================");
            System.out.println(stringListEntry.getKey() + ":" + stringListEntry.getValue());
            System.out.println("==========================");
        }

    }

}