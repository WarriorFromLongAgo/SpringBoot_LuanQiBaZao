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
public class acceptEitherTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Welcome ABC";
            }
        }).acceptEither(CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return "Welcome XYZ";
            }
        }), new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }).acceptEither(CompletableFuture.supplyAsync(new Supplier<Void>() {
            @Override
            public Void get() {
                System.out.println("Welcome OPQ");
                return null;
            }
        }), new Consumer<Void>() {
            @Override
            public void accept(Void unused) {
                System.out.println(" Consumer 3 = ");
            }
        });
        Void unused = voidCompletableFuture.get();
        System.out.println(unused);
    }
}