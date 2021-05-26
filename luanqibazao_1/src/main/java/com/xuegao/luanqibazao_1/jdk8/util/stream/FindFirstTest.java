package com.xuegao.luanqibazao_1.jdk8.util.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * TODO 类功能描述
 * <br/> @ClassName：FindFirstTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/26 17:59
 */
public class FindFirstTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("1");
        strList.add("2");
        strList.add("3");
        Optional<String> first = strList.stream().findFirst();
        if (first.isPresent()) {
            String s = first.get();
            System.out.println(s);
        }
    }
}