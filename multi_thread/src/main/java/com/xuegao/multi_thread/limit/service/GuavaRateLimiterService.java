package com.xuegao.multi_thread.limit.service;

import com.google.common.util.concurrent.RateLimiter;
import com.xuegao.multi_thread.limit.annotation.RateLimit;
import org.springframework.stereotype.Service;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.service
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 14:39
 */
@Service
public class GuavaRateLimiterService {
    /*每秒控制5个许可*/
    private RateLimiter rateLimiter = RateLimiter.create(5.0);

    /**
     * 获取令牌
     */
    public boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }
// ————————————————
//     版权声明：本文为CSDN博主「饭一碗」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/fanrenxiang/article/details/80949079

    public void sout() {
        System.out.println("dsfsdfjdfhjskfhsdfjskfj");
    }
}