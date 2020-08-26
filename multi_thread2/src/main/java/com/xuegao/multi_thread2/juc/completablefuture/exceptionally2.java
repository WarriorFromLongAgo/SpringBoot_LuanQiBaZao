package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：exception
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 20:03
 */
public class exceptionally2 {
    public static void main(String[] args) {
        CompletableFuture<Void> exceptionally = CompletableFuture.supplyAsync(new Supplier<String>() {
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
        }).thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                // hello world thenApply
                System.out.println(s);
            }
        }).exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable throwable) {
                System.out.println("Unexpected error : " + throwable);
                return null;
            }
        });
        // Unexpected error : java.util.concurrent.CompletionException: java.lang.NullPointerException

    }
}