package com.xuegao.multi_thread2.atomic.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.executors
 * <br/> @ClassName：ExecutorsTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 19:40
 */
public class ExecutorsTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<Integer>> futureList = new ArrayList<>();
        Future<Integer> future_15 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(15);
                System.out.println("执行时长为 15 s的执行完成。");
                return 15;
            }
        });
        futureList.add(future_15);

        Future<Integer> future_5 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("执行时长为 5 s的执行完成。");
                return 5;
            }
        });
        futureList.add(future_5);

        Future<Integer> future_10 = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("执行时长为 10 s的执行完成。");
                return 10;
            }
        });
        futureList.add(future_10);

        System.out.println("开始准备获取结果");
        for (Future<Integer> future : futureList) {
            System.out.println("future.get() = " + future.get());
        }
        Thread.currentThread().join();

        // 作者：why技术
        // 链接：https://juejin.im/post/6861505662741676039
        // 来源：掘金
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        // 开始准备获取结果
        // 执行时长为 5 s的执行完成。
        // 执行时长为 10 s的执行完成。
        // 执行时长为 15 s的执行完成。
        // future.get() = 15
        // future.get() = 5
        // future.get() = 10

        // 三个异步任务，
        // 耗时最长的最先执行，所以最先进入 list，
        // 因此当在循环中获取这个任务结果的时候 get 操作会一直阻塞，
        // 即使执行时间为 5s/10s 的任务已经执行完成。

        // 谁先进队，谁先出，不合适
    }
}