package com.xuegao.multi_thread2.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.completablefuture
 * <br/> @ClassName：complete
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/18 20:16
 */
public class complete3 {

    public static CompletableFuture<Integer> compute() {
        return new CompletableFuture<>();
    }

    public static void main(String[] args) throws Exception {
        final CompletableFuture<Integer> completableFuture = compute();
        class Client extends Thread {
            final CompletableFuture<Integer> completableFuture;

            Client(String threadName, CompletableFuture<Integer> completableFuture) {
                super(threadName);
                this.completableFuture = completableFuture;
            }

            @Override
            public void run() {
                try {
                    System.out.println(this.getName() + ": " + completableFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        new Client("Client1", completableFuture).start();
        new Client("Client2", completableFuture).start();
        System.out.println("waiting");
        //设置Future.get()获取到的值
        completableFuture.complete(100);
        //以异常的形式触发计算
        completableFuture.completeExceptionally(new Exception());
        Thread.sleep(1000);
    }
}