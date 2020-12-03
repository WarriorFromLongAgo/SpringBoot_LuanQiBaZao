package com.xuegao.multi_thread2;

public class LearnRecordService implements RemoteLoader {
    @Override
    public String load() {
        this.delay();
        return "学习信息";
    }
}