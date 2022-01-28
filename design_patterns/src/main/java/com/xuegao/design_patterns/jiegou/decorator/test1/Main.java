package com.xuegao.design_patterns.jiegou.decorator.test1;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/1/27 22:30
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("张三");

        BigPants bigPants = new BigPants();
        TShirts tShirts = new TShirts();
        bigPants.dress(person);
        tShirts.dress(bigPants);

        tShirts.showClothes();
    }
}