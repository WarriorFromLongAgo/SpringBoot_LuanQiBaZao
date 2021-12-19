package com.xuegao.luanqibazao_1.common;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/18 17:38
 */
public class ThreadPoolOne {
    private static final AtomicInteger COUNT = new AtomicInteger();
    private static final ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            1L,
            java.util.concurrent.TimeUnit.MILLISECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPoolOne" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getInstance() {
        return POOL_EXECUTOR;
    }

}