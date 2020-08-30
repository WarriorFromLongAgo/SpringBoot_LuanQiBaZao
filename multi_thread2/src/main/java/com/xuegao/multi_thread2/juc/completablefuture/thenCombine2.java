package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：thenCombine2
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:06
 */
public class thenCombine2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture3
                = CompletableFuture.supplyAsync(() -> "Hello ")
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> " World "), (s1, s2) -> s1 + s2);

        System.out.println(completableFuture3.get());
        // Hello  World
    }
}