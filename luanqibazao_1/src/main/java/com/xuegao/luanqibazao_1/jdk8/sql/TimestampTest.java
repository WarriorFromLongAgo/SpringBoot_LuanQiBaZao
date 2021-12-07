package com.xuegao.luanqibazao_1.jdk8.sql;

import java.sql.Timestamp;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.sql
 * <br/> @ClassName：TimestampTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/10/20 0:45
 */
public class TimestampTest {
    public static void main(String[] args) {
        long time = 1634661468654L;
        Timestamp timestamp = new Timestamp(time);
        System.out.println(timestamp);

        Timestamp timestamp1 = Timestamp.valueOf("1634661468654");
        System.out.println(timestamp1);

    }
}