package com.xuegao.multi_thread2.juc.completablefuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：串行化
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/14 14:27
 */
public class 串行化 {
    private final static Logger log = LoggerFactory.getLogger(串行化.class);

    public static void main(String[] args) throws Exception {
        // 第一个任务:
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务:
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        String s = cfQuery.get();
        System.out.println("cfQuery = " + s);
        Double aDouble = cfFetch.get();
        System.out.println("aDouble = " + aDouble);
    }

    static String queryCode(String name) {
        try {
            log.info(" name ");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            log.info("fetchPrice");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }

    // 14:31:00.367 [ForkJoinPool.commonPool-worker-9] INFO com.xuegao.multi_thread2.juc.completablefuture.串行化 -  name
    // cfQuery = 601857
    // 14:31:10.371 [ForkJoinPool.commonPool-worker-9] INFO com.xuegao.multi_thread2.juc.completablefuture.串行化 - fetchPrice
    // price: 11.591300200670151
    // aDouble = 11.591300200670151
}