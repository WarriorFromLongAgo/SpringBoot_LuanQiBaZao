package com.xuegao.design_patterns.jiegou.decorator.battercake;

/**
 * 煎饼
 */
public class BatterCake implements IBatterCake {
    @Override
    public String getDesc() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 8;
    }
}