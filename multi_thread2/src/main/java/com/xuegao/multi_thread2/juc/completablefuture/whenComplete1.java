package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.future
 * <br/> @ClassName：CompletableFutureTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/18 12:56
 */
public class whenComplete1 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName() + "- 女神1：我开始化妆了，好了我叫你。");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "化妆完毕了。";
            }
        });
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(Thread.currentThread().getName() + "- 女神2：我开始化妆了，好了我叫你。");
                try {
                    TimeUnit.SECONDS.sleep(5);
                    int a = 2 / 0;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "化妆完毕了。";
            }
        });
        completableFuture1.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String returnStr, Throwable throwable) {
                if (throwable == null) {
                    System.out.println(Thread.currentThread().getName() + returnStr);
                } else {
                    System.out.println(Thread.currentThread().getName() + "女神放你鸽子了。");
                    throwable.printStackTrace();
                }
            }
        });
        completableFuture2.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String returnStr, Throwable throwable) {
                if (throwable == null) {
                    System.out.println(Thread.currentThread().getName() + returnStr);
                } else {
                    System.out.println(Thread.currentThread().getName() + "女神放你鸽子了。");
                    throwable.printStackTrace();
                }
            }
        });

        System.out.println(Thread.currentThread().getName() + "-等女神化妆的时候可以干点自己的事情。");
        Thread.currentThread().join();

        // ForkJoinPool.commonPool-worker-9- 女神1：我开始化妆了，好了我叫你。
        // ForkJoinPool.commonPool-worker-2- 女神2：我开始化妆了，好了我叫你。
        // main-等女神化妆的时候可以干点自己的事情。
        // ForkJoinPool.commonPool-worker-2女神放你鸽子了。
        // java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero

        // ForkJoinPool.commonPool-worker-9- 女神1：我开始化妆了，好了我叫你。
        // ForkJoinPool.commonPool-worker-2- 女神2：我开始化妆了，好了我叫你。
        // main-等女神化妆的时候可以干点自己的事情。
        // ForkJoinPool.commonPool-worker-9化妆完毕了。
        // ForkJoinPool.commonPool-worker-2女神放你鸽子了。
        // java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
    }
}