package com.xuegao.design_patterns.xingwei.status.two;

public interface State {
    /**
     * 改变状态的操作
     * @param context
     */
    void doAction(Context context);
}