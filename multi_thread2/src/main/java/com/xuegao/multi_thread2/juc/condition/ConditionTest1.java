package com.xuegao.multi_thread2.juc.condition;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.atomic.condition
 * <br/> @ClassName：ConditionTest1
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/11 18:57
 */
public class ConditionTest1 implements Runnable {

    static ReentrantLock lock = new ReentrantLock();
    static Condition conditio = lock.newCondition();


    @Override
    public void run() {
        lock.lock();

        try {
            System.out.println("准备进入等待状态");
            conditio.await();
            System.out.println("等待结束");
        } catch (InterruptedException e) {
            System.out.println(" InterruptedException·1 ");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ConditionTest1 conditionTest1 = new ConditionTest1();
        Thread aThread = new Thread(conditionTest1, "AThread");
        aThread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println(" InterruptedException 2");
            e.printStackTrace();
        }
        // 等待3秒重新获得锁
        lock.lock();
        // 通知 aThread 重新执行
        conditio.signal();
        lock.unlock();
    }

}