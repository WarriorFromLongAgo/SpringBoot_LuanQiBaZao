package com.xuegao.multi_thread2.limit2;

/**
 * <br/> @PackageName：com.xuegao.multi_thread.limit2
 * <br/> @ClassName：Throttler
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/12 13:22
 */
public interface Throttler {
    /**
     * 尝试申请一个配额
     *
     * @param key     申请配额的key
     * @return 申请成功则返回true，否则返回false
     */
    boolean tryAcquire(String key);
}