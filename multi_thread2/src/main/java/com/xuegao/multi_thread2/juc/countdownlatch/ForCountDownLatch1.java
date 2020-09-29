package com.xuegao.multi_thread2.juc.countdownlatch;

import java.util.concurrent.*;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.juc.countdownlatch
 * <br/> @ClassName：ForCountDownLatch1
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/29 14:16
 */
public class ForCountDownLatch1 {
    // 此段代码六个线程（班级）全部阻塞，主线程等待 3  秒执行 countDownLatch.countDown()
    // 计数器减 1 ，此时的countDownLatch 为 0，  所有countDownLatch.await() 收到为 0 的信号不再阻塞，继续执行接下来的任务。
    // 运行结果如下：
    // 通知、通知，请全体同学速来操场集合.....
    // 1年级所有同学到达操场
    // 3年级所有同学到达操场
    // 4年级所有同学到达操场
    // 6年级所有同学到达操场
    // 2年级所有同学到达操场
    // 5年级所有同学到达操场

    private final static int gradeNum = 6;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newScheduledThreadPool(gradeNum);
        // 铃声信号
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < gradeNum; i++) {
            int gradeName = i + 1;
            exec.submit(() -> {
                try {
                    countDownLatch.await();
                    wait(gradeName);

                } catch (Exception e) {
                }
            });
        }
        // 3 秒之后开启 通知
        TimeUnit.SECONDS.sleep(3);
        System.out.println("通知、通知，请全体同学速来操场集合.....");
        countDownLatch.countDown();

        exec.shutdown();
    }

    private static void wait(int gradeName) throws Exception {
        TimeUnit.MILLISECONDS.sleep((int) (Math.random()));
        System.out.println(gradeName + "年级所有同学到达操场");
    }

    // 作者：山间木匠
    // 链接：https://juejin.im/post/6877345963887820813
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}