package com.xuegao.luanqibazao_1.jdk8.util.concurrent.completablefuture;

import java.util.concurrent.*;
import java.util.function.BiConsumer;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/8 18:58
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3, new ThreadFactory() {
            private volatile int count = 0;

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, String.valueOf(count++));
            }
        });

        for (int i = 0; i < 3; i++) {
            CompletableFuture<Void> complete = CompletableFuture
                    .runAsync(() -> {
                        System.out.print(Thread.currentThread().getName() + " = A = ");
                        long id = Thread.currentThread().getId();
                        System.out.println(id);
                    }, executorService)
                    .whenComplete((unused, throwable) -> {
                        System.out.print(Thread.currentThread().getName() + " = B = ");
                        long id = Thread.currentThread().getId();
                        System.out.println(id);
                    })
                    .whenComplete(new BiConsumer<Void, Throwable>() {
                        @Override
                        public void accept(Void unused, Throwable throwable) {
                            System.out.print(Thread.currentThread().getName() + " = C = ");
                            long id = Thread.currentThread().getId();
                            System.out.println(id);
                        }
                    });
            complete.get();
        }
        executorService.shutdown();
    }
}