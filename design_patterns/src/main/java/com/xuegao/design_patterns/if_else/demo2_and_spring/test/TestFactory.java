package com.xuegao.design_patterns.if_else.demo2_and_spring.test;

/**
 * <br/> @PackageName：com.fff.if_else.demo2.test1
 * <br/> @ClassName：TestFactory
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/4/5 17:33
 */
public class TestFactory {
    public static void main(String[] args) {
        ChargeService one = ChargeServiceFactory.getChargeService("one");



        String type = one.getType();
        System.out.println(type);
        one.chargeBackAndReturnResult();
    }
}