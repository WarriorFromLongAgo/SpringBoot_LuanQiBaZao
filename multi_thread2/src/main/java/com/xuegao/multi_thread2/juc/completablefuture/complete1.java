package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：complete
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/18 20:16
 */
public class complete1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        future.complete("World");

        try {
            System.out.println(future.get());
            // World
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}