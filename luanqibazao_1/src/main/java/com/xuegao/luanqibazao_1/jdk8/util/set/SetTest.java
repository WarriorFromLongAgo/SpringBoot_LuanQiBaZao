package com.xuegao.luanqibazao_1.jdk8.util.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.set
 * <br/> @ClassName：SetTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/19 11:49
 */
public class SetTest {
    public static void main(String[] args) {
        testAdd();

    }

    private static void testAdd() {
        List<String> idStrList = new ArrayList<>();
        idStrList.add("1");
        idStrList.add("2");
        idStrList.add("3");

        Set<String> idStrSet1 = new HashSet<>();
        idStrSet1.add("1");
        idStrSet1.add("3");

        Set<String> idStrSet2 = new HashSet<>();
        idStrSet2.add("1");
        idStrSet2.add("2");

        boolean b = idStrSet2.containsAll(idStrSet1);
        System.out.println("1 " + b);

        boolean contains = idStrSet2.contains(idStrSet1);
        System.out.println("2 " + contains);

        boolean b1 = idStrSet2.contains(idStrList);
        System.out.println("3 " + b1);
    }
}