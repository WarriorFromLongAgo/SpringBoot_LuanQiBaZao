package com.xuegao.luanqibazao_1.utils.list;

import com.google.common.collect.Lists;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.util.List;

public class ListMyUtils {

    public static <T> List<List<T>> split(List<T> list, int size) {
        if (ObjectUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }
        return Lists.partition(list, size);
    }

    /**
     * list转数组
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T[] listToArray(List<T> list) {
        if (list!=null && list.size()>0) {
            return list.toArray((T[]) Array.newInstance(list.get(0).getClass(), list.size()));
        }
        return null;
    }

}