package com.xuegao.design_patterns.xingwei.chain.file2;


/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/23 23:59
 */
public class SectionValueHandler extends FileHandler {

    private String str;

    public SectionValueHandler(String str) {
        super(str);
        this.str = str;
    }

    @Override
    public boolean check() {
        System.out.println("检查是否是section值");
        return checkNext();
    }
}