package com.xuegao.design_patterns.jiegou.decorator.test1;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/27 22:24
 */
public class TShirts extends Clothes {

    @Override
    public void showClothes() {
        System.out.print(" T恤 ");
        super.showClothes();
    }
}