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
public class ForCountDownLatch2 {
    // 首先我们通过newScheduledThreadPool(gradeNum) 创建了六个线程池，每一个线程池代表一个班级，
    // CountDownLatch(gradeNum) 表示我们需要计数的数量，这里我需要等待六个班级才能执行，
    // TimeUnit.MILLISECONDS.sleep((int) Math.random() * 1000);随机时间，用于表示每一个班级整理的时间。
    // 主线程调用countDownLatch.await（）方法后会被阻塞。子线程执行完毕后调用countDownLatch.countDown（）
    // 方法让countDownLatch内部的计数器减1，所有子线程执行完毕并调用countDown（）方法后计数器会变为 0，
    // 这时候主线程的 await（）方法才会返回。

    // 等待所有年级集合准备.....
    // 2年级已经准备好了
    // 3年级已经准备好了
    // 4年级已经准备好了
    // 1年级已经准备好了
    // 5年级已经准备好了
    // 6年级已经准备好了
    // 所有年级准备好了，出发.........

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
        countDownLatch.await();
        System.out.println("所有年级准备好了，出发.........");
        exec.shutdown();
    }

    private static void wait(int gradeName) throws Exception {
        TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 1000));
        System.out.println(gradeName + "年级已经准备好了");
    }

    // 作者：山间木匠
    // 链接：https://juejin.im/post/6877345963887820813
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}