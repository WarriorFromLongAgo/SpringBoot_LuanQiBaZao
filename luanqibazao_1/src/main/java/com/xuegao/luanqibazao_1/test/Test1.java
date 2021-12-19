package com.xuegao.luanqibazao_1.test;

import com.alibaba.ttl.TtlRunnable;
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/19 13:59
 */
public class Test1 {
    static {
        Function<Runnable, Runnable> decorator = TtlRunnable::get;
        Schedulers.onScheduleHook("my-hook", decorator);
    }

    public static void main(String[] args) {


    }
}