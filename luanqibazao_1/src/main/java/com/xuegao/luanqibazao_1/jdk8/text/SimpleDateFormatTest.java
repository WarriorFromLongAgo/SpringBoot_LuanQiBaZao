package com.xuegao.luanqibazao_1.jdk8.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.text
 * <br/> @ClassName：SimpleDateFormatTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/8 18:13
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date parse = format.parse("2021-05");
        System.out.println(parse);
        Date date = new Date();
        String format1 = format.format(date);
        System.out.println(format1);

        LocalDate localDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());

    }
}