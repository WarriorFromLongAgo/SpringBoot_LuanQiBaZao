package com.xuegao.luanqibazao_1.jdk8.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.time
 * <br/> @ClassName：LocalDateTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/9 18:15
 */
public class LocalDateTest {
    public static void main(String[] args) {
        get上一个月第一天和最后一天();
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(firstDayOfMonth);
    }

    private static void get上一个月第一天和最后一天() {
        LocalDate localDate = LocalDate.of(2020, 2, 28);
        if (localDate.getMonthValue() == 1) {
            LocalDate lastMonth = LocalDate.of(localDate.getYear() - 1, 12, 1);
            LocalDate lastDay = lastMonth.with(TemporalAdjusters.lastDayOfMonth());
            System.out.println(lastMonth);
            System.out.println(lastDay);
        } else {
            LocalDate lastMonth = LocalDate.of(localDate.getYear(), localDate.getMonthValue() - 1, 1);
            LocalDate lastDay = lastMonth.with(TemporalAdjusters.lastDayOfMonth());
            System.out.println(lastMonth);
            System.out.println(lastDay);
        }
    }
}