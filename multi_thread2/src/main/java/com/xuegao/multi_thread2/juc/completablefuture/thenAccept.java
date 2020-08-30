package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：thenAccept
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 13:28
 */
public class thenAccept {
    public static void main(String[] args) {

        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(s -> s + " World")
                .thenApply(s -> s + "\nThis is CompletableFuture demo")
                .thenApply(String::toLowerCase)
                .thenAccept(System.out::print);

    }
}