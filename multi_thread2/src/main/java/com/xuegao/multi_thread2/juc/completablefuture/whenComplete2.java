package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test3
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 20:06
 */
public class whenComplete2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello world";
            }
        }).thenApply(new Function<String, String>() {
            @Override
            public String apply(String s) {
                s = null;
                int length = s.length();
                return s + " thenApply ";
            }
        }).whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String result, Throwable throwable) {
                if (throwable != null) {
                    // Unexpected error : java.util.concurrent.CompletionException: java.lang.NullPointerException
                    System.out.println("Unexpected error : " + throwable);
                } else {
                    // hello world thenApply
                    System.out.println(result);
                }
            }
        });
        // hello world thenApply
        // 或者是 红色的 堆栈报错
        String s1 = stringCompletableFuture.get();
        System.out.println(s1);
    }
}