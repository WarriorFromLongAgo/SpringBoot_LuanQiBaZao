package com.xuegao.luanqibazao_1.jdk8.util.regex;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Pattern;

/**
 * <br/> @ClassName：PatternTest1
 * <br/> @Description：
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