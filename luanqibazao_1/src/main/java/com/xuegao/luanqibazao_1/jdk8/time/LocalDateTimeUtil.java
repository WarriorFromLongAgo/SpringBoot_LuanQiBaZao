package com.xuegao.luanqibazao_1.jdk8.time;

import com.xuegao.luanqibazao_1.common.Constants;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeUtil {
    public static LocalDateTime strToLocalDateTime(String str) {
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(Constants.TIME_PATTERN_1));
    }

    public static LocalDateTime strToLocalDateTime(String str, String pattern) {
        return LocalDateTime.parse(str, DateTimeFormatter.ofPattern(pattern));
    }

    public static String localDateTimeToStr(LocalDateTime localDateTime) {
        return localDateTimeToStr(localDateTime, Constants.TIME_PATTERN_1);
    }

    public static String localDateTimeToStr(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

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

    /**
     * 获取一个时间，负数是过去的，正数是现在的
     * plusDays
     *
     * @param days:
     * @return java.time.LocalDateTime
     * @author fjm
     * @date 2022/6/29 15:24
     */
    public static LocalDateTime plusDays(long days) {
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        return nowLocalDateTime.plusDays(days);
    }

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
    }
}
