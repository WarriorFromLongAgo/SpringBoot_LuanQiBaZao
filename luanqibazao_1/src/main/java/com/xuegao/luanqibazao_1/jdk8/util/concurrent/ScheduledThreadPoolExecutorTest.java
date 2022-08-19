package com.xuegao.luanqibazao_1.jdk8.util.concurrent;

import com.xuegao.luanqibazao_1.jdk8.time.LocalDateTimeUtil;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
    public static void main(String[] args) {
        System.out.println(LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);

        // 0表示首次执行任务的延迟时间，40表示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("scheduleAtFixedRate = " + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
            }
        }, 0, 10, TimeUnit.SECONDS);

        // 只执行一次，延迟任务，延迟delay时间，执行一次
        scheduled.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("schedule = " + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
            }
        }, 10, TimeUnit.SECONDS);
        System.out.println("" + LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now()));
    }
}
