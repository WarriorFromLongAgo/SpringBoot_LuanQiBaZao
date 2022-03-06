package com.xuegao.design_patterns.xingwei.status.two;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/3/6 17:19
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        StopState stopState = new StopState();
        stopState.doAction(context);
    }
}