package com.xuegao.design_patterns.xingwei.chain.file;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/24 0:10
 */
public class Main {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new AreaHandler());
        handlerChain.addHandler(new SectionValueHandler());
        handlerChain.addHandler(new AmountHandler());

        FileRequest fileRequest = new FileRequest();
        fileRequest.setArea("area");
        fileRequest.setSectionKey("sectionKey");
        fileRequest.setAmount("amount");

        boolean handler = handlerChain.handler(fileRequest);
        System.out.println("Main = " + handler);

    }
}