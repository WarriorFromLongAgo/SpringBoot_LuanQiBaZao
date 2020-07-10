package com.xuegao.luanqibazao_1.auto_incr;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.auto_incr
 * <br/> @ClassName：snowflake_juejin
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 18:09
 */
public class snowflake_juejin {

    // https://juejin.im/post/5ef72f00e51d4534b0053766#heading-3
    public static void main(String[] args) {

    }

    // 起始时间
    private static final long snsEpoch = 1479692912967L;
    // 上次生成id的时间戳
    private long lastTimestamp = -1L;
    // 序列号（如果同一毫秒并发需要使用）
    private long lastSequence = 0L;
    // 数据中心
    private static final long DATA_ID = dataIdGen();
    // 机器
    private static final long WOKER_ID = workIdGen();


    public synchronized long nextId() {
        long timestamp = timeGen();

        // 不允许时钟回拨
        if (timestamp < this.lastTimestamp) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        // 上一次请求的时间戳和此刻相等，需要生成序列号
        if (this.lastTimestamp == timestamp) {
            lastSequence = lastSequence + 1;
            if (lastSequence > 4095L) {
                timestamp = nextMill(lastTimestamp); // 下一毫秒
                lastSequence = 0L;
            }
        } else {
            lastSequence = 0L;
        }

        // 上次生成id的时间戳
        lastTimestamp = timestamp;

        // 时间部分
        long timePart = timestamp - snsEpoch;

        return (timePart << 22) | (DATA_ID << 17) | (WOKER_ID << 12) | lastSequence;
    }

    /**
     * 获取当前毫秒数
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 下一毫秒
     */
    private long nextMill(long lastMill) {
        long cur = System.currentTimeMillis();
        while (lastMill <= cur) {
            cur = System.currentTimeMillis();
        }
        return cur;
    }

    /**
     * 数据中心Id，使用hostname（机器名）取余，值最大为5个bit最大值11111 = 31
     */
    private static long dataIdGen() {
        try {
            return getHostId(Inet4Address.getLocalHost().getHostName(), 31);
        } catch (UnknownHostException e) {
            return ThreadLocalRandom.current().nextLong(32);
        }
    }

    /**
     * 机器Id，使用hostadddress（IP地址）取余，获得的值最大为5个bit最大值11111 = 31
     */
    private static long workIdGen() {
        try {
            return getHostId(Inet4Address.getLocalHost().getHostAddress(), 31);
        } catch (UnknownHostException e) {
            return ThreadLocalRandom.current().nextLong(32);
        }
    }

    /**
     * 对字符串取余，获得的结果最大为max<br>
     * 为了将字符串转成一个Long
     */
    private static long getHostId(String value, int max) {
        byte[] bytes = value.getBytes();
        int sum = 0;
        for (byte b : bytes) {
            sum += b;
        }
        return sum % (max + 1);
    }
}