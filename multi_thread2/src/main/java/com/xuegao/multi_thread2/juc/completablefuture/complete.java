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
public class complete {
    public static Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Future<String> hello = Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return "aaaaaaaaaaaaaaaaaaaa";
        });

        return completableFuture;
    }

    public static Future<String> calculateAsyncWithCancellation() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);
            return "aaaaaaaaaaaaaaaaaaaaaaaaaaa";
        });

        return completableFuture;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<String> completableFuture = calculateAsync();
        String result = completableFuture.get();
        System.out.println("result=" + result);
        // result=Hello
        // 通过Future提供的complete方法可以结束这个运算。

        // 如果你已经直到来计算的结果，你可以使用静态方法completedFuture()，带有一个参数代表它计算的一个结果。那么Future的get()方法将永远不会阻塞，相反会立马返回结果。
        Future<String> completableFuture2 = CompletableFuture.completedFuture("Hello222222222222222222");
        String result2 = completableFuture2.get();
        System.out.println("result2=" + result2);

        Future<String> future = calculateAsyncWithCancellation();
        // String s = future.get();
        // System.out.println("result3 = " + s);
        // 结果：
        // Exception in thread "main" java.util.concurrent.CancellationException
        // at java.base/java.util.concurrent.CompletableFuture.cancel(CompletableFuture.java:2475)
        // at main.java.com.yoyocheknow.java8.CompletableFutureTest.lambda$calculateAsyncWithCancellation$6(CompletableFutureTest.java:126)
        // at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
        // at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
        // at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
        // at java.base/java.lang.Thread.run(Thread.java:830)


        CompletableFuture<String> completableFuture3
                = CompletableFuture.supplyAsync(() -> "Hello ")
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> " World "), (s1, s2) -> s1 + s2);

        System.out.println(completableFuture3.get());
        // Hello  World

        // 处理异步计算结果
        CompletableFuture completableFuture4 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World 4"),
                        (s1, s2) -> System.out.println(s1 + s2));
        System.out.println(completableFuture4.get());
        // Hello World 4
        // null

        // thenApply()和thenCompose()之间的不同
        // 在我们前面的部分当中，我们展示了thenApply()和thenCompose()的使用方法。两个API被用在CompletableFuture调用链当中，但是这两者之间使用是不同的。
        // thenApply()
        // 这个方法被用来处理前一个调用的结果。然而，一个关键的点就是要记住，所有调用的返回值将会被组合。
        // 所以这个方法在我们想要转化一个CompletableFuture结果时是有用的。
        // CompletableFuture<Integer> finalResult = compute().thenApply(s-> s + 1);

        // thenCompose()
        // 这个方法和thenApply()类似都会返回一个新的执行阶段。thenCompose()使用前面的阶段作为参数。
        // 它将会打平并且返回一个带有结果的Future，而不是像thenApply()那样嵌套的结果。
        // CompletableFuture<Integer> computeAnother(Integer i){
        //     return CompletableFuture.supplyAsync(() -> 10 + i);
        // }
        // CompletableFuture<Integer> finalResult = compute().thenCompose(this::computeAnother);

        // 所以要想对CompletableFuture方法以链的形式呈现，最好使用thenCompose()方法。另外注意，这两个方法之间的不同是和map() 与flatMap()之间的不同是类似的。





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

        CompletableFuture<String> completableFuture6 = new CompletableFuture<>();
        // completableFuture6.completeExceptionally(new RuntimeException("Calculation failed!"));
        // completableFuture6.get(); // ExecutionException
        // Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.RuntimeException: Calculation failed!
        //         at java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:357)
        // at java.util.concurrent.CompletableFuture.get(CompletableFuture.java:1895)
        // at com.xuegao.multi_thread2.atomic.completablefuture.complete.main(complete.java:138)
        // Caused by: java.lang.RuntimeException: Calculation failed! at com.xuegao.multi_thread2.atomic.completablefuture.complete.main(complete.java:137)


        // CompletableFuture类的API中大部分都有两个以Async结尾的变种。这些方法通常是用于运行另一个线程的执行步骤。
        // 带有Async后缀的方法通过调用一个线程来执行下一个执行阶段。
        // Async方法中没有使用Executor线程池参数的 会使用公共的fork/join线程池框架比如ForkJoinPool.commonPool()来执行。
        // 带有Executor参数的Async方法通过Executor线程池运行下一步。
        // 10.异步方法
        CompletableFuture<String> completableFuture7 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future4 = completableFuture7.thenApplyAsync(s -> s + " World");
        System.out.println(future4.get());
        // Hello World


    }

}