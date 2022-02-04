package com.xuegao.design_patterns.jiegou.facade.tea;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/4 23:44
 */
public class Teawater {

    public Teawater(String name) {
        System.out.println(name);
    }

    public Teawater getTeaWater() {
        return this;
    }
}