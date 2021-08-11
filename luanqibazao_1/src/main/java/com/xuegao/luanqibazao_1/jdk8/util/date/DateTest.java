package com.xuegao.luanqibazao_1.jdk8.util.date;

import com.xuegao.luanqibazao_1.jdk8.net.InetAddressTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.util.date
 * <br/> @ClassName：DateTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/5/8 18:12
 */
public class DateTest {
    public static final String C_TIME_PATTON_DEFAULT = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        dateCompare();
    }

    public static void dateCompare() {
        String a = "2018-11-05 18:30:00";
        String b = "2018-11-04 18:30:00";
        Date aa = parseDate(a);
        Date bb = parseDate(b);
        int i = aa.compareTo(bb);
        System.out.println(i);

    }

    public static Date parseDate(String dateValue) {
        return parseDate(C_TIME_PATTON_DEFAULT, dateValue);
    }

    public static Date parseDate(String strFormat, String dateValue) {
        if (dateValue == null) {
            return null;
        }
        if (strFormat == null) {
            strFormat = C_TIME_PATTON_DEFAULT;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        Date newDate = null;

        try {
            newDate = dateFormat.parse(dateValue);
        } catch (Exception pe) {
            throw new RuntimeException(pe);
        }

        return newDate;
    }

    public static void String_to_LocalDate() {  // String 转 LocalDate
        String string1 = "2021-01-13";
        String string2 = "2021-02-13";
        String string3 = "2021-05-13";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate1 = LocalDate.parse(string1, formatter);
        LocalDate parsedDate2 = LocalDate.parse(string2, formatter);
        LocalDate parsedDate3 = LocalDate.parse(string3, formatter);

        LocalDate now = LocalDate.now();
        LocalDate with = now.with(TemporalAdjusters.firstDayOfMonth());

        boolean before1 = parsedDate1.isAfter(with);
        if (before1) {
            System.out.println("parsedDate1");
        }

        boolean before2 = parsedDate2.isAfter(with);
        if (before2) {
            System.out.println("parsedDate2");
        }

        boolean before3 = parsedDate3.isAfter(with);
        if (before3) {
            System.out.println("parsedDate3");
        }

        long l = now.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        Timestamp timestamp = new Timestamp(l);
        System.out.println(timestamp);
    }

    private static void filterList() {
        List<String> mysql = new ArrayList<>();
        mysql.add("2021-05-14");
        mysql.add("2021-06-25");
        mysql.add("2021-07-08");

        LocalDate localDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        List<String> stringList = testList();
        System.out.println(stringList);
        stringList = stringList.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println(s);
                if (s == null) {
                    return false;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
                LocalDate parsedDate = LocalDate.parse(s, formatter);
                return Boolean.FALSE.equals(parsedDate.isBefore(localDate));
            }
        }).collect(Collectors.toList());
        System.out.println(stringList);
    }

    private static List<String> testList() {
        List<String> stringList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i < 10) {
                stringList.add("2021-0" + i + "-10");
            } else {
                stringList.add("2021-" + i + "-10");
            }
        }
        stringList.add(null);
        stringList.add("2021-12-10");
        return stringList;
    }


    // // 本月的第一天
    // LocalDate localDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    // // 过滤一下，只保留当前月份的和之后月份的数据
    // customerStorageFeeList = customerStorageFeeList.stream().filter(imsCustomerStorageFee -> {
    //     // 为空的，直接过滤
    //     if (ObjectUtils.isEmpty(imsCustomerStorageFee)) {
    //         return Boolean.FALSE;
    //     }
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //     LocalDate parsedDate = LocalDate.parse(imsCustomerStorageFee.getMonth(), formatter);
    //     // 过滤一下，只保留当前月份的和之后月份的数据
    //     return Boolean.FALSE.equals(parsedDate.isBefore(localDate));
    // }).collect(Collectors.toList());
    //
    //     System.out.println(customerStorageFeeList);
    //
    // List<CustomerStorageFee> mysqlCustomerStorageFeeList = selectAllForColumns(customerStorageFee);

}