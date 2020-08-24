package com.xuegao.multi_thread2.java代码模拟并发;

import java.util.concurrent.CountDownLatch;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.java代码模拟并发
 * <br/> @ClassName：CountDownLatchTest_1
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/24 17:24
 */
public class CountDownLatchTest_1 {
    public static void main(String[] args) {
        //模拟10000人并发请求，用户钱包
        CountDownLatch latch = new CountDownLatch(1);
        //模拟10000个用户
        // for(int i=0;i<10000;i++){
        // AnalogUser analogUser = new AnalogUser("user"+i,"58899dcd-46b0-4b16-82df-bdfd0d953bfb"+i,"1","20.024",latch);
        // analogUser.start();
        // }
        // 计数器減一  所有线程释放 并发访问。
        // latch.countDown();
        // System.out.println("所有模拟请求结束  at "+sdf.format(new Date()));
    }
}