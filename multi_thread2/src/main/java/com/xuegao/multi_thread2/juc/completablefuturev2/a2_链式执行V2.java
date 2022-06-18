package com.xuegao.multi_thread2.juc.completablefuturev2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/6/17 0:59
 */
public class a2_链式执行V2 {
    // thenApply
    // 接收前一个方法返回值，进行处理

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> "I'm Awesome")
                /*这里的msg就是上一个异步任务的返回结果：I'm Awesome*/
                .thenApply(msg -> String.format("%s and am Super COOL !!!", msg))
                .thenApply(msg -> System.out.printf("%s\n", msg));
        cf.get();
        System.out.println("===============================================");

        CompletableFuture cf2 = CompletableFuture.supplyAsync(() -> "I'm Awesome")
                /*这里的msg就是上一个异步任务的返回结果：I'm Awesome*/
                .thenApplyAsync(msg -> String.format("%s and am Super COOL !!!", msg))
                .thenApplyAsync(msg -> System.out.printf("%s\n", msg));
        cf2.get();
    }
}