package com.xuegao.luanqibazao_1.jdk8.util.regex;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@(N|F|D).*\n\s*

// (.+)
// /** $1 */

/**
 * <br/> @ClassName：PatternTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/27 15:28
 */
public class PatternTest {
    static Pattern pattern = Pattern.compile("^[2-9]\\d{3,9}(\\.[0-9]{1,2})?$");

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 10000; i < 30000; i++) {
            list.add(String.valueOf(i));
        }
        List<String> aaaa = aaaa(list);
        List<String> bbbb = bbbb(list);
        printList(aaaa);
        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");
        printList(bbbb);
    }

    private static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> aaaa(List<String> list) {
        List<String> stringList = Lists.newArrayList();
        long start = System.currentTimeMillis();
        for (String s : list) {
            Matcher matcher = pattern.matcher(s);
            stringList.add(s + "====" + matcher.matches());
        }
        long end = System.currentTimeMillis();
        System.out.println("aaaa = " + (end - start));
        return stringList;
    }

    private static List<String> bbbb(List<String> list) {
        List<String> stringList = Lists.newArrayList();
        long start = System.currentTimeMillis();
        for (String s : list) {
            Double aDouble = Double.valueOf(s);
            if (aDouble >= 20000.00 && aDouble <= 99999999.99) {
                stringList.add(s + "==== true");
            } else {
                stringList.add(s + "==== false");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("aaaa = " + (end - start));
        return stringList;
    }
}