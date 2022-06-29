package com.xuegao.multi_thread2.juc.completablefuturev2;

import com.xuegao.multi_thread2.constant.MyThreadPool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/18 1:00
 */
public class a3_合并两个任务 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I'm Stunning", MyThreadPool.POOL_EXECUTOR)
                .thenCombineAsync(CompletableFuture.supplyAsync(() -> "am New !!!"),
                        (s1, s2) -> String.format("%s AND %s", s1, s2), MyThreadPool.POOL_EXECUTOR)
                .thenAcceptAsync(msg ->
                        System.out.printf("[%s] %s\n", Thread.currentThread().getName(), msg), MyThreadPool.POOL_EXECUTOR);
        cf.get();
    }
}