package com.xuegao.design_patterns.jiegou.facade.tea;

/**
 * 人喝茶水
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/2/4 23:46
 */
public class Man {
    private String name;
    public Man(String name) {
        this.name = name;
    }
    public void drink(Teawater teawater) {
        System.out.println(name + " 喝了" + teawater.getTeaWater());
    }
}