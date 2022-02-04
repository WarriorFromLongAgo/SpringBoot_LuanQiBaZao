package com.xuegao.design_patterns.jiegou.facade.tea;

// 张三和李四点茶，只需要告诉茶馆套餐编号即可，水、茶叶由茶馆准备，烧水泡茶的操作由茶馆统一完成
public class Test {
    public static void main(String[] args) {
        TeaHouseFacade teaHouseFacade = new TeaHouseFacade("老舍茶馆");

        Man zhangsan = new Man("张三");
        Teawater teawater = teaHouseFacade.makeTea(1);
        zhangsan.drink(teawater);
        System.out.println();

        Man lisi = new Man("李四");
        Teawater teawater1 = teaHouseFacade.makeTea(2);
        lisi.drink(teawater1);
    }
}