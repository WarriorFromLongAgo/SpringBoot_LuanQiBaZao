package com.xuegao.luanqibazao_1.jdk8.lamada_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lamada_stream
 * <br/> @ClassName：StreamTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/01 10:48
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> strArrList = new ArrayList<>();
        strArrList.add("1");
        strArrList.add("2");
        strArrList.add("3");
        strArrList.forEach(System.out::println);
        Set<String> collect1 = strArrList.stream().collect(Collectors.toSet());
        long count = strArrList.stream().collect(Collectors.toSet()).stream().count();
        System.out.println(count);

        boolean b = strArrList.stream().allMatch(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return true;
            }
        });
        System.out.println(b);

        String s = strArrList.stream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        }).get();
        System.out.println(s);

    }
}