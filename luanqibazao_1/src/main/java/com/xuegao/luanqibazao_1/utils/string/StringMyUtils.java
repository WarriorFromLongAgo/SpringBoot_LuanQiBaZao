package com.xuegao.luanqibazao_1.utils.string;

import org.apache.commons.lang3.StringUtils;

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
        return trimSeparator(tempStr, "\\.");
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
        String tempStr = trimEndSeparator(str, "0");
        tempStr = trimEndSeparator(tempStr, "\\.");
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
}
