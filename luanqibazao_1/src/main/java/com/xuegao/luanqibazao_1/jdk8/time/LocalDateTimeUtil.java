package com.xuegao.luanqibazao_1.jdk8.time;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeUtil {
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_HH_MM_SS = "HH:mm:ss";
    public static final String PATTERN_MM_SS = "mm:ss";

    // region str interconversion LocalDateTime

    public static LocalDateTime strToLocalDateTime(String str) {
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(PATTERN_YYYY_MM_DD_HH_MM_SS));
    }

    public static LocalDateTime strToLocalDateTime(String str, String pattern) {
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(pattern));
    }

    public static String localDateTimeToStr(LocalDateTime localDateTime) {
        return localDateTimeToStr(localDateTime, PATTERN_YYYY_MM_DD_HH_MM_SS);
    }

    public static String localDateTimeToStr(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    // endregion

    // region LocalDateTime 通用

    /**
     * l1 = l2：= 0 相等  2022-06-29 15:31:00 = 2022-06-29 15:31:00
     * l1 > l2：= 1 大于  2022-06-30 15:31:00 = 2022-06-29 15:31:00
     * l1 < l2：= -1 小于  2022-06-29 15:31:00 = 2022-06-30 15:31:00
     * <p>
     * compare
     *
     * @param l1:
     * @param l2:
     * @return int
     * @author xuegao
     * @date 2022/6/29 15:30
     */
    public static int compare(LocalDateTime l1, LocalDateTime l2) {
        return l1.compareTo(l2);
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    // endregion

    // region 增加减少天数，秒数，周，月，年，等等

    /**
     * 获取一个时间，负数是过去的，正数是现在的
     * plusDays
     *
     * @param days:
     * @return java.time.LocalDateTime
     * @author xuegao
     * @date 2022/6/29 15:24
     */
    public static LocalDateTime plusDays(long days) {
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        return nowLocalDateTime.plusDays(days);
    }
    // endregion

    // region LocalDateTime interconversion Date Timestamp

    public static Date toDate() {
        return toDate(now());
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Timestamp toTimestamp() {
        return toTimestamp(now());
    }

    public static Timestamp toTimestamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    public static LocalDateTime toLocalDateTime() {
        return toLocalDateTime(new Date());
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    // endregion

    // region 计算两个时间相差多少天，月，年

    /**
     * 计算两个时间相差多少天（date2 - date1）
     *
     * @param date1 时间1
     * @param date2 时间2
     * @author xuegao
     */
    public static long differentDays(LocalDateTime date1, LocalDateTime date2) {
        return date2.toLocalDate().toEpochDay() - date1.toLocalDate().toEpochDay();
    }

    /**
     * 计算两个时间相差多少天（date2 - date1）
     *
     * @param date1 时间1
     * @param date2 时间2
     * @author xuegao
     */
    public static long differentDays(LocalDate date1, LocalDate date2) {
        return date2.toEpochDay() - date1.toEpochDay();
    }

    public static long differentDays(String date1, String date2, String pattern) {
        if (PATTERN_YYYY_MM_DD.equals(pattern)) {
            LocalDate localDate1 = strToLocalDate(date1, pattern);
            LocalDate localDate2 = strToLocalDate(date2, pattern);
            return differentDays(localDate1, localDate2);
        }
        LocalDateTime localDateTime1 = strToLocalDateTime(date1, pattern);
        LocalDateTime localDateTime2 = strToLocalDateTime(date2, pattern);
        return differentDays(localDateTime1, localDateTime2);
    }

    /**
     * 获取两个时间点的月份差
     *
     * @param dt1 第一个时间点
     * @param dt2 第二个时间点
     * @return int，即需求的月数差
     */
    public static int differentMonths(LocalDateTime dt1, LocalDateTime dt2) {
        //获取第一个时间点的月份
        int month1 = dt1.getMonthValue();
        //获取第一个时间点的年份
        int year1 = dt1.getYear();
        //获取第一个时间点的月份
        int month2 = dt2.getMonthValue();
        //获取第一个时间点的年份
        int year2 = dt2.getYear();
        //返回两个时间点的月数差
        return (year2 - year1) * 12 + (month2 - month1);
    }

    /**
     * 获取两个时间点的月份差
     *
     * @param dt1 第一个时间点
     * @param dt2 第二个时间点
     * @return int，即需求的月数差
     */
    public static int differentMonths(LocalDate dt1, LocalDate dt2) {
        //获取第一个时间点的月份
        int month1 = dt1.getMonthValue();
        //获取第一个时间点的年份
        int year1 = dt1.getYear();
        //获取第一个时间点的月份
        int month2 = dt2.getMonthValue();
        //获取第一个时间点的年份
        int year2 = dt2.getYear();
        //返回两个时间点的月数差
        return (year2 - year1) * 12 + (month2 - month1);
    }
    /**
     * 获取两个时间点的月份差
     *
     * @param date1 第一个时间点
     * @param date2 第二个时间点
     * @return int，即需求的月数差
     */
    public static int differentMonths(String date1, String date2, String pattern) {
        if (PATTERN_YYYY_MM_DD.equals(pattern)) {
            LocalDate localDate1 = strToLocalDate(date1, pattern);
            LocalDate localDate2 = strToLocalDate(date2, pattern);
            return differentMonths(localDate1, localDate2);
        }
        LocalDateTime localDateTime1 = strToLocalDateTime(date1, pattern);
        LocalDateTime localDateTime2 = strToLocalDateTime(date2, pattern);
        return differentMonths(localDateTime1, localDateTime2);
    }

    // endregion

    // region LocalDate

    public static LocalDate strToLocalDate(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern(PATTERN_YYYY_MM_DD));
    }

    public static LocalDate strToLocalDate(String str, String pattern) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern(pattern));
    }

    public static String localDateToStr(LocalDate localDate) {
        return localDateToStr(localDate, PATTERN_YYYY_MM_DD);
    }

    public static String localDateToStr(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    // endregion

    // region LocalTime

    public static LocalTime strToLocalTime(String str) {
        return LocalTime.parse(str, DateTimeFormatter.ofPattern(PATTERN_HH_MM_SS));
    }

    public static LocalTime strToLocalTime(String str, String pattern) {
        return LocalTime.parse(str, DateTimeFormatter.ofPattern(pattern));
    }

    public static String localTimeToStr(LocalTime localTime) {
        return localTimeToStr(localTime, PATTERN_HH_MM_SS);
    }

    public static String localTimeToStr(LocalTime localTime, String pattern) {
        return localTime.format(DateTimeFormatter.ofPattern(pattern));
    }
    // endregion

    // region LocalDate interconversion LocalDateTime
    public static LocalDate localDateTimeToLocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    public static LocalDateTime localDateToLocalDateTime(LocalDate localDate) {
        return localDateToLocalDateTime(localDate, LocalTime.now());
    }

    public static LocalDateTime localDateToLocalDateTime0000(LocalDate localDate) {
        return localDateToLocalDateTime(localDate, LocalTime.MIN);
    }

    public static LocalDateTime localDateToLocalDateTime2359(LocalDate localDate) {
        return localDateToLocalDateTime(localDate, LocalTime.MAX);
    }

    public static LocalDateTime localDateToLocalDateTime(LocalDate localDate, LocalTime localTime) {
        return localDate.atTime(localTime);
    }
    // endregion

    public static void main(String[] args) {
        LocalDateTime l1 = strToLocalDateTime("2022-06-29 15:31:00");
        LocalDateTime l2 = strToLocalDateTime("2022-06-30 15:31:00");
        int compare = compare(l1, l2);
        System.out.println("1 = " + compare);

        l1 = strToLocalDateTime("2022-06-30 15:31:00");
        l2 = strToLocalDateTime("2022-06-29 15:31:00");
        compare = compare(l1, l2);
        System.out.println("2 = " + compare);

        l1 = strToLocalDateTime("2022-06-30 15:31:00");
        l2 = strToLocalDateTime("2022-06-30 15:31:00");
        compare = compare(l1, l2);
        System.out.println("3 = " + compare);


        LocalDateTime localDateTime = plusDays(-182);
        System.out.println(LocalDateTimeUtil.localDateTimeToStr(localDateTime));

        long l = differentDays("2022-06-30 15:31:00", "2022-07-29 15:31:00", PATTERN_YYYY_MM_DD_HH_MM_SS);
        System.out.println(l);
        l = differentDays("2020-04-23", "2021-04-23", PATTERN_YYYY_MM_DD);
        System.out.println(l);

        long months = differentMonths("2022-06-30 15:31:00", "2022-07-31 15:31:00", PATTERN_YYYY_MM_DD_HH_MM_SS);
        System.out.println(months);
        l = differentDays("2022-07-13", "2023-07-12", PATTERN_YYYY_MM_DD);
        System.out.println(l);
    }
}
