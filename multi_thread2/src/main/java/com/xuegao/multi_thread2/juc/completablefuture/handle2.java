package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：handle2
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 13:21
 */
public class handle2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> completableFuture5 = CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
        System.out.println(completableFuture5.get());
        // Hello, Stranger!
        // handle 处理 异常
        // 上面的例子中我们可以使用handle()方法处理异步异常，但是使用get()方法我们可以使用一个更为典型的异步异常处理方式。
    }
}