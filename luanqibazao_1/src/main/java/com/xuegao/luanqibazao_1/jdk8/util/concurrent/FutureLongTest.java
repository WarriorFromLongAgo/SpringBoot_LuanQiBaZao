package com.xuegao.luanqibazao_1.jdk8.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <br/> @ClassName：FutureTest
 * <br/> @Description：
 * <br/> @date：2021/9/6 12:14
 */
public class FutureLongTest {
    private static AtomicInteger count = new AtomicInteger();
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            5,
            10,
            1,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(100));

    public static void main(String[] args) {
        List<Future<Long>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureList.add(threadPoolExecutor.submit(new AsyncPeerOfferTemplateExportLong()));
        }
        long maxWaitSecond = 5;

        long start = System.currentTimeMillis();
        System.out.println("开始，" + start);
        try {
            for (Future<Long> future : futureList) {
                Long integer = future.get(maxWaitSecond, TimeUnit.SECONDS);
                System.out.println(integer);
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("结束，" + (end - start));
        threadPoolExecutor.shutdown();
    }

    public static class AsyncPeerOfferTemplateExportLong implements Callable<Long> {

        @Override
        public Long call() throws Exception {
            long l = ThreadLocalRandom.current().nextLong(5L);
            TimeUnit.SECONDS.sleep(l);
            return l;
        }
    }
}