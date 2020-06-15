package com.xuegao.design_patterns.chain;

abstract class Learder {
    protected Learder learder;

    protected void setLearder(Learder learder) {
        this.learder = learder;
    }

    protected Learder getLearder() {
        return learder;
    }

    abstract void handler(int level);
}