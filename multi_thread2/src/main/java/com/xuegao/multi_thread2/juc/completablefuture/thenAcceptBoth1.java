package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：thenAcceptBoth1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:06
 */
public class thenAcceptBoth1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 处理异步计算结果
        CompletableFuture completableFuture4 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello";
            }
        })
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World 4"),
                        (s1, s2) -> System.out.println(s1 + s2));
        System.out.println(completableFuture4.get());
        // Hello World 4
        // null
    }
}