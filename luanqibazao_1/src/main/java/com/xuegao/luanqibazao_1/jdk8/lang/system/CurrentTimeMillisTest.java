
package com.xuegao.luanqibazao_1.jdk8.lang.system;

import java.util.concurrent.TimeUnit;

/**
 * <br/> @ClassName：CurrentTimeMillisTest
 * <br/> @Description：
 * <br/> @author：fjm
 * <br/> @date：2021/8/5 18:21
 */
public class CurrentTimeMillisTest {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(3);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}