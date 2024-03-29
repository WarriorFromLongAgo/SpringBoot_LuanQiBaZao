package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：exception
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 20:03
 */
public class exceptionally {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int a = 2 / 0;
                return 2222222;
            }
        }).exceptionally(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) {
                System.out.println(throwable.getMessage());
                return 0;
            }
        });
        // java.lang.ArithmeticException: / by zero
        // 0
        System.out.println(completableFuture.get());
    }
}