package com.xuegao.to_mysql;


import java.util.Calendar;
import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.to_mysql
 * <br/> @ClassName：date
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/7 17:06
 */
public class date {
    public static void main(String[] args) {
        // jdk1_6_时间相差();
        System.out.println("======================");
        jdk1_6_时间相差_jodatime();
    }

    // 保留小时和分钟
    public static void jdk1_6_时间相差() {
        Date date = new Date(1594102296);
        System.out.println(date);
        Date date1 = new Date(1594105896);
        // System.out.println(LocalDateTime.parse());
    }

    public static void jdk1_6_时间相差_jodatime() {
        // DateTime dateTime = new DateTime(2017, 9, 14, 20, 30, 0);
        // DateTime dateTime1 = new DateTime(2017, 9, 15, 21, 31, 1);
        // long start = dateTime.getMillis();
        // System.out.println(start);
        // long end = dateTime1.getMillis();
        // System.out.println(end);
        // long cha = end - start;
        // System.out.println(cha);

        Calendar startTime = Calendar.getInstance();
        startTime.set(2017, 9, 14, 20, 30, 0);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2017, 9, 15, 21, 31, 1);

        long start = startTime.getTime().getTime();
        long end = endTime.getTime().getTime();
        System.out.println(start);
        System.out.println(end);
        long cha = end - start;


        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long day = cha / nd;// 计算差多少天
        long hour = cha % nd / nh + day * 24;// 计算差多少小时
        long min = cha % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
        System.out.println(day);
        System.out.println(hour);
        System.out.println(min);
    }
}