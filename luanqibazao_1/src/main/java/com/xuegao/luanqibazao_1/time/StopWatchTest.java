package com.xuegao.luanqibazao_1.time;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.time
 * <br/> @ClassName：StopWatchTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 9:42
 */
public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("调用接口 1");
        stopWatch.stop();

        stopWatch.start("调用接口 2");
        stopWatch.stop();

        stopWatch.start("调用接口 3");
        stopWatch.stop();

        stopWatch.start("调用接口 4");
        TimeUnit.SECONDS.sleep(1);
        stopWatch.stop();

        stopWatch.start("调用接口 5");
        stopWatch.stop();

        stopWatch.prettyPrint();
        // StopWatch '': running time = 2800 ns; [调用接口 1] took 1700 ns = 61%; [调用接口 2] took 200 ns = 7%; [调用接口 3] took 100 ns = 4%; [调用接口 4] took 100 ns = 4%; [调用接口 5] took 700 ns = 25%
        System.out.println("-==============================");
        System.out.println(stopWatch);
        // return;
    }
}