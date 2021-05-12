package com.xuegao.luanqibazao_1.jdk8.util.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.stream
 * <br/> @ClassName：FilterTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/9 17:43
 */
public class FilterTest {
    public static void main(String[] args) {
        Date nowDate = new Date();
        List<Date> list = new ArrayList<>();
        // 1620383337000
        list.add(new Date(1620383337000L));
        // 2021-05-08 18:28:57
        list.add(new Date(1620469737000L));
        list.add(nowDate);
        // 2021-05-11 18:28:57
        list.add(new Date(1620728629000L));

        list = list.stream()
                .filter(date -> Boolean.FALSE.equals(date.before(nowDate)))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    private static void extracted() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list = list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        }).collect(Collectors.toList());
        System.out.println(list);
    }
}