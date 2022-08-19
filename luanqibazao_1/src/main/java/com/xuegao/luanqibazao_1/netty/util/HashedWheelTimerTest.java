package com.xuegao.luanqibazao_1.netty.util;

import com.xuegao.luanqibazao_1.jdk8.time.LocalDateTimeUtil;
import io.netty.util.HashedWheelTimer;

import java.util.concurrent.TimeUnit;

public class HashedWheelTimerTest {
    public static void main(String[] args) {
        // 下文中我们new了一个包含512个bucket的时间轮，每个时间轮的轮片时间间隔是100毫秒。
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(
                100,
                TimeUnit.MILLISECONDS,
                512);
        System.out.println("下单了 = " + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        //下单的时候，向时间轮中添加一个30分钟的延时任务
        hashedWheelTimer.newTimeout(task -> {
            //注意这里使用异步任务线程池或者开启线程进行订单取消任务的处理
            cancelOrder();
        }, 10, TimeUnit.SECONDS);
        System.out.println("客户操作结束了");
    }

    public static void cancelOrder() {
        System.out.println("取消订单 = " + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
    }
}
