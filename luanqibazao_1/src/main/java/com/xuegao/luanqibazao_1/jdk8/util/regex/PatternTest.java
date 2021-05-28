/**************************************************************************/
/*                                                                        */
/* Copyright (c) 2017 KYE Company                                         */
/* 跨越速运集团有限公司版权所有                                             */
/*                                                                        */
/* PROPRIETARY RIGHTS of KYE Company are involved in the                  */
/* subject matter of this material. All manufacturing, reproduction, use, */
/* and sales rights pertaining to this subject matter are governed by the */
/* license agreement. The recipient of this software implicitly accepts   */
/* the terms of the license.                                              */
/* 本软件文档资料是跨越速运集团有限公司的资产，任何人士阅读和                  */
/* 使用本资料必须获得相应的书面授权，承担保密责任和接受相应的法律约束。         */
/*                                                                        */
/**************************************************************************/

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