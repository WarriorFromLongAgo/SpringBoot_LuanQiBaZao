package com.xuegao.to_mysql.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.config
 * <br/> @ClassName：Knife4jConfig
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 14:40
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xuegao.to_mysql.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("项目接口文档")
                .description("服务相关接口")
                .contact(new Contact("lxl", null, "594782041@qq.com"))
                .version("1.0.0")
                .build();
    }
}