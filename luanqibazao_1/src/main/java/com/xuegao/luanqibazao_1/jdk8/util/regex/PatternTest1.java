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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO 类功能描述
 * <br/> @ClassName：PatternTest1
 * <br/> @Description：
 * <br/> @author：fjm
 * <br/> @date：2021/5/28 17:29
 */
public class PatternTest1 {
    static Pattern pattern = Pattern.compile("^[1-9]\\d{4,8}(\\.[0-9]{1,2})?$");

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("199", "1999", "9999", "10000", "19999", "20000",
                "20000.00", "20001.00", "1243242.00",
                "99999999.99", "100000000.00", "100000000");
        for (String s : list) {
            // Matcher matcher = pattern.matcher(s);
            // boolean matches = matcher.matches();
            // System.out.println(s + "====" + matches);

            double aDouble = Double.parseDouble(s);
            if (aDouble >= 20000.00 && aDouble <= 99999999.99) {
                System.out.println(s + "==== true");
            } else {
                System.out.println(s + "==== false");
            }
        }

    }
}