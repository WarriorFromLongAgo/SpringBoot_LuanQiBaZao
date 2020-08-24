package com.xuegao.multi_thread2.java代码模拟并发;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：CompletableFutureTest1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/24 18:40
 */
public class CompletableFutureTest1 {
    public static void main(String[] args) {
        CompletableFuture<Void> voidCompletableFuture1 = new CompletableFuture<>();
        CompletableFuture<Void> voidCompletableFuture2 = new CompletableFuture<>();
        List<CompletableFuture> completableFutureList = new ArrayList<>();

        CompletableFuture.allOf(voidCompletableFuture1, voidCompletableFuture2);
        CompletableFuture.allOf(voidCompletableFuture1, voidCompletableFuture2);


    }
}