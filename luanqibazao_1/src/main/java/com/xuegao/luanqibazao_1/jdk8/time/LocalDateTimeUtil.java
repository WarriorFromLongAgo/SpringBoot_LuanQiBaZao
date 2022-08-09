package com.xuegao.luanqibazao_1.jdk8.time;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LocalDateTimeUtil {
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_HH_MM_SS = "HH:mm:ss";
    public static final String PATTERN_MM_SS = "mm:ss";

    // region long interconversion LocalDateTime

    public static LocalDateTime longToLocalDateTime(long l) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(l), ZoneId.systemDefault());
    }

    public static long localDateTimeToLong(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    // endregion


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


    // region 获取当天，当月，当年，开始结束时间

    /**
     * 今天开始时间
     *
     * @return
     */
    public static LocalDateTime todayStartTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    }

    /**
     * 今天结束时间
     *
     * @return
     */
    public static LocalDateTime todayEndTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    /**
     * 昨天开始时间
     *
     * @return
     */
    public static LocalDateTime yesterdayStartTime() {
        return LocalDateTime.of(LocalDate.now().minus(1L, ChronoUnit.DAYS), LocalTime.MIN);
    }

    /**
     * 昨天结束时间
     *
     * @return
     */
    public static LocalDateTime yesterdayEndTime() {
        return LocalDateTime.of(LocalDate.now().minus(1L, ChronoUnit.DAYS), LocalTime.MAX);
    }

    /**
     * 最近7天开始时间
     *
     * @return
     */
    public static LocalDateTime last7DaysStartTime() {
        return LocalDateTime.of(LocalDate.now().minus(6L, ChronoUnit.DAYS), LocalTime.MIN);
    }

    /**
     * 最近7天结束时间
     *
     * @return
     */
    public static LocalDateTime last7DaysEndTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    /**
     * 最近30天开始时间
     *
     * @return
     */
    public static LocalDateTime last30DaysStartTime() {
        return LocalDateTime.of(LocalDate.now().minus(29L, ChronoUnit.DAYS), LocalTime.MIN);
    }

    /**
     * 最近30天结束时间
     *
     * @return
     */
    public static LocalDateTime last30DaysEndTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    /**
     * 最近一年开始时间
     *
     * @return
     */
    public static LocalDateTime last1YearStartTime() {
        return LocalDateTime.of(LocalDate.now().minus(1L, ChronoUnit.YEARS).plus(1L, ChronoUnit.DAYS), LocalTime.MIN);
    }

    /**
     * 最近一年结束时间
     *
     * @return
     */
    public static LocalDateTime last1YearEndTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
    }

    /**
     * 本周开始时间
     *
     * @return
     */
    public static LocalDateTime weekStartTime() {
        LocalDate now = LocalDate.now();
        return LocalDateTime.of(now.minusDays(now.getDayOfWeek().getValue() - 1), LocalTime.MIN);
    }

    /**
     * 本周结束时间
     *
     * @return
     */
    public static LocalDateTime weekEndTime() {
        LocalDate now = LocalDate.now();
        return LocalDateTime.of(now.plusDays(7 - now.getDayOfWeek().getValue()), LocalTime.MAX);
    }

    /**
     * 本月开始时间
     *
     * @return
     */
    public static LocalDateTime monthStartTime() {
        return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN);
    }

    /**
     * 本月结束时间
     *
     * @return
     */
    public static LocalDateTime monthEndTime() {
        return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);
    }

    /**
     * 本季度开始时间
     *
     * @return
     */
    public static LocalDateTime quarterStartTime() {
        LocalDate now = LocalDate.now();
        Month month = Month.of(now.getMonth().firstMonthOfQuarter().getValue());
        return LocalDateTime.of(LocalDate.of(now.getYear(), month, 1), LocalTime.MIN);
    }

    /**
     * 本季度结束时间
     *
     * @return
     */
    public static LocalDateTime quarterEndTime() {
        LocalDate now = LocalDate.now();
        Month month = Month.of(now.getMonth().firstMonthOfQuarter().getValue()).plus(2L);
        return LocalDateTime.of(LocalDate.of(now.getYear(), month, month.length(now.isLeapYear())), LocalTime.MAX);
    }

    /**
     * 本半年开始时间
     *
     * @return
     */
    public static LocalDateTime halfYearStartTime() {
        LocalDate now = LocalDate.now();
        Month month = (now.getMonthValue() > 6) ? Month.JULY : Month.JANUARY;
        return LocalDateTime.of(LocalDate.of(now.getYear(), month, 1), LocalTime.MIN);
    }

    /**
     * 本半年结束时间
     *
     * @return
     */
    public static LocalDateTime halfYearEndTime() {
        LocalDate now = LocalDate.now();
        Month month = (now.getMonthValue() > 6) ? Month.DECEMBER : Month.JUNE;
        return LocalDateTime.of(LocalDate.of(now.getYear(), month, month.length(now.isLeapYear())), LocalTime.MAX);
    }

    /**
     * 本年开始时间
     *
     * @return
     */
    public static LocalDateTime yearStartTime() {
        return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.firstDayOfYear()), LocalTime.MIN);
    }

    /**
     * 本年结束时间
     *
     * @return
     */
    public static LocalDateTime yearEndTime() {
        return LocalDateTime.of(LocalDate.now().with(TemporalAdjusters.lastDayOfYear()), LocalTime.MAX);
    }

    /**
     * 上周开始时间
     *
     * @return
     */
    public static LocalDateTime lastWeekStartTime() {
        LocalDate lastWeek = LocalDate.now().minus(1L, ChronoUnit.WEEKS);
        return LocalDateTime.of(lastWeek.minusDays(lastWeek.getDayOfWeek().getValue() - 1), LocalTime.MIN);
    }

    /**
     * 上周结束时间
     *
     * @return
     */
    public static LocalDateTime lastWeekEndTime() {
        LocalDate lastWeek = LocalDate.now().minus(1L, ChronoUnit.WEEKS);
        return LocalDateTime.of(lastWeek.plusDays(7 - lastWeek.getDayOfWeek().getValue()), LocalTime.MAX);
    }

    /**
     * 上月开始时间
     *
     * @return
     */
    public static LocalDateTime lastMonthStartTime() {
        return LocalDateTime.of(LocalDate.now().minus(1L, ChronoUnit.MONTHS).with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN);
    }

    /**
     * 上月结束时间
     *
     * @return
     */
    public static LocalDateTime lastMonthEndTime() {
        return LocalDateTime.of(LocalDate.now().minus(1L, ChronoUnit.MONTHS).with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);
    }

    /**
     * 上季度开始时间
     *
     * @return
     */
    public static LocalDateTime lastQuarterStartTime() {
        LocalDate now = LocalDate.now();
        Month firstMonthOfQuarter = Month.of(now.getMonth().firstMonthOfQuarter().getValue());
        Month firstMonthOfLastQuarter = firstMonthOfQuarter.minus(3L);
        int yearOfLastQuarter = firstMonthOfQuarter.getValue() < 4 ? now.getYear() - 1 : now.getYear();
        return LocalDateTime.of(LocalDate.of(yearOfLastQuarter, firstMonthOfLastQuarter, 1), LocalTime.MIN);
    }

    /**
     * 上季度结束时间
     *
     * @return
     */
    public static LocalDateTime lastQuarterEndTime() {
        LocalDate now = LocalDate.now();
        Month firstMonthOfQuarter = Month.of(now.getMonth().firstMonthOfQuarter().getValue());
        Month firstMonthOfLastQuarter = firstMonthOfQuarter.minus(1L);
        int yearOfLastQuarter = firstMonthOfQuarter.getValue() < 4 ? now.getYear() - 1 : now.getYear();
        return LocalDateTime.of(LocalDate.of(yearOfLastQuarter, firstMonthOfLastQuarter, firstMonthOfLastQuarter.maxLength()), LocalTime.MAX);
    }

    /**
     * 上半年开始时间
     *
     * @return
     */
    public static LocalDateTime lastHalfYearStartTime() {
        LocalDate now = LocalDate.now();
        int lastHalfYear = (now.getMonthValue() > 6) ? now.getYear() : now.getYear() - 1;
        Month firstMonthOfLastHalfYear = (now.getMonthValue() > 6) ? Month.JANUARY : Month.JULY;
        return LocalDateTime.of(LocalDate.of(lastHalfYear, firstMonthOfLastHalfYear, 1), LocalTime.MIN);
    }

    /**
     * 上半年结束时间
     *
     * @return
     */
    public static LocalDateTime lastHalfYearEndTime() {
        LocalDate now = LocalDate.now();
        int lastHalfYear = (now.getMonthValue() > 6) ? now.getYear() : now.getYear() - 1;
        Month lastMonthOfLastHalfYear = (now.getMonthValue() > 6) ? Month.JUNE : Month.DECEMBER;
        return LocalDateTime.of(LocalDate.of(lastHalfYear, lastMonthOfLastHalfYear, lastMonthOfLastHalfYear.maxLength()), LocalTime.MAX);
    }

    /**
     * 上一年开始时间
     *
     * @return
     */
    public static LocalDateTime lastYearStartTime() {
        return LocalDateTime.of(LocalDate.now().minus(1L, ChronoUnit.YEARS).with(TemporalAdjusters.firstDayOfYear()), LocalTime.MIN);
    }

    /**
     * 上一年结束时间
     *
     * @return
     */
    public static LocalDateTime lastYearEndTime() {
        return LocalDateTime.of(LocalDate.now().minus(1L, ChronoUnit.YEARS).with(TemporalAdjusters.lastDayOfYear()), LocalTime.MAX);
    }

    /**
     * 下周开始时间
     *
     * @return
     */
    public static LocalDateTime nextWeekStartTime() {
        LocalDate nextWeek = LocalDate.now().plus(1L, ChronoUnit.WEEKS);
        return LocalDateTime.of(nextWeek.minusDays(nextWeek.getDayOfWeek().getValue() - 1), LocalTime.MIN);
    }

    /**
     * 下周结束时间
     *
     * @return
     */
    public static LocalDateTime nextWeekEndTime() {
        LocalDate nextWeek = LocalDate.now().plus(1L, ChronoUnit.WEEKS);
        return LocalDateTime.of(nextWeek.plusDays(7 - nextWeek.getDayOfWeek().getValue()), LocalTime.MAX);
    }

    /**
     * 下月开始时间
     *
     * @return
     */
    public static LocalDateTime nextMonthStartTime() {
        return LocalDateTime.of(LocalDate.now().plus(1L, ChronoUnit.MONTHS).with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN);
    }

    /**
     * 下月结束时间
     *
     * @return
     */
    public static LocalDateTime nextMonthEndTime() {
        return LocalDateTime.of(LocalDate.now().plus(1L, ChronoUnit.MONTHS).with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);
    }

    /**
     * 下季度开始时间
     *
     * @return
     */
    public static LocalDateTime nextQuarterStartTime() {
        LocalDate now = LocalDate.now();
        Month firstMonthOfQuarter = Month.of(now.getMonth().firstMonthOfQuarter().getValue());
        Month firstMonthOfNextQuarter = firstMonthOfQuarter.plus(3L);
        int yearOfNextQuarter = firstMonthOfQuarter.getValue() > 9 ? now.getYear() + 1 : now.getYear();
        return LocalDateTime.of(LocalDate.of(yearOfNextQuarter, firstMonthOfNextQuarter, 1), LocalTime.MIN);
    }

    /**
     * 下季度结束时间
     *
     * @return
     */
    public static LocalDateTime nextQuarterEndTime() {
        LocalDate now = LocalDate.now();
        Month firstMonthOfQuarter = Month.of(now.getMonth().firstMonthOfQuarter().getValue());
        Month firstMonthOfNextQuarter = firstMonthOfQuarter.plus(5L);
        int yearOfNextQuarter = firstMonthOfQuarter.getValue() > 9 ? now.getYear() + 1 : now.getYear();
        return LocalDateTime.of(LocalDate.of(yearOfNextQuarter, firstMonthOfNextQuarter, firstMonthOfNextQuarter.maxLength()), LocalTime.MAX);
    }

    /**
     * 上半年开始时间
     *
     * @return
     */
    public static LocalDateTime nextHalfYearStartTime() {
        LocalDate now = LocalDate.now();
        int nextHalfYear = (now.getMonthValue() > 6) ? now.getYear() + 1 : now.getYear();
        Month firstMonthOfNextHalfYear = (now.getMonthValue() > 6) ? Month.JANUARY : Month.JULY;
        return LocalDateTime.of(LocalDate.of(nextHalfYear, firstMonthOfNextHalfYear, 1), LocalTime.MIN);
    }

    /**
     * 上半年结束时间
     *
     * @return
     */
    public static LocalDateTime nextHalfYearEndTime() {
        LocalDate now = LocalDate.now();
        int lastHalfYear = (now.getMonthValue() > 6) ? now.getYear() + 1 : now.getYear();
        Month lastMonthOfNextHalfYear = (now.getMonthValue() > 6) ? Month.JUNE : Month.DECEMBER;
        return LocalDateTime.of(LocalDate.of(lastHalfYear, lastMonthOfNextHalfYear, lastMonthOfNextHalfYear.maxLength()), LocalTime.MAX);
    }

    /**
     * 下一年开始时间
     *
     * @return
     */
    public static LocalDateTime nextYearStartTime() {
        return LocalDateTime.of(LocalDate.now().plus(1L, ChronoUnit.YEARS).with(TemporalAdjusters.firstDayOfYear()), LocalTime.MIN);
    }

    /**
     * 下一年结束时间
     *
     * @return
     */
    public static LocalDateTime nextYearEndTime() {
        return LocalDateTime.of(LocalDate.now().plus(1L, ChronoUnit.YEARS).with(TemporalAdjusters.lastDayOfYear()), LocalTime.MAX);
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

        System.out.println("今天开始时间：" + todayStartTime());
        System.out.println("今天结束时间：" + todayEndTime());
        System.out.println("昨天开始时间：" + yesterdayStartTime());
        System.out.println("昨天结束时间：" + yesterdayEndTime());
        System.out.println("最近7天开始时间：" + last7DaysStartTime());
        System.out.println("最近7天结束时间：" + last7DaysEndTime());
        System.out.println("最近30天开始时间：" + last30DaysStartTime());
        System.out.println("最近30天天结束时间：" + last30DaysEndTime());
        System.out.println("最近一年开始时间：" + last1YearStartTime());
        System.out.println("最近一年结束时间：" + last1YearEndTime());
        System.out.println("本周开始时间：" + weekStartTime());
        System.out.println("本周结束时间：" + weekEndTime());
        System.out.println("本月开始时间：" + monthStartTime());
        System.out.println("本月结束时间：" + monthEndTime());
        System.out.println("本季度开始时间：" + quarterStartTime());
        System.out.println("本季度结束时间：" + quarterEndTime());
        System.out.println("本半年开始时间：" + halfYearStartTime());
        System.out.println("本半年结束时间：" + halfYearEndTime());
        System.out.println("本年开始时间：" + yearStartTime());
        System.out.println("本年结束时间：" + yearEndTime());
        System.out.println("上周开始时间：" + lastWeekStartTime());
        System.out.println("上周结束时间：" + lastWeekEndTime());
        System.out.println("上月开始时间：" + lastMonthStartTime());
        System.out.println("上月结束时间：" + lastMonthEndTime());
        System.out.println("上季度开始时间：" + lastQuarterStartTime());
        System.out.println("上季度结束时间：" + lastQuarterEndTime());
        System.out.println("上半年开始时间：" + lastHalfYearStartTime());
        System.out.println("上半年结束时间：" + lastHalfYearEndTime());
        System.out.println("上一年开始时间：" + lastYearStartTime());
        System.out.println("上一年结束时间：" + lastYearEndTime());
        System.out.println("下周开始时间：" + nextWeekStartTime());
        System.out.println("下周结束时间：" + nextWeekEndTime());
        System.out.println("下月开始时间：" + nextMonthStartTime());
        System.out.println("下月结束时间：" + nextMonthEndTime());
        System.out.println("下季度开始时间：" + nextQuarterStartTime());
        System.out.println("下季度结束时间：" + nextQuarterEndTime());
        System.out.println("下半年开始时间：" + nextHalfYearStartTime());
        System.out.println("下半年结束时间：" + nextHalfYearEndTime());
        System.out.println("下一年开始时间：" + nextYearStartTime());
        System.out.println("下一年结束时间：" + nextYearEndTime());
        // 版权声明：本文为CSDN博主「C3Stones」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        // 原文链接：https://blog.csdn.net/qq_48008521/article/details/116474667
    }
}
