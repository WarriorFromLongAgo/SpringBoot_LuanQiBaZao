package com.xuegao.luanqibazao_1.spring.core;

import org.springframework.core.ParameterizedTypeReference;

import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.spring.core
 * <br/> @ClassName：ParameterizedTypeReferenceTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/10/09 16:38
 */
public class ParameterizedTypeReferenceTest {
    public static void main(String[] args) {
        // RestTemplate中使用ParameterizedTypeReference参数化类型支持泛型，主要是List
        ParameterizedTypeReference<Map<String, String>> mapParameterizedTypeReference = new ParameterizedTypeReference<Map<String, String>>(){};

    }
}