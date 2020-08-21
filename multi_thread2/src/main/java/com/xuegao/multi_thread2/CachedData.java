package com.xuegao.multi_thread2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2
 * <br/> @ClassName：CachedData
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/21 18:20
 */

// 代码中声明了一个 volatile 类型的 cacheValid 变量，保证其可见性。
// 首先获取读锁，如果cache不可用，则释放读锁
// 然后获取写锁
// 在更改数据之前，再检查一次cacheValid的值，然后修改数据，将cacheValid置为true
// 然后在释放写锁前获取读锁 此时
// cache中数据可用，处理cache中数据，最后释放读锁
// 这个过程就是一个完整的锁降级的过程，目的是保证数据可见性，听起来很有道理的样子，那么问题来了：

public class CachedData {
    Object data;
    volatile boolean cacheValid;
    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();
        if (!cacheValid) {
            // 必须在获取写锁之前释放读锁，因为锁的升级是不被允许的
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                // 再次检查，原因可能是其他线程已经更新过缓存
                if (!cacheValid) {
                    // data = ...
                    cacheValid = true;
                }
                //在释放写锁前，降级为读锁
                rwl.readLock().lock();
            } finally {
                //释放写锁，此时持有读锁
                rwl.writeLock().unlock();
            }
        }

        try {
            // use(data);
        } finally {
            rwl.readLock().unlock();
        }
    }
}