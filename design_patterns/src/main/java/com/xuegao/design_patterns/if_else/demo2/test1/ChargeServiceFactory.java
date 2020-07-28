package com.xuegao.design_patterns.if_else.demo2.test1;

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
public class ChargeServiceFactory {

    // 定义一个map容器
    public static Map<String, ChargeService> chargeServiceMap = new HashMap<>();

    static {
        chargeServiceMap.put("one", new OneDEpositPersonalChargeServiceImpl());
        chargeServiceMap.put("two", new TwoDEpositCommonTeamChargeServiceImpl());
        chargeServiceMap.put("three", new ThreeCreditPersonalChargeServiceImpl());
        chargeServiceMap.put("four", new FourCreditCommonTeamChargeServiceImpl());
    }

    public static ChargeService getChargeService(String chargeType) {
        ChargeService chargeService = chargeServiceMap.get(chargeType);
        if (!ObjectUtils.isEmpty(chargeService)) {
            return chargeService;
        }
        return null;
    }
}