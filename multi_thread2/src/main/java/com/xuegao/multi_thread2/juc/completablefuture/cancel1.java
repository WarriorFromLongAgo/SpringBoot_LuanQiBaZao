package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：cancel1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:09
 */
public class cancel1 {

    public static void main(String[] args) throws InterruptedException {
        Future<String> future = calculateAsyncWithCancellation();
        // String s = future.get();
        // System.out.println("result3 = " + s);
        // 结果：
        // Exception in thread "main" java.util.concurrent.CancellationException
        // at java.base/java.util.concurrent.CompletableFuture.cancel(CompletableFuture.java:2475)
        // at main.java.com.yoyocheknow.java8.CompletableFutureTest.lambda$calculateAsyncWithCancellation$6(CompletableFutureTest.java:126)
        // at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        // at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        // at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        // at java.base/java.lang.Thread.run(Thread.java:830)
    }


    public static Future<String> calculateAsyncWithCancellation() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);
            return "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
        });

        return completableFuture;
    }
}