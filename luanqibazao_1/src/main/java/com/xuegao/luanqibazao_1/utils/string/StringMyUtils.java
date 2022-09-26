package com.xuegao.luanqibazao_1.utils.string;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringMyUtils {
    /**
     * 去除str开头和末尾的 separator
     *
     * @param str:
     * @param separator:
     * @return java.lang.String
     * @author xuegao
     * @date 2021/9/12 12:52
     */
    public static String trimSeparator(String str, String separator) {
        str = str.replaceAll("^" + separator + "*", "");
        str = str.replaceAll(separator + "+$", "");
        return str;
    }

    /**
     * 去除str 末尾的 separator
     *
     * @param str:
     * @param separator:
     * @return java.lang.String
     * @author xuegao
     * @date 2021/9/12 12:52
     */
    public static String trimEndSeparator(String str, String separator) {
        str = str.replaceAll(separator + "+$", "");
        return str;
    }

    /**
     * 去除str开头和末尾的 separator
     * 去除开头和末尾的  0 和 .
     *
     * @param str:
     * @return java.lang.String
     * @author xuegao
     * @date 2021/9/12 12:52
     */
    public static String trimSeparatorByMoney(String str) {
        if (Objects.equals(str, "0")) {
            return "0";
        }
        String tempStr = trimSeparator(str, "0");
        tempStr = trimSeparator(tempStr, "\\.");
        if (StringUtils.isBlank(tempStr)) {
            return "0";
        }
        return tempStr;
    }

    /**
     * 去除str开头和末尾的 separator
     * 去除开头和末尾的  0 和 .
     *
     * @param str:
     * @return java.lang.String
     * @author xuegao
     * @date 2021/9/12 12:52
     */
    public static String trimEndSeparatorByMoney(String str) {
        if (Objects.equals(str, "0")) {
            return "0";
        }
        if (!str.contains(".")) {
            return str;
        }
        String tempStr = "";
        if (str.endsWith(".")) {
            tempStr = trimEndSeparator(str, "\\.");
        } else {
            tempStr = trimEndSeparator(str, "0");
            tempStr = trimEndSeparator(tempStr, "\\.");
        }
        if (StringUtils.isBlank(tempStr)) {
            return "0";
        }
        return tempStr;
    }

    /**
     * 替换 str 里面的数据
     *
     * @param str:
     * @param newStr:
     * @param oldStrArr:
     * @return java.lang.String
     * @author xuegao
     * @date 2022/2/26 11:23
     */
    public static String replace(String str, String newStr, String... oldStrArr) {
        if (StringUtils.isBlank(str)) {
            return str;
        }
        // String area = "--/鞍山市/--/辽阳市/--";
        // System.out.println(area);
        // area = area.replace("--/", "");
        // System.out.println(area);
        // area = area.replace("/--", "");
        // str = str.replace(oldStr, newStr);
        // System.out.println(area);
        for (String oldStr : oldStrArr) {
            str = str.replace(oldStr, newStr);
        }
        return str;
    }

    /**
     * splitTrim
     *
     * @param inputStr:
     * @param separator:
     * @return java.util.List<java.lang.String>
     * @author xuegao
     * @date 2022/9/26 9:48
     */
    public static List<String> splitTrim(String inputStr, String separator) {
        if (StringUtils.isBlank(inputStr) || StringUtils.isBlank(separator)) {
            return Lists.newArrayList();
        }
        List<String> resultList = new ArrayList<>();
        String[] split = inputStr.split(separator);
        for (String tempStr : split) {
            resultList.add(tempStr.trim());
        }
        return resultList;
    }


    public static void main(String[] args) {

    }

    private static void testTrimSeparatorByMoney() {
        String money1 = "01";
        String money2 = "001";
        String money3 = "010";
        String money4 = "01000";
        String money5 = "0.";
        String money6 = "0100.";
        String money7 = "0100.1";
        String money8 = "0100.10";
        System.out.println(money1 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money1));
        System.out.println(money2 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money2));
        System.out.println(money3 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money3));
        System.out.println(money4 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money4));
        System.out.println(money5 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money5));
        System.out.println(money6 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money6));
        System.out.println(money7 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money7));
        System.out.println(money8 + " trimSeparatorByMoney = " + trimSeparatorByMoney(money8));
    }

    private static void testTrimEndSeparatorByMoney() {
        String money1 = "1";
        String money2 = "001";
        String money3 = "10";
        String money4 = "1000";
        String money5 = "0.";
        String money6 = "100.";
        String money7 = "100.1";
        String money8 = "100.10";
        System.out.println(money1 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money1));
        System.out.println(money2 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money2));
        System.out.println(money3 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money3));
        System.out.println(money4 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money4));
        System.out.println(money5 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money5));
        System.out.println(money6 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money6));
        System.out.println(money7 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money7));
        System.out.println(money8 + " trimEndSeparatorByMoney = " + trimEndSeparatorByMoney(money8));
    }

    public static void testSplitTrim() {
        String s = trimSeparator("-0755-0755-0755-", "-");
        System.out.println(s);
        s = trimEndSeparator("-0755-0755-0755-", "-");
        System.out.println(s);
    }
}
