package com.xuegao.video_conver.javautil;

import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.video_conver.javautil
 * <br/> @ClassName：date
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/1 18:36
 */
public class date {
    public static void main(String[] args) {
        after();
        System.out.println("=================================");
        before();
        System.out.println("=================================");
    }

    public static void after() {
        Date date1 = new Date(2020, 1, 1, 10, 10, 10);
        Date date2 = new Date(2020, 2, 1, 10, 10, 10);
        System.out.println(" 2020-1-1 after 2020-2-1 ");
        if (date1.after(date2)) {
            System.out.println(" date1.after(date2) = " + true);
        } else {
            System.out.println(" date1.after(date2) = " + false);
        }
    }

    public static void before() {
        Date date1 = new Date(2020, 1, 1, 10, 10, 10);
        Date date2 = new Date(2020, 2, 1, 10, 10, 10);
        System.out.println(" 2020-1-1 before 2020-2-1 ");
        if (date1.before(date2)) {
            System.out.println(" date1.before(date2) = " + true);
        } else {
            System.out.println(" date1.before(date2) = " + false);
        }
    }
}