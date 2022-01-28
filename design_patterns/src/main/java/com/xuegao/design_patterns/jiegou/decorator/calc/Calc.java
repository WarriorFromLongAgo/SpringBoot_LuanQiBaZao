package com.xuegao.design_patterns.jiegou.decorator.calc;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/27 22:42
 */
public class Calc {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showClothes() {
        System.out.println("装扮的" + name);
    }

}