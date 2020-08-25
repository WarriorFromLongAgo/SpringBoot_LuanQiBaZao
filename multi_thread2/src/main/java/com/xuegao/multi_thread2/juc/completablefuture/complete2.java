package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：complete
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/18 20:16
 */
public class complete2 {
    public static Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Future<String> hello = new ThreadPoolExecutor(1, 1, 1000L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("hello");
                return thread;
            }
        }).submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return "aaaaaaaaaaaaaaaaaaaa";
        });

        return completableFuture;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> completableFuture = calculateAsync();
        String result = completableFuture.get();
        System.out.println("result = " + result);
        // result=Hello
        // 通过Future提供的complete方法可以结束这个运算。
    }
}