package com.xuegao.design_patterns.xingwei.chain.file2;

import com.xuegao.design_patterns.xingwei.chain.file.FileHandler;
import com.xuegao.design_patterns.xingwei.chain.file.FileRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/24 0:17
 */
public class HandlerChain {
    List<com.xuegao.design_patterns.xingwei.chain.file.FileHandler> handlerList = new ArrayList<>();

    public void addHandler(com.xuegao.design_patterns.xingwei.chain.file.FileHandler handler) {
        handlerList.add(handler);
    }

    public void addHandlerList(List<com.xuegao.design_patterns.xingwei.chain.file.FileHandler> list) {
        handlerList.addAll(list);
    }

    public boolean handler(FileRequest fileRequest) {
        boolean flag = false;
        for (FileHandler fileHandler : handlerList) {
            if (fileHandler.check(fileRequest.getArea(), fileRequest)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}