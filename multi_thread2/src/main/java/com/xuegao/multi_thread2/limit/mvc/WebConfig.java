package com.xuegao.multi_thread2.limit.mvc;

import com.xuegao.multi_thread2.limit.interceptor.RedisLimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RedisLimitInterceptor redisLimitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(redisLimitInterceptor);
    }

    // /**
    //  * 注册过滤器
    //  * @return
    //  */
    // @Bean
    // public FilterRegistrationBean filterRegistrationBean(){
    //     FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
    //     filterRegistration.setFilter(new MyFilter());
    //     filterRegistration.addUrlPatterns("/*");
    //     return filterRegistration;
    // }

    // /**
    //  * 注册监听器
    //  * @return
    //  */
    // @Bean
    // public ServletListenerRegistrationBean registrationBean(){
    //     ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
    //     registrationBean.setListener(new MyHttpRequestListener());
    //     registrationBean.setListener(new MyHttpSessionListener());
    //     return registrationBean;
    // }
}