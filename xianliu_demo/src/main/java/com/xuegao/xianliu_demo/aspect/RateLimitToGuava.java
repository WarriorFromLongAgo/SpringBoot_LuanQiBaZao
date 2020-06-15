package com.xuegao.xianliu_demo.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.aspect
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 12:34
 */
@Aspect
@Component
@Scope
public class RateLimitToGuava {

    @Autowired
    private HttpServletResponse response;
    /**
     * 限流熔断
     * 并发数设置为 5
     * 大于 5 个，就会显示网络繁忙
     */
    private RateLimiter rateLimiter = RateLimiter.create(5.0);

    // execution(* *(..))   表示匹配所有方法
    // execution(public * com. savage.service.UserService.*(..))   表示匹配com.savage.server.UserService中所有的公有方法
    // execution(* com.savage.server..*.*(..))     表示匹配com.savage.server包及其子包下的所有方法
    @Pointcut(value = "@annotation(com.xuegao.xianliu_demo.annotation.RateLimit) && execution(public * com.xuegao.xianliu_demo..*(..)))")
    public void serviceLimit() {

    }

    @Around("serviceLimit()")
    public Object around(ProceedingJoinPoint joinPoint) {
        boolean flag = rateLimiter.tryAcquire();
        Object obj = null;
        try {
            if (flag) {
                obj = joinPoint.proceed();
            } else {
                String aaaaa = JSON.toJSONString("aaaaa");
                output(response, aaaaa);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("flag = " + flag + " = obj = " + obj);
        return obj;
    }

    private void output(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
        }


    }
}