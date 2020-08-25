package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：实战1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/24 18:58
 */
public class 实战1_同一个线程 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return Thread.currentThread().getName();
            }
        });
        TimeUnit.SECONDS.sleep(3);
        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return Thread.currentThread().getName();
            }
        });
        TimeUnit.SECONDS.sleep(3);
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("run = " + Thread.currentThread().getName());
            }
        });
        TimeUnit.SECONDS.sleep(3);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("run = " + Thread.currentThread().getName());
            }
        });
        TimeUnit.SECONDS.sleep(3);
        System.out.println(stringCompletableFuture1.get());
        System.out.println(stringCompletableFuture2.get());
        System.out.println("=======================");
        System.out.println(completableFuture1.get());
        System.out.println(completableFuture2.get());

        // run = ForkJoinPool.commonPool-worker-9
        // run = ForkJoinPool.commonPool-worker-9
        // ForkJoinPool.commonPool-worker-9
        // ForkJoinPool.commonPool-worker-9
        // =======================
        // null
        // null
    }
}