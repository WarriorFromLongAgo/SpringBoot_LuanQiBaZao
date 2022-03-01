package com.xuegao.design_patterns.xingwei.chain.file2;

import com.xuegao.design_patterns.xingwei.chain.file.FileRequest;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/28 23:23
 */
public class Main {
    public static void main(String[] args) {
        FileRequest fileRequest = new FileRequest();
        fileRequest.setArea("area");
        fileRequest.setSectionKey("sectionKey");
        fileRequest.setAmount("amount");

        FileHandler amountHandler = new AmountHandler(fileRequest.getAmount());
        FileHandler areaHandler = new AreaHandler(fileRequest.getArea());
        FileHandler sectionValueHandler = new SectionValueHandler(fileRequest.getSectionKey());

        amountHandler.linkWith(areaHandler).linkWith(sectionValueHandler);

        amountHandler.check();
    }
}