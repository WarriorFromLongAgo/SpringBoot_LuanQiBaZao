package com.xuegao.luanqibazao_1.time;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.time
 * <br/> @ClassName：StopWatchTest2
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 9:47
 */
public class StopWatchTest2 {
    public static void main(String[] args) throws InterruptedException {
        //创建后立即start，常用
        org.apache.commons.lang3.time.StopWatch watch = StopWatch.createStarted();

        // StopWatch watch = new StopWatch();
        // watch.start();

        Thread.sleep(1000);
        System.out.println(watch.getTime());
        System.out.println("统计从开始到现在运行时间：" + watch.getTime() + "ms");

        Thread.sleep(1000);
        watch.split();
        System.out.println("从start到此刻为止的时间：" + watch.getTime());
        System.out.println("从开始到第一个切入点运行时间：" + watch.getSplitTime());


        Thread.sleep(1000);
        watch.split();
        System.out.println("从开始到第二个切入点运行时间：" + watch.getSplitTime());

        // 复位后, 重新计时
        watch.reset();
        watch.start();
        Thread.sleep(1000);
        System.out.println("重新开始后到当前运行时间是：" + watch.getTime());

        // 暂停 与 恢复
        watch.suspend();
        System.out.println("暂停2秒钟");
        Thread.sleep(2000);

        // 上面suspend，这里要想重新统计，需要恢复一下
        watch.resume();
        System.out.println("恢复后执行的时间是：" + watch.getTime());

        Thread.sleep(1000);
        watch.stop();

        System.out.println("花费的时间》》" + watch.getTime() + "ms");
        // 直接转成s
        System.out.println("花费的时间》》" + watch.getTime(TimeUnit.SECONDS) + "s");
    }
}