package com.xuegao.multi_thread2.atomic.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test5
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/22 20:13
 */
public class test5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 2;
            }
        }).thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("0000 ==== " + integer);
            }
        });
        System.out.println(completableFuture.get());
    }
}