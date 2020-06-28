package com.xuegao.design_patterns.if_else.demo2.test1;

/**
 * <br/> @PackageName：com.fff.if_else.demo2.test1
 * <br/> @ClassName：OneDEpositPersonalChargeServiceImpl
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/4/5 17:24
 */
public class FourCreditCommonTeamChargeServiceImpl implements ChargeService {
    @Override
    public String getType() {
        return "FourCreditCommonTeamChargeServiceImpl=====getType";
    }

    @Override
    public void chargeBackAndReturnResult() {
        System.out.println("FourCreditCommonTeamChargeServiceImpl====chargeBackAndReturnResult");
    }
}