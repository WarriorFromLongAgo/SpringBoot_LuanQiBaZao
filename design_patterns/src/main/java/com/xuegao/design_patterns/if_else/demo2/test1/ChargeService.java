package com.xuegao.design_patterns.if_else.demo2.test1;

public interface ChargeService {
    // 用于获取收费类型
    String getType();

    // 用于执行具体的收费方式
    void chargeBackAndReturnResult();
}