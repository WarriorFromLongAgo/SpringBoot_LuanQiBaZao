package com.xuegao.design_patterns.jiegou.decorator.battercake;

/**
 * 鸡蛋装饰器
 */
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(IBatterCake battercake) {
        super(battercake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }

    public void egg() {
        System.out.println("增加了一个鸡蛋");
    }
}