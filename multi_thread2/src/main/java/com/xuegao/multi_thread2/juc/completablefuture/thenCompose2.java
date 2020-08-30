package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test7
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 20:22
 */
public class thenCompose2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        noLambda();
    }

    private static void noLambda() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        }).thenCompose(new Function<String, CompletableFuture<String>>() {
            @Override
            public CompletableFuture<String> apply(String s) {
                return CompletableFuture.supplyAsync(new Supplier<String>() {
                    @Override
                    public String get() {
                        return s + " World";
                    }
                });
            }
        });
        // Hello World
        System.out.println(stringCompletableFuture.get());
    }

    private static void lambda() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}