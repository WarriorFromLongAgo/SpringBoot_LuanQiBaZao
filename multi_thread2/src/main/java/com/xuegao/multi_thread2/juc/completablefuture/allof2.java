package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：allof1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/25 20:05
 */
public class allof2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 合并特性
        // 当我们需要以并行的方式执行多个Futures时，我们通常想要等待他们所有执行完然后处理他们组合的结果。
        // 以并行的方式运行多个Futures
        // CompletableFuture的allOf静态方法允许等待所有Futures的完成。
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture.allOf(future1, future2, future3)
                .thenApply(v ->
                        Stream.of(future1, future2, future3)
                                .map(new Function<CompletableFuture<String>, String>() {
                                    @Override
                                    public String apply(CompletableFuture<String> stringCompletableFuture) {
                                        return stringCompletableFuture.join();
                                    }
                                })
                                .collect(Collectors.joining(" ")))
                .thenAccept(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        // Hello Beautiful World
                        System.out.println(s);
                    }
                });
    }
}