package com.xuegao.design_patterns.xingwei.chain.file2;


/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/23 23:59
 */
public class AmountHandler extends FileHandler {

    private String str;

    public AmountHandler(String str) {
        super(str);
        this.str = str;
    }

    @Override
    public boolean check() {
        System.out.println("AmountHandler");
        return checkNext();
    }
}