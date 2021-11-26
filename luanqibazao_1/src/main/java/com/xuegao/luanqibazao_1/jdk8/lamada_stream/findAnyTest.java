package com.xuegao.luanqibazao_1.jdk8.lamada_stream;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @date 2021/11/25 21:08
 */
public class findAnyTest {
    public static void main(String[] args) {
        String[] str1 = {"a", "c", "d", "e"};
        String[] str2 = {"f", "b"};
        Set<String> dbSet = Arrays.stream(str1).collect(Collectors.toSet());
        Set<String> dbSet2 = Arrays.stream(str2).collect(Collectors.toSet());
        boolean b = dbSet.stream().anyMatch(dbSet2::contains);
        System.out.println(b);

    }
}