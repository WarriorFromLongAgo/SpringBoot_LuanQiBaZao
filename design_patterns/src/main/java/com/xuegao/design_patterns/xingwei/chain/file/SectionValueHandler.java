package com.xuegao.design_patterns.xingwei.chain.file;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/23 23:59
 */
public class SectionValueHandler extends FileHandler {

    @Override
    public boolean check(String str, FileRequest fileRequest) {
        System.out.println("SectionValueHandler");
        return false;
    }
}