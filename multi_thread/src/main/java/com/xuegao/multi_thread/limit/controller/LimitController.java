package com.xuegao.multi_thread.limit.controller;

import com.xuegao.multi_thread.limit.annotation.RateLimit;
import com.xuegao.multi_thread.limit.annotation.RedisLimit;
import com.xuegao.multi_thread.limit.service.GuavaRateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.controller
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 12:33
 */
@RestController
public class LimitController {

    @Autowired
    private GuavaRateLimiterService guavaRateLimiterService;

    @RateLimit
    @RequestMapping("/rate_limit")
    public String rateLimit() {
        guavaRateLimiterService.sout();
        return "rateLimit";
    }

    @RedisLimit(limit = 4, sec = 10)
    @RequestMapping("/redis_limit")
    public String redisLimit() {
        return "redisLimit";
    }

    @RequestMapping("/guavaRateLimiter")
    public String testRateLimiter() {
        if (guavaRateLimiterService.tryAcquire()) {
            return "成功获取许可";
        }
        return "未获取到许可";
    }

    @RequestMapping("/access")
    @ResponseBody
    public String access() {
        //尝试获取令牌
        if (guavaRateLimiterService.tryAcquire()) {
            //模拟业务执行500毫秒
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "aceess success [" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "]";
        } else {
            return "aceess limit [" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "]";
        }
    }
// ————————————————
//     版权声明：本文为CSDN博主「程序员欣宸」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/boling_cavalry/article/details/75174486
}