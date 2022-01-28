package com.xuegao.design_patterns.jiegou.decorator.test1;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/27 22:25
 */
public class BigPants extends Clothes {

    @Override
    public void showClothes() {
        System.out.print(" 大裤衩 ");
        super.showClothes();
    }
}