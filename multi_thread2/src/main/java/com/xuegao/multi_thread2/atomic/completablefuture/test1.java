package com.xuegao.multi_thread2.atomic.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic
 * <br/> @ClassName：test1
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/22 19:11
 */
public class test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return Thread.currentThread().getName();
            }
        });

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("run = " + Thread.currentThread().getName());
            }
        });

        System.out.println(stringCompletableFuture.get());
        System.out.println("=======================");
        System.out.println(completableFuture.get());

        // ForkJoinPool.commonPool-worker-9
        //         =======================
        // run = ForkJoinPool.commonPool-worker-9
        // null
    }
}