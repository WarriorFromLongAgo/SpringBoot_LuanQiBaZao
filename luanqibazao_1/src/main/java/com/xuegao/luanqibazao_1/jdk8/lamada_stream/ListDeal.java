package com.xuegao.luanqibazao_1.jdk8.lamada_stream;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/4/13 10:45
 */
public class ListDeal {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3", "4", "5");
        list.stream()
                .map(String::toUpperCase)
                .map(Integer::parseInt)
                .filter(integer -> integer > 3)
                .forEach(System.out::println);
    }

    // 方法函数传递
    // public int batchAdd(List<T> reqList, Consumer<T> saveHandle){
    //     for (T req : reqList) {
    //         if(saveHandle != null){
    //             saveHandle.accept(req);
    //         }
    //     }
    //     return insertCount;
    // }
}