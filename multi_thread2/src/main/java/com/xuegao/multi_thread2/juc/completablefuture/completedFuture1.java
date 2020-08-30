package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.completablefuture
 * <br/> @ClassName：completedFuture1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/30 12:10
 */
public class completedFuture1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 如果你已经直到来计算的结果，你可以使用静态方法completedFuture()，带有一个参数代表它计算的一个结果。
        // 那么Future的get()方法将永远不会阻塞，相反会立马返回结果。
        Future<String> completableFuture2 = CompletableFuture.completedFuture("Hello222222222222222222");
        String result2 = completableFuture2.get();
        System.out.println("result2 = " + result2);
    }

}