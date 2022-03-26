package com.xuegao.luanqibazao_1.jdk8.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.sql
 * <br/> @ClassName：TimestampTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/10/20 0:45
 */
public class TimestampTest {
    private static final Logger logger = LoggerFactory.getLogger(TimestampTest.class);

    public static void main(String[] args) {
        long time = 1634661468654L;
        Timestamp timestamp = new Timestamp(time);
        System.out.println(toString(timestamp, "yyyy-MM-dd HH:mm:ss"));

        Timestamp timestamp1 = Timestamp.valueOf("2022-01-12 00:00:00");
        System.out.println(toString(timestamp1, "yyyy-MM-dd HH:mm:ss"));

        Timestamp timestamp2 = Timestamp.valueOf("2022-01-12 00:00:00");
        System.out.println(toString(timestamp2, "yyyy-MM-dd HH:mm:ss"));

        System.out.println(timestamp1.compareTo(timestamp2));

        Timestamp datetime = getTimestamp();
        Timestamp timestamp20220326 = addDelayHour(datetime, 1.1D);
        System.out.println(toString(timestamp20220326, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 将时间，加上 delayHour
     */
    public static Timestamp addDelayHour(Timestamp timestamp, Double delayHourDouble) {
        if (Objects.isNull(delayHourDouble)) {
            return timestamp;
        }
        String delayHourStr = delayHourDouble.toString();
        if (!delayHourStr.contains(".")) {
            return addMinute(Integer.parseInt(delayHourStr) * 60, timestamp);
        }
        // 如果包含 点

        // 先把小时加上去
        String[] split = delayHourStr.split("\\.");
        String tempDelayHour = split[0];
        timestamp = addMinute(Integer.parseInt(tempDelayHour) * 60, timestamp);

        String tempDelayMinuteStr = split[1];
        // tempDelayMinuteStr 大于 0
        if (Integer.valueOf(tempDelayMinuteStr).compareTo(0) > 0) {
            // 加上分钟
            timestamp = addMinute(Integer.parseInt(tempDelayMinuteStr) * 6, timestamp);
        }
        return timestamp;
    }

    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp toTimestamp(String strDate) {
        return toTimestamp(strDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static Timestamp toTimestamp(String strDate, String pattern) {
        Timestamp result = null;

        try {
            Date date = toParse(new SimpleDateFormat(pattern), strDate);
            if (date != null) {
                result = new Timestamp(date.getTime());
            }
        } catch (Exception var4) {
            logger.error(String.format("Could not convert '%s' to Timestamp with pattern '%s'", strDate, pattern), var4);
        }

        return result;
    }

    private static Date toParse(SimpleDateFormat df, String dateString) {
        Date date = null;
        logger.debug("parse '{}' to Date with pattern '{}'", dateString, df.toPattern());
        if (dateString == null) {
            logger.error("strDate is null!");
        } else {
            try {
                date = new Date(df.parse(dateString).getTime());
            } catch (Exception var4) {
                logger.error(String.format("Could not parse '%s' to Date with pattern '%s'", dateString, df.toPattern()), var4);
            }
        }

        return date;
    }

    public static String toString(Date date, String pattern) {
        String result = "";

        try {
            result = toFormat(new SimpleDateFormat(pattern), date);
        } catch (Exception var4) {
            logger.error(String.format("Could not format '%tc' to String with pattern '%s'", date, pattern), var4);
        }

        return result;
    }

    public static String toString(Timestamp date, String pattern) {
        String result = "";

        try {
            result = toFormat(new SimpleDateFormat(pattern), date);
        } catch (Exception var4) {
            logger.error(String.format("Could not format '%tc' to String with pattern '%s'", date, pattern), var4);
        }

        return result;
    }

    private static String toFormat(SimpleDateFormat df, Date date) {
        String dateStr = null;
        logger.debug("format {} to String with pattern '{}'", date, df.toPattern());
        if (date == null) {
            logger.error("aDate is null!");
        } else {
            try {
                dateStr = df.format(date);
            } catch (Exception var4) {
                logger.error(String.format("Could not format '%tc' to String with pattern '%s'", date, df.toPattern()), var4);
            }
        }

        return dateStr;
    }

    private static String toFormat(SimpleDateFormat df, Timestamp date) {
        String dateStr = null;
        logger.debug("format {} to String with pattern '{}'", date, df.toPattern());
        if (date == null) {
            logger.error("aDate is null!");
        } else {
            try {
                dateStr = df.format(date);
            } catch (Exception var4) {
                logger.error(String.format("Could not format '%tc' to String with pattern '%s'", date, df.toPattern()), var4);
            }
        }

        return dateStr;
    }

    public static Timestamp addMinute(int minute, Timestamp time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time.getTime()));
        calendar.add(Calendar.MINUTE, minute);
        return new Timestamp(calendar.getTime().getTime());
    }
}