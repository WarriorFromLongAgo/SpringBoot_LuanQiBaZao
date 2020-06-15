package com.xuegao.xianliu_demo.controller;

import com.xuegao.xianliu_demo.annotation.RateLimit;
import com.xuegao.xianliu_demo.annotation.RedisLimit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.controller
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 12:33
 */
@RestController
public class LimitController {

    @RateLimit
    @RequestMapping("/rate_limit")
    public String rateLimit() {
        return "rateLimit";
    }

    @RedisLimit(limit = 4, sec = 10)
    @RequestMapping("/redis_limit")
    public String redisLimit() {
        return "redisLimit";
    }
}