package com.xuegao.luanqibazao_1.jdk8.util.list;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/> @ClassName：ListTest
 * <br/> @Description：
 * <br/> @date：2021/6/3 17:27
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i);
        }
        System.out.println(list.size());
        int batchNumber = 200;
        int batch = (list.size() - 1) / batchNumber + 1;
        System.out.println(batch);

        List<String> stringList = new ArrayList<>(1);
        System.out.println(ObjectUtils.isEmpty(stringList));
        System.out.println(org.apache.commons.lang3.ObjectUtils.isEmpty(stringList));

    }
}