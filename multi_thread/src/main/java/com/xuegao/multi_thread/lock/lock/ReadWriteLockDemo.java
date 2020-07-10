package com.xuegao.multi_thread.lock.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <br/> @PackageName：com.xuegao.multi_thread.lock.lock
 * <br/> @ClassName：ReadWriteLockDemo
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 12:49
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Mycache mycache = new Mycache();
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                mycache.put("hresh" + index);
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                mycache.get();
            }, String.valueOf(i)).start();
        }
    }
}

class Mycache {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String data) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备写入操作");
            map.put("name", data);
            System.out.println(Thread.currentThread().getName() + "写入成功" + data);
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public void get() {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "读取操作");
            System.out.println(map.get("name"));
            System.out.println(Thread.currentThread().getName() + "读取成功");
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}