package com.xuegao.luanqibazao_1.jdk8.util.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/12 15:50
 */
public class chuandi {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c");
        List<String> list2 = new ArrayList<>(list);
        list = list.stream().filter("b"::equals).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(list2);

    }
}