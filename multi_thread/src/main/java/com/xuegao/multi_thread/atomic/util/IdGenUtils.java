package com.xuegao.multi_thread.atomic.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <br/> @PackageName：com.xuegao.multi_thread.atomic.util
 * <br/> @ClassName：IdGenUtils
 * <br/> @Description：
 * <br/> @Description：特别说明，分布式环境下，不允许使用这个
 * <br/> @Description：
 * <br/> @Description：因为在分布式部署下，Nginx代理多台服务器，在高并发情况下，会导致唯一id不唯一
 * <br/> @Description：因为jar包是部署在多台服务器下的，每台服务器都会使用这个工具类去生成唯一id
 * <br/> @Description：在高并发下，四台八台服务器会因为同时请求导致 id 重复
 * <br/> @Description：
 * <br/> @Description：建议使用 redis 或者 数据库
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 11:59
 */
public final class IdGenUtils {
    private static final Logger logger = LoggerFactory.getLogger(IdGenUtils.class);
    private static final Pattern PATTERN_HOSTNAME = Pattern.compile("^.*\\D+([0-9]+)$");
    private static final long OFFSET = LocalDate.of(2000, 1, 1).atStartOfDay(ZoneId.of("Z")).toEpochSecond();
    private static final long MAX_NEXT = 65535L;
    private static final long SHARD_ID = getServerIdAsLong();
    private static long offset = 0L;
    private static long lastEpoch = 0L;

    public IdGenUtils() {
    }

    public static long genId() {
        return nextId(System.currentTimeMillis() / 1000L);
    }

    private static synchronized long nextId(long epochSecond) {
        if (epochSecond < lastEpoch) {
            epochSecond = lastEpoch;
        }

        if (lastEpoch != epochSecond) {
            lastEpoch = epochSecond;
            reset();
        }

        ++offset;
        long next = offset & 65535L;
        return next == 0L ? nextId(epochSecond + 1L) : generateId(epochSecond, next, SHARD_ID);
    }

    private static void reset() {
        offset = 0L;
    }

    private static long generateId(long epochSecond, long next, long shardId) {
        return epochSecond - OFFSET << 21 | next << 5 | shardId;
    }

    private static long getServerIdAsLong() {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            Matcher matcher = PATTERN_HOSTNAME.matcher(hostname);
            if (matcher.matches()) {
                long n = Long.parseLong(matcher.group(1));
                if (n >= 0L && n < 8L) {
                    logger.info("detect server id from host name {}: {}.", hostname, n);
                    return n;
                }
            }
        } catch (UnknownHostException var4) {
            logger.warn("unable to get host name. set server id = 0.");
        }

        return 0L;
    }
}
