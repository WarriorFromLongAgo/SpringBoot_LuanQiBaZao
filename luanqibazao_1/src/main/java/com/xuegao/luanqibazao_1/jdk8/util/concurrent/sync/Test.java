package com.xuegao.luanqibazao_1.jdk8.util.concurrent.sync;

public class Test {

    public static void main(String[] args) {
        //Main main = new Main();
        new Thread(()->{
            Main main = new Main();
            main.get();
        }).start();
        new Thread(()->{
            Main main = new Main();
            main.get();
        }).start();
    }

}

class Main{
    private static int i = 0;

    public synchronized void get(){
        i++;
        System.out.println(i);
    }
}