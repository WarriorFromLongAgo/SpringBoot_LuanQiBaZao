package com.xuegao.multi_thread2.limit.aspect;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.aspect
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 13:53
 */
public class GoogleLimit {
    private static Logger log = LoggerFactory.getLogger(GoogleLimit.class);

    // private static LoadingCache<Long, LongAdder> counter = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS)
    //         .build(new CacheLoader<Long, LongAdder>() {
    //             @Override
    //             public LongAdder load(Long aLong) {
    //                 return new LongAdder();
    //             }
    //         });
    //根据IP分不同的令牌桶, 每天自动清理缓存
    private static LoadingCache<Long, RateLimiter> counter = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(new CacheLoader<Long, RateLimiter>() {
                @Override
                public RateLimiter load(Long key) {
                    // 新的IP初始化 每秒只发出5个令牌
                    return RateLimiter.create(5);
                }
            });

    private static long permit = 1;

    private static final RateLimiter rateLimiter = RateLimiter.create(10);

    public static ResponseEntity getData() throws ExecutionException {
        // long currentTime = System.currentTimeMillis() / 1000;
        // LongAdder longAdder = counter.get(currentTime);
        // longAdder.increment();
        // if (longAdder.sum() > permit) {
        //     return ResponseEntity.of(Optional.of("访问速度过快"));
        // }
        // // 业务处理
        return ResponseEntity.ok().build();
    }

    public static void getData2() throws InterruptedException {
        // long currentTime = System.currentTimeMillis() / 1000;
        // RateLimiter rateLimiter = counter.get(currentTime);

        // double acquire = rateLimiter.acquire();
        // System.out.println("等待时间：" + acquire);

        // 秒出10个令牌，0.1秒出一个，100个请求进来，假如100个是同时到达，那么最终只能成交10个，
        // 90个都会因为超时而失败。
        // 事实上，并不会完全同时到达，必然会出现在0.1秒后到达的，就会被归入下一个周期。
        // 这是一个挺复杂的数学问题，每一个请求都会被计算未来可能获取到令牌的概率。

        //判断能否在1秒内得到令牌，如果不能则立即返回false，不会阻塞程序
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            // System.out.println("短期无法获取令牌，真不幸，排队也瞎排");
            log.info(Thread.currentThread().getName() + " 访问速度过快 ");
        } else {
            // 业务处理
            log.info(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        getData2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}