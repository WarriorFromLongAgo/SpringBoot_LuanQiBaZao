package com.xuegao.luanqibazao_1.jdk8.date;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8_date
 * <br/> @ClassName：date
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/28 20:17
 */
public class date {
    public static void main(String[] args) {
        Long seconds = 1341855763000L;
        Date date = new Date(TimeUnit.SECONDS.toMillis(seconds));
        System.out.println(date);
        Date date2 = new Date(seconds);
        System.out.println(date2);
    }
}