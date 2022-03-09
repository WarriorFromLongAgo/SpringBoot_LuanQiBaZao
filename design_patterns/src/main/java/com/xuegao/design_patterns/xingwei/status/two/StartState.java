package com.xuegao.design_patterns.xingwei.status.two;

public class StartState implements State{

    private String name;

    public StartState() {
        this.name = "start";
    }

    @Override
    public void doAction(Context context) {
        System.out.println("Context is in start state");
        context.setState(this);
        System.out.println(context);
    }

    @Override
    public String toString() {
        return "StartState{" +
                "name='" + name + '\'' +
                '}';
    }
}