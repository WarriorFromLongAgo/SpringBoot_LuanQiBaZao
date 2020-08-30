package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：thenApplyAsync2
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:10
 */
public class thenApplyAsync2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture类的API中大部分都有两个以Async结尾的变种。这些方法通常是用于运行另一个线程的执行步骤。
        // 带有Async后缀的方法通过调用一个线程来执行下一个执行阶段。
        // Async方法中没有使用Executor线程池参数的 会使用公共的fork/join线程池框架比如ForkJoinPool.commonPool()来执行。
        // 带有Executor参数的Async方法通过Executor线程池运行下一步。
        // 10.异步方法
        CompletableFuture<String> completableFuture7 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future4 = completableFuture7.thenApplyAsync(s -> s + " World");
        System.out.println(future4.get());
        // Hello World



    }

}