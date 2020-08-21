package com.xuegao.video_conver.filedeal;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.video_conver.filedeal
 * <br/> @ClassName：ListenFileChange
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/21 9:43
 */
public class ListenFileChange {
    // 问题抽象出来之后，对应的解决方案就比较清晰了
    //
    // 如何轮询 ？ --》 定时器 Timer, ScheduledExecutorService 都可以实现
    // 如何判断文件修改？ --》根据 java.io.File#lastModified 获取文件的上次修改时间，比对即可
    //
    // 作者：一灰灰
    // 链接：https://juejin.im/post/6844903561449439240
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    private static long lastTime;

    public static void file1() {

        File file = new File("/tmp/alarmConfig");

        // 首先文件的最近一次修改时间戳
        lastTime = file.lastModified();

        // 定时任务，每秒来判断一下文件是否发生变动，即判断lastModified是否改变
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (file.lastModified() > lastTime) {
                    System.out.println("file update! time : " + file.lastModified());
                    lastTime = file.lastModified();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void ttt() {
        throw new NullPointerException();
    }

    public static void file2() {

        File file = new File("/tmp/alarmConfig");

        lastTime = file.lastModified();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (file.lastModified() > lastTime) {
                    System.out.println("file update! time : " + file.lastModified());
                    lastTime = file.lastModified();
                    ttt();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);


        try {
            Thread.sleep(1000 * 60 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    // 直接查看ScheduledExecutorService的源码注释说明
    //
    // If any execution of the task encounters an exception, subsequent executions are suppressed.Otherwise,
    // the task will only terminate via cancellation or termination of the executor.
    // 即如果定时任务执行过程中遇到发生异常，则后面的任务将不再执行。
    // 所以，使用这种姿势的时候，得确保自己的任务不会抛出异常，否则后面就没法玩了
    // 对应的解决方法也比较简单，整个catch一下就好


}