package com.xuegao.multi_thread2.limit2;

/**
 * <br/> @PackageName：com.xuegao.multi_thread.limit2
 * <br/> @ClassName：LeakyBucketThrottler
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/7/12 13:25
 */
public class LeakyBucketThrottler {
    /**
     * 当前桶内剩余的水
     */
    private long left;
    /**
     * 上次成功注水的时间戳
     */
    private long lastInjectTime = System.currentTimeMillis();
    /**
     * 桶的容量
     */
    private long capacity;
    /**
     * 一桶水漏完的时间
     */
    private long duration;
    /**
     * 桶漏水的速度，即 capacity / duration
     */
    private double velocity;

    public boolean tryAcquire(String key) {
        long now = System.currentTimeMillis();
        // 当前剩余的水 = 之前的剩余水量 - 过去这段时间内漏掉的水量
        // 过去这段时间内漏掉的水量 = (当前时间-上次注水时间) * 漏水速度
        // 如果当前时间相比上次注水时间相隔太久（一直没有注水），桶内的剩余水量就是0（漏完了）
        left = Math.max(0, left - (long) ((now - lastInjectTime) * velocity));
        // 往当前水量基础上注一单位水，只要没有溢出就代表可以访问
        if (left + 1 <= capacity) {
            lastInjectTime = now;
            left++;
            return true;
        } else {
            return false;
        }
    }
}