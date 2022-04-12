package com.xuegao.luanqibazao_1.jdk8.util.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8
 * <br/> @ClassName：检测日期是否正常
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/28 18:16
 */
public class 获取两个时间的天数 {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.parse("2021-03-25");
        LocalDate localDate2 = LocalDate.parse("2023-07-25");
        System.out.println(ChronoUnit.DAYS.between(localDate1, localDate2));
        System.out.println(localDate2.until(localDate1));
        System.out.println(localDate1.until(localDate2, ChronoUnit.DAYS));
    }
}