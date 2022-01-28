package com.xuegao.design_patterns.jiegou.decorator.battercake;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/28 13:24
 */
public class Main2 {
    public static void main(String[] args) {
        IBatterCake batterCake = new BatterCake();
        batterCake = new EggDecorator(batterCake);
        System.out.println(batterCake.getDesc() + ", 销售价格: " + batterCake.cost());
    }
}