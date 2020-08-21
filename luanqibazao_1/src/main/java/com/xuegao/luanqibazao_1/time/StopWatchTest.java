package com.xuegao.luanqibazao_1.time;

import org.springframework.util.StopWatch;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.time
 * <br/> @ClassName：StopWatchTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 9:42
 */
public class StopWatchTest {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("调用接口 1");
        stopWatch.stop();

        stopWatch.start("调用接口 2");
        stopWatch.stop();

        stopWatch.start("调用接口 3");
        stopWatch.stop();

        stopWatch.start("调用接口 4");
        stopWatch.stop();

        stopWatch.start("调用接口 5");
        stopWatch.stop();

        stopWatch.prettyPrint();

        // return;
    }
}