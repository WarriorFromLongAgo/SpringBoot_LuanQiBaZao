package com.xuegao.luanqibazao_1.jdk8.lang.string;

import com.alibaba.druid.sql.visitor.functions.Hex;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.string
 * <br/> @ClassName：StringTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/20 15:08
 */
public class StringTest {
    public static void main(String[] args) {

    }

    private static void subString() {
        String aaa = "-0755-021-020-022-";
        System.out.println(aaa);
        if (aaa.startsWith("-")) {
            aaa = aaa.substring(1);
            System.out.println(aaa);
        }

        if (aaa.endsWith("-")) {
            aaa = aaa.substring(0, aaa.length() - 1);
            System.out.println(aaa);
        }
    }

    private static void extracted1() {
        String join = String.join("-", "a", "b");
        System.out.println(join);
    }

    private static void extracted() {
        String a = "12";
        if (StringUtils.isBlank(a)) {
            System.out.println("      aaaaaaa           ");
        } else {
            String substring = a.substring(0, a.length() - 1);
            System.out.println("substring = " + substring);
        }


        String strArr = "1,2,3";

        List<String> split = split(strArr);
        System.out.println(split);

        strArr = "";
        List<String> split1 = split(strArr);
        System.out.println(split1);

        strArr = null;
        List<String> split2 = split(strArr);
        System.out.println(split2);
    }

    private static List<String> split(String split) {
        if (StringUtils.isBlank(split)) {
            return new ArrayList<>();
        }
        return Arrays.asList(split.split(","));
    }
}