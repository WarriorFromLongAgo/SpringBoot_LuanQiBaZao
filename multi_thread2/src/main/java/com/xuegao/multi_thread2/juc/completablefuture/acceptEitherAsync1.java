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
public class acceptEitherAsync1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "Welcome ABC";
            }
        }).acceptEitherAsync(CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "Welcome XYZ";
            }
        }), new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println(voidCompletableFuture.get());
    }
}