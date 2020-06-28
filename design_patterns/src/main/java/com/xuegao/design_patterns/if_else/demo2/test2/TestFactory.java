package com.xuegao.design_patterns.if_else.demo2.test2;

/**
 * <br/> @PackageName：com.fff.if_else.demo2.test1
 * <br/> @ClassName：TestFactory
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/4/5 17:33
 */
public class TestFactory {
    public static void main(String[] args) {
        ChargeService chargeService = ChargeServiceFactory.getInstance().get();
        chargeService.chargeBackAndReturnResult();
    }

    // private static double getResult(long money, int type) {
    //     if (money < 1000) {
    //         return money;
    //     }
    //     ResourceProperties.Strategy strategy = StrategyFactory.getInstance().get(type);
    //     if (strategy == null){
    //         throw new IllegalArgumentException("please input right type");
    //     }
    //     return strategy.compute(money);
    // }
}