package com.xuegao.luanqibazao_1.jdk8.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8
 * <br/> @ClassName：检测日期是否正常
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/28 18:16
 */
public class 检测日期是否正常 {
    public static void main(String[] args) {

        DateTimeFormatter DATE_FORMATTER =
                new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd")
                        .toFormatter();
        Instant instant = LocalDate.from(DATE_FORMATTER.parse("2020-06-31"))
                .atStartOfDay()
                .atZone(ZoneId.of("Asia/Kuala_Lumpur"))
                .toInstant();
        System.out.println(instant);

        // 2020-06-30
        LocalDate from = LocalDate.from(DATE_FORMATTER.parse("2020-06-31"));
        System.out.println(from.format(DATE_FORMATTER));

        // Exception in thread "main" java.time.format.DateTimeParseException: Text '2020-06-31' could not be parsed: Invalid date 'JUNE 31'
        // 6月只有30天
        LocalDate localDate1 = LocalDate.parse("2020-06-31");
        System.out.println("djkfhdsjkfsdhfjksdf");
    }
}