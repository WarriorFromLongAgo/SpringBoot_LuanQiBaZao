package com.xuegao.design_patterns.command;

class Student {
    void cleanClassRoom(String name) {
        System.out.println(name + " 开始打扫教室...");
    }

    void doHomeWork(String name) {
        System.out.println(name + " 开始做作业...");
    }
}