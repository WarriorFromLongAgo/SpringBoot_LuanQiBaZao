package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：applyToEither1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/25 19:56
 */
public class applyToEither1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return " welcome ABC ";
            }
        });
        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return " welcome XYZ ";
            }
        });
        CompletableFuture<String> stringCompletableFuture = stringCompletableFuture1.applyToEither(stringCompletableFuture2, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "applyToEither = " + s;
            }
        });

        String s = stringCompletableFuture.get();
        System.out.println("finally = " + s);
    }
}