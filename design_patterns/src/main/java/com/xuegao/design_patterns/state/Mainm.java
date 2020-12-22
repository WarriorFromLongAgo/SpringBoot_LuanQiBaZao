package com.xuegao.design_patterns.state;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.state
 * <br/> @ClassName：Mainm
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/22 10:06
 */
public class Mainm {
    public static void main(String[] args) {
        SafeFrame f = new SafeFrame("状态模式");
        while (true) {
            for (int hour = 1; hour <= 24; hour++) {
                f.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}