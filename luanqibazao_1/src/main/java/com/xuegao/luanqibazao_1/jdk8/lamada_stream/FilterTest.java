package com.xuegao.luanqibazao_1.jdk8.lamada_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lamada_stream
 * <br/> @ClassName：FilterTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/26 13:47
 */
public class FilterTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("1");
        strList.add("1");
        strList.add("2");
        strList.add("2");
        strList.add("2");
        List<String> collect = strList.stream().filter("2"::equals).collect(Collectors.toList());
        System.out.println(collect);

    }
}