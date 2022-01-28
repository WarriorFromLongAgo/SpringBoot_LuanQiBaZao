package com.xuegao.design_patterns.jiegou.decorator.test1;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/27 22:19
 */
public class Clothes extends Person {

    private Person person;

    public void dress(Person person) {
        this.person = person;
    }

    @Override
    public void showClothes() {
        person.showClothes();
    }
}