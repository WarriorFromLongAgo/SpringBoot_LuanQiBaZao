package com.xuegao.multi_thread2.juc.threadpoolexecutor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.threadpoolexecutor
 * <br/> @ClassName：CallableCase
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/3/7 22:46
 */
public class CallableCase {
    static ExecutorService executorService = new ThreadPoolExecutor(
            1, 10, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            new ThreadFactoryBuilder().setNameFormat("rain-thread-pool").build(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    public static void main(String[] args) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("rain", "bow");
        System.out.println("Begin To Submit Task !");
        Future<Map<String, String>> future = executorService.submit(new Processor(paramMap));

        System.out.println("Begin To Get Result !");
        try {
            Map<String, String> ret = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class Processor implements Callable<Map<String, String>> {
        private Map<String, String> paramMap;

        public Processor(Map<String, String> paramMap) {
            this.paramMap = paramMap;
        }

        @Override
        public Map<String, String> call() {
            System.out.println("Call To Call Process !");
            return paramMap;
        }
    }
    // Begin To Submit Task !
    // Begin To Get Result !
    // Call To Call Process !

    // 看上面执行的结果，发现好像是在future.get()的时候触发的call方法，这是一种误解；
    // 查看submit源码,如下，可以发现我们在submit提交任务的时候，就触发了任务的执行：

    // /**
    //  * @throws RejectedExecutionException {@inheritDoc}
    //  * @throws NullPointerException       {@inheritDoc}
    //  */
    // public <T> Future<T> submit(Callable<T> task) {
    //     if (task == null) throw new NullPointerException();
    //     RunnableFuture<T> ftask = newTaskFor(task);
    //     execute(ftask);
    //     return ftask;
    // }
    // 调用get方法等待检索计算结果。
}