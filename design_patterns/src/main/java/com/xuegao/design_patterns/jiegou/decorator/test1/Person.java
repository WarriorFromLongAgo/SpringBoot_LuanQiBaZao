package com.xuegao.design_patterns.jiegou.decorator.test1;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/27 22:18
 */
public class Person {

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