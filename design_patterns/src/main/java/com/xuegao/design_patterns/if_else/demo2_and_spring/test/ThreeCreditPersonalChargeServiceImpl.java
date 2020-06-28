package com.xuegao.design_patterns.if_else.demo2_and_spring.test;

/**
 * <br/> @PackageName：com.fff.if_else.demo2.test1
 * <br/> @ClassName：ThreeCreditPersonalChargeServiceImpl
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/4/5 17:27
 */
public class ThreeCreditPersonalChargeServiceImpl implements ChargeService {

    @Override
    public String getType() {
        return "ThreeCreditPersonalChargeServiceImpl=====getType";
    }

    @Override
    public void chargeBackAndReturnResult() {
        System.out.println("ThreeCreditPersonalChargeServiceImpl====chargeBackAndReturnResult");
    }
}