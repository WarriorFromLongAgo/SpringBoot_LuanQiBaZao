package com.xuegao.design_patterns.jiegou.decorator.battercake;

public abstract class AbstractDecorator implements IBatterCake {
    private IBatterCake iBatterCake;

    public AbstractDecorator(IBatterCake iBatterCake) {
        this.iBatterCake = iBatterCake;
    }

    protected abstract void doSomething();

    @Override
    public String getDesc() {
        return this.iBatterCake.getDesc();
    }

    @Override
    public int cost() {
        return this.iBatterCake.cost();
    }
}