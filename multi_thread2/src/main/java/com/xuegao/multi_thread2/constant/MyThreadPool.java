package com.xuegao.multi_thread2.constant;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/17 1:02
 */
public class MyThreadPool {
    private static final AtomicInteger COUNT = new AtomicInteger();
    public static final ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPoolBusiness" + COUNT.incrementAndGet()));
}