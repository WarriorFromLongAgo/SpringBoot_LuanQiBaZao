package com.xuegao.luanqibazao_1.time;

import com.google.common.base.Stopwatch;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.time
 * <br/> @ClassName：StopWatchTest3
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 9:52
 */
public class StopWatchTest3 {
    public static void main(String[] args) {
        Stopwatch stopWatch = Stopwatch.createUnstarted();

        stopWatch.start();
        stopWatch.stop();

        stopWatch.start();
        stopWatch.stop();

        stopWatch.start();
        stopWatch.stop();

        stopWatch.start();
        stopWatch.stop();

        stopWatch.start();
        stopWatch.stop();

        System.out.println(stopWatch.toString());
    }
}