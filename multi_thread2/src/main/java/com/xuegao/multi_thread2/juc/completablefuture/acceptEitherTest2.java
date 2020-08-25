package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic
 * <br/> @ClassName：acceptEitherTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/22 19:11
 */
public class acceptEitherTest2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("welcome abc");
            }
        }).acceptEither(CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("welcome xyz");
            }
        }), new Consumer<Void>() {
            @Override
            public void accept(Void unused) {
                System.out.println("Consumer 1 = " + unused);
            }
        }).acceptEither(CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                System.out.println("welcome opq");
            }
        }), new Consumer<Void>() {
            @Override
            public void accept(Void unused) {
                System.out.println("Consumer 2 = " + unused);
            }
        });
    }
}