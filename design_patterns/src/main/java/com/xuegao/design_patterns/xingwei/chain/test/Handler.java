package com.xuegao.design_patterns.xingwei.chain.test;

import lombok.Data;

@Data
public abstract class Handler {
    protected String name; // 处理者姓名
    protected Handler nextHandler;  // 下一个处理者

    public Handler(String name) {
        this.name = name;
    }

    public abstract boolean process(LeaveRequest leaveRequest); // 处理请假
}
