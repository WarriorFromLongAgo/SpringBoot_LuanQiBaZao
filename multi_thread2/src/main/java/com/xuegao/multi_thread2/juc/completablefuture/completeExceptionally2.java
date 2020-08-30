package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：completeExceptionally3
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:08
 */
public class completeExceptionally2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture6 = new CompletableFuture<>();
        completableFuture6.completeExceptionally(new RuntimeException("Calculation failed!"));
        completableFuture6.get();
        // ExecutionException
        // Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.RuntimeException: Calculation failed!
        //         at java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:357)
        // at java.util.concurrent.CompletableFuture.get(CompletableFuture.java:1895)
        // at com.xuegao.multi_thread2.atomic.completablefuture.complete.main(complete.java:138)
        // Caused by: java.lang.RuntimeException: Calculation failed! at com.xuegao.multi_thread2.atomic.completablefuture.complete.main(complete.java:137)

    }
}