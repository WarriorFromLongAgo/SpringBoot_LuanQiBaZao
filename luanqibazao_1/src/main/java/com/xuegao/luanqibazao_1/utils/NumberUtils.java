package com.xuegao.luanqibazao_1.utils;

import org.apache.commons.lang3.StringUtils;

public class NumberUtils {
    public static void main(String[] args) {
        System.out.println("isPositiveNumber(1) = " + isPositiveNumber("1"));
        System.out.println("isPositiveNumber(1.0) = " + isPositiveNumber("1.0"));
        System.out.println("isPositiveNumber(-1) = " + isPositiveNumber("-1"));
        System.out.println("isPositiveNumber(-1.0) = " + isPositiveNumber("-1.0"));
    }

    /** 
     * isPositiveNumber
     * 是否是正数
     *  
     * @param str: 
     * @return boolean 
     * @author xuegao
     * @date 2022/6/16 11:35 
     */
    public static boolean isPositiveNumber(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return str.matches("[0-9]+.?[0-9]*");
    }
}
