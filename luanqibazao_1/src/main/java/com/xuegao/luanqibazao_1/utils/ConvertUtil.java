package com.xuegao.luanqibazao_1.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.convert
 * <br/> @ClassName：ConvertUtil
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/16 10:31
 */
public class ConvertUtil {

    public static final String FLOOR = "floor";
    public static final String ROUND = "round";
    public static final String LOCAL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    private ConvertUtil() {
    }

    enum secondsToMinutes {
        // 向上 取整
        FLOOR,
        // 向下取整
        ROUND;
    }

    // 秒转换成分钟
    public static String secondsToMinutes(String seconds, String round) {
        String minutes = "";
        if (StringUtils.isBlank(seconds)) {
            return "0";
        }
        double secondsInt = Double.parseDouble(seconds);
        int merchant = (int) (secondsInt / 60);
        int remainder = (int) (secondsInt % 60);

        // 如果是向上取整
        if (ConvertUtil.FLOOR.equals(round)) {
            minutes = String.valueOf(remainder > 0 ? ++merchant : merchant);
        }
        // 如果是向下取整
        if (ConvertUtil.ROUND.equals(round)) {
            minutes = String.valueOf(merchant);
        }

        return minutes;
    }

    public static String getLocalDateTimeStr(Date date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return dateTimeFormatter.format(localDateTime);
    }

    public static String getLocalDateTimeStr(Date date, String formatter) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formatter);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        return dateTimeFormatter.format(localDateTime);
    }

    public static void main(String[] args) {
        String s = secondsToMinutes("30", ConvertUtil.FLOOR);
        System.out.println(s);
        String s1 = secondsToMinutes("90", ConvertUtil.FLOOR);
        System.out.println(s1);
        String s2 = secondsToMinutes("90.01", ConvertUtil.ROUND);
        System.out.println(s2);

        // Math.floor() 向上取整；
        // Math.round() 向下取整；
    }
}