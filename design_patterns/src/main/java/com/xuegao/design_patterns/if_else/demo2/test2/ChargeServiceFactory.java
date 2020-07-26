package com.xuegao.design_patterns.if_else.demo2.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <br/> @PackageName：com.fff.if_else.demo2.test1
 * <br/> @ClassName：ChargeServiceFactory
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/4/5 17:29
 */
public class ChargeServiceFactory {

    // 定义一个map容器
    private Map<String, ChargeService> chargeServiceMap;

    public ChargeServiceFactory() {
        List<ChargeService> chargeServiceList = new ArrayList<>();
        chargeServiceList.add(new OneDEpositPersonalChargeServiceImpl());
        chargeServiceList.add(new TwoDEpositCommonTeamChargeServiceImpl());
        chargeServiceList.add(new ThreeCreditPersonalChargeServiceImpl());
        chargeServiceList.add(new FourCreditCommonTeamChargeServiceImpl());
        chargeServiceMap = chargeServiceList
                .stream()
                .collect(Collectors.toMap(ChargeService::getType, chargeService -> chargeService));
         /* 等同上面
             map = new HashMap<>();
             for (Strategy strategy : strategies) {
                map.put(strategy.getType(), strategy);
             }
         */
    }

    public static class Holder {
        public static ChargeServiceFactory instance = new ChargeServiceFactory();
    }

    public static ChargeServiceFactory getInstance() {
        return Holder.instance;
    }

    public ChargeService get() {
        return chargeServiceMap.get("one");
    }

}