package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：anyOf1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/26 19:16
 */
public class anyOf1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                try {
                    Thread.sleep(10000);
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
        // 在任何一个Future对象结束后结束，并返回一个future。
        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(completableFuture2, completableFuture1);
        System.out.println(completableFuture.get());
    }
}