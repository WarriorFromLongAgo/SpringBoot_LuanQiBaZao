package com.xuegao.luanqibazao_1.utils;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/19 15:01
 */
public class ThreadUtils {

    /**
     * 使当前正在执行的线程休眠（暂时停止执行）指定的毫秒数，取决于系统计时器和调度程序的精度和准确性。 该线程不会失去任何监视器的所有权。
     *
     * @param millis:
     * @author fjm
     * @date 2021/12/19 15:01
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}