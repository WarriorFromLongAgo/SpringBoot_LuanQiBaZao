package com.xuegao.multi_thread2.limit2;

/**
 * <br/> @PackageName：com.xuegao.multi_thread.limit2
 * <br/> @ClassName：SimpleWindowThrottler
 * <br/> @Description：单机流控
 * <br/> @author：feijm
 * <br/> @date：2020/7/12 13:22
 */
public class SimpleWindowThrottler {

    /**
     * 毫秒为单位的时间窗口
     */
    private final long windowInMs = 0;
    /**
     * 时间窗口内最大允许的阈值
     */
    private final int threshold = 0;
    /**
     * 最后一次成功请求时间
     */
    private long lastReqTime = System.currentTimeMillis();
    /**
     * 计数器
     */
    private long counter;

    public boolean tryAcquire(String key) {
        long now = System.currentTimeMillis();
// 如果当前时间已经超过了上一次访问时间开始的时间窗口，重置计数器，以当前时间作为新窗口的起始值
        if (now - lastReqTime > windowInMs) {
            counter = 0;
            lastReqTime = now;
        }
        if (counter < threshold) {
            counter++;
            return true;
        } else {
            return false;
        }
    }
}