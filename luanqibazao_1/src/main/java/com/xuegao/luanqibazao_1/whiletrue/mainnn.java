package com.xuegao.luanqibazao_1.whiletrue;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.whiletrue
 * <br/> @ClassName：mainnn
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2022/4/30 15:04
 */
public class mainnn {
    public static void main(String[] args) {
        List<String> stringList = checkRepeat(Lists.newArrayList("10,20", "10,30", "10,30"));
        System.out.println(stringList);
    }

    public static <T> List<T> checkRepeat(List<T> list) {
        Map<T, Integer> collect = list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, new BinaryOperator<Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        System.out.println(integer + "," + integer2);
                        return integer + integer2;
                    }
                }));
        System.out.println(collect);

        return list.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream() // Set<Entry>转换为Stream<Entry>
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList()); // 转化为 List
    }
}