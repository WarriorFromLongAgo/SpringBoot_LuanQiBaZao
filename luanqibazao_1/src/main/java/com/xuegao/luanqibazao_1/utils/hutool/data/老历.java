package com.xuegao.luanqibazao_1.utils.hutool.data;

import cn.hutool.core.date.ChineseDate;

import java.util.Date;

/**
 * @version 1.0
 * @date 2021/11/17 13:18
 */
public class 老历 {
    public static void main(String[] args) {
        ChineseDate chineseDate = new ChineseDate(new Date());
        System.out.println(chineseDate);
        String chineseMonth = chineseDate.getChineseMonth();
        String chineseDay = chineseDate.getChineseDay();
        int day = chineseDate.getDay();
        String chineseMonthName = chineseDate.getChineseMonthName();
        String s = chineseDate.toString();
        String s1 = chineseDate.toStringNormal();
        System.out.println("chineseMonth" + chineseMonth);
        System.out.println("chineseDay" + chineseDay);
        System.out.println("day" + day);
        System.out.println("chineseMonthName" + chineseMonthName);
        System.out.println("s" + s);
        System.out.println("s1" + s1);
        int month = chineseDate.getMonth();
        System.out.println("month=" + month);

    }
}