package com.xuegao.multi_thread.limit2;

import java.util.concurrent.atomic.LongAdder;

/**
 * <br/> @PackageName：com.xuegao.multi_thread.limit2
 * <br/> @ClassName：SimpleWindowThrottler2
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/7/12 13:23
 */
public class SimpleWindowThrottler2 {
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
    private volatile long lastReqTime = System.currentTimeMillis();
    /**
     * 计数器
     */
    private LongAdder counter = new LongAdder();


//     public boolean tryAcquire(String key) {
//         long now = System.currentTimeMillis();
// // 如果当前时间已经超过了上一次访问时间开始的时间窗口，重置计数器，以当前时间作为新窗口的起始值
//         if (now - lastReqTime > windowInMs) {
//             counter = counter;
//             lastReqTime = now;
//         }
//         if (counter < threshold) {
//             counter++;
//             return true;
//         } else {
//             return false;
//         }
//     }
}