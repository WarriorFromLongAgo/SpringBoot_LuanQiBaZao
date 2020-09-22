package com.xuegao.multi_thread2.limit.interceptor;

import com.xuegao.multi_thread2.limit.annotation.RedisLimit;
import com.xuegao.multi_thread2.limit.utils.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.interceptor
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 14:10
 */
@Component
public class RedisLimitInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (!method.isAnnotationPresent(RedisLimit.class)) {
                return true;
            }
            RedisLimit redisLimit = method.getAnnotation(RedisLimit.class);
            if (ObjectUtils.isEmpty(redisLimit)) {
                return true;
            }
            int limitInt = redisLimit.limit();
            int milliSecondsInt = redisLimit.milliSeconds();

            String key = IpUtils.getIpAddr(request) + request.getRequestURI();
            Integer maxLimit = (Integer) redisTemplate.opsForValue().get(key);
            if (ObjectUtils.isEmpty(maxLimit)) {
                redisTemplate.opsForValue().set(key, 1, milliSecondsInt, TimeUnit.MILLISECONDS);
            } else if (maxLimit < limitInt) {
                redisTemplate.opsForValue().set(key, maxLimit + 1, milliSecondsInt, TimeUnit.MILLISECONDS);
            } else {
                output(response, "请求太过于频繁");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

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