package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：thenAcceptBoth1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:06
 */
public class thenAcceptBoth2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Hello ";
            }
        });
        CompletableFuture<Void> voidCompletableFuture = stringCompletableFuture1.thenAcceptBoth(CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return " World!";
            }
        }), new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + s2);
            }
        });
        System.out.println(voidCompletableFuture.get());
        // Hello  World!
        // null
    }
}