package com.xuegao.design_patterns.if_else.demo2_and_spring.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <br/> @PackageName：com.fff.if_else.demo2.test1
 * <br/> @ClassName：ChargeServiceFactory
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/4/5 17:29
 */
@Component
public class ChargeServiceFactory implements ApplicationContextAware {

    // 定义一个map容器
    public static Map<String, ChargeService> chargeServiceMap = new HashMap<>();

    // static {
    //     chargeServiceMap.put("one", new OneDEpositPersonalChargeServiceImpl());
    //     chargeServiceMap.put("two", new TwoDEpositCommonTeamChargeServiceImpl());
    //     chargeServiceMap.put("three", new ThreeCreditPersonalChargeServiceImpl());
    //     chargeServiceMap.put("four", new FourCreditCommonTeamChargeServiceImpl());
    // }

    public static ChargeService getChargeService(String chargeType) {
        ChargeService chargeService = chargeServiceMap.get(chargeType);
        if (!ObjectUtils.isEmpty(chargeService)) {
            return chargeService;
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 通过application加载
        Map<String, ChargeService> map = applicationContext.getBeansOfType(ChargeService.class);
        // 对map进行赋值，可以使用依赖注入
        map.forEach((key, value) -> chargeServiceMap.put(value.getType(), value));
    }
}