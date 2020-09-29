package com.xuegao.multi_thread2.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.countdownlatch
 * <br/> @ClassName：ForCountDownLatch1
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/29 14:16
 */
public class ForCountDownLatch3 {
    // 主线程规定时间等待子线程完成
    // 与前面的代码相比，此段代码多了一个countDownLatch.await(1000, TimeUnit.MILLISECONDS);
    // ,countDownLatch的 await 可以等待超时时间，如果在规定时间内业务不管有没有完成，主线程都不会被阻塞。
    // 运行结果如下：

    // 等待所有年级集合准备.....
    // 4年级已经准备好了
    // 2年级已经准备好了
    // 3年级已经准备好了
    // 6年级已经准备好了
    // 5年级已经准备好了
    // 8 点了准备好的年级，先出发.........
    // 1年级已经准备好了

    private final static int gradeNum = 6;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newScheduledThreadPool(gradeNum);
        final CountDownLatch countDownLatch = new CountDownLatch(gradeNum);
        for (int i = 0; i < gradeNum; i++) {
            int gradeName = i + 1;
            exec.submit(() -> {
                try {
                    wait(gradeName);
                } catch (Exception e) {
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        System.out.println("等待所有年级集合准备.....");
        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
        System.out.println("8 点了准备好的年级，先出发.........");
        exec.shutdown();
    }

    private static void wait(int gradeName) throws Exception {
        // 模拟一年级等待时间更长
        if (gradeName == 1) {
            TimeUnit.SECONDS.sleep(2);
        } else {
            TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 1000));
        }
        System.out.println(gradeName + "年级已经准备好了");
    }

    // 作者：山间木匠
    // 链接：https://juejin.im/post/6877345963887820813
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}