package com.xuegao.multi_thread2.atomic.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test10
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/7/22 20:42
 */
public class test10 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        });
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 2;
            }
        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFuture1, completableFuture2);
        System.out.println("waiting all task finish..");
        System.out.println(voidCompletableFuture.get());
        System.out.println("all task finish");
    }
}