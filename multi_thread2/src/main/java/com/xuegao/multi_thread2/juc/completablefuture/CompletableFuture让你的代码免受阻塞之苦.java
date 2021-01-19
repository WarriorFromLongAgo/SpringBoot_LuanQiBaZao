package com.xuegao.multi_thread2.juc.completablefuture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：CompletableFuture让你的代码免受阻塞之苦
 * <br/> @Description：https://juejin.cn/post/6897844374093496328
 * <br/> @author：xuegao
 * <br/> @date：2020/11/30 11:08
 */
public class CompletableFuture让你的代码免受阻塞之苦 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Void unused = voidCompletableFuture.get();


        // CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
        //     @Override
        //     public String get() {
        //         try {
        //             System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        //             TimeUnit.SECONDS.sleep(5);
        //             System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //         return "Welcome ABC";
        //     }
        // });
        // System.out.println(stringCompletableFuture.get());
    }
}