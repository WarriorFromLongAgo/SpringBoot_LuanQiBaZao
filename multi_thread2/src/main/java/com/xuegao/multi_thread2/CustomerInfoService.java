package com.xuegao.multi_thread2;

public class CustomerInfoService implements RemoteLoader {
    @Override
    public String load() {
        this.delay();
        return "基本信息";
    }
}
