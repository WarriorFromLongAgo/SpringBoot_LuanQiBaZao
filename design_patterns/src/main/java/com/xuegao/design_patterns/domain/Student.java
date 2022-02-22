package com.xuegao.design_patterns.domain;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/8 23:31
 */
public class Student {
    private String name;
    private Integer number;

    public Student(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public void count() {
        System.out.println(String.format("我是 %d 号 %s", this.number, this.name));
    }

}