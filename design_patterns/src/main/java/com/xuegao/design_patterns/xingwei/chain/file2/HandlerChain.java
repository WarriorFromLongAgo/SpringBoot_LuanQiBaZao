package com.xuegao.design_patterns.xingwei.chain.file2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/24 0:17
 */
public class HandlerChain {
    private final List<FileHandler> handlerList;

    public HandlerChain(FileHandler handler) {
        this.handlerList = new ArrayList<>(1);
        Collections.addAll(this.handlerList, handler);
    }

    public HandlerChain(FileHandler... handlerArr) {
        this.handlerList = new ArrayList<>(handlerArr.length);
        Collections.addAll(this.handlerList, handlerArr);
    }

    public HandlerChain(List<FileHandler> handlerList) {
        this.handlerList = handlerList;
    }

    public void addHandler(FileHandler handler) {
        handlerList.add(handler);
    }

    public void addHandlerList(List<FileHandler> list) {
        handlerList.addAll(list);
    }

    public boolean handler() {
        boolean flag = false;
        for (FileHandler fileHandler : handlerList) {
            if (fileHandler.check()) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}