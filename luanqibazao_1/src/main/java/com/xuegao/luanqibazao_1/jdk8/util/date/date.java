package com.xuegao.luanqibazao_1.jdk8.util.date;

import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8_date
 * <br/> @ClassName：date
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/28 20:17
 */
public class date {
    public static void main(String[] args) {
        jian();
    }

    // 日期相减
    public static void jian() {
        Date date1 = new Date(2021, 1, 19, 15, 34, 11);
        Date date2 = new Date(2021, 1, 19, 15, 23, 50);
        long time = date2.getTime() / 1000;
        System.out.println(time);
        long time1 = date1.getTime() / 1000;
        System.out.println(time1);
        long l = time - time1;
        System.out.println(l);

        System.out.println(1611041651 - 1611041030);
    }
}