package com.xuegao.luanqibazao_1.utils.guava.common.collect;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/14 10:36
 */
public class ListsTest {
    public static void main(String[] args) {
        subListPartition();
    }

    public static List<String> getList() {
        return Lists.newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }

    /**
     * 谷歌对这里进行了封装
     *
     * @author xuegao
     * @date 2022/2/14 10:42
     */
    public static void subListPartition() {
        List<String> list = getList();
        List<List<String>> partition = Lists.partition(list, 3);
        for (List<String> stringList : partition) {
            stringList.add("11");
        }
        System.out.println(partition);
        System.out.println(partition);
    }
}