package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：test8
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 20:33
 */
public class test8 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {

                try {
                    Thread.sleep(12000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return 2;
            }
        }).acceptEither(CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1;
            }
        }), new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("0000 ==== " + integer);
            }
        });
        System.out.println(completableFuture.get());
    }
}