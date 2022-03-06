package com.xuegao.design_patterns.xingwei.status.two;

// 状态实现者继承了State接口，并实现了doAction方法，在方法内部可以对我们的状态所有者进行对应的操作。
// 这里是一个启动状态：
public class StopState implements State {

    private String name;

    public StopState() {
        this.name = "stop";
    }

    @Override
    public void doAction(Context context) {
        System.out.println("Context is in stop state");
        context.setState(this);
        System.out.println(context);
    }

    @Override
    public String toString() {
        return "StopState{" +
                "name='" + name + '\'' +
                '}';
    }
}
