package com.xuegao.design_patterns.if_else.demo2.test1;

import java.util.Objects;

/**
 * <br/> @PackageName：com.fff.if_else.demo2.test1
 * <br/> @ClassName：TestFactory
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/4/5 17:33
 */
public class TestFactory {
    public static void main(String[] args) {
        ChargeService one = ChargeServiceFactory.getChargeService("one");
        String type = Objects.requireNonNull(one).getType();
        System.out.println(type);

        one.chargeBackAndReturnResult();
    }
}