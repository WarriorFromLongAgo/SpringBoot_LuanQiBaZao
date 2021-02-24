package com.xuegao.multi_thread2.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.domain
 * <br/> @ClassName：RestTemplateConfig
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/24 18:43
 */
@Configuration
public class RestTemplateConfig {

    @Bean("OKHttp3RestTemplate")
    public RestTemplate OKHttp3RestTemplate(){
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }
}