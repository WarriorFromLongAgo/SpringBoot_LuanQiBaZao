package com.xuegao.design_patterns.jiegou.decorator.battercake;

/**
 * 香肠装饰器
 */
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(IBatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    public String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}