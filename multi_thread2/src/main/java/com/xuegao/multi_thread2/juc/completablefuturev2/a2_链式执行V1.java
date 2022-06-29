package com.xuegao.multi_thread2.juc.completablefuturev2;

import com.xuegao.multi_thread2.constant.MyThreadPool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/17 0:59
 */
public class a2_链式执行V1 {
    // thenAccept
    // 接收前一个方法返回值，进行处理

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture cf = CompletableFuture
                .supplyAsync(() -> "I am Cool", MyThreadPool.POOL_EXECUTOR)
                .thenAccept(msg -> System.out.printf("[%s] %s and am also Awesome\n",
                        Thread.currentThread().getName(), msg));
        cf.get();

        System.out.println("===============================================");

        CompletableFuture cf2 = CompletableFuture
                .supplyAsync(() -> "I am Cool", MyThreadPool.POOL_EXECUTOR)
                .thenAcceptAsync(msg -> System.out.printf("[%s] %s and am also Awesome\n",
                        Thread.currentThread().getName(), msg), MyThreadPool.POOL_EXECUTOR);
        cf2.get();
    }
}