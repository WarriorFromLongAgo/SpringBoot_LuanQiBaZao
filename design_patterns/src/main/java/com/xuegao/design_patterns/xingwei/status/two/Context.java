package com.xuegao.design_patterns.xingwei.status.two;

// 状态所属者
// 然后是我们的状态所属者，这个类有一个核心的属性就是我们的State接口。
public class Context {
    private State state;

    public Context(){}

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
     @Override
    public String toString() {
        return "Context{" +
                "state=" + state +
                '}';
    }
}