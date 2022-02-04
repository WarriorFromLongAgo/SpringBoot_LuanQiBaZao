package com.xuegao.design_patterns.jiegou.facade.tea;

/**
 * 泡茶需要水
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/2/4 23:41
 */
public class Water {
    // 温度
    private int temperature;
    // 容量
    private int capacity;

    public Water() {
        this.temperature = 0;
        this.capacity = 10;
    }

    public Water(int temperature, int capacity) {
        this.temperature = temperature;
        this.capacity = capacity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}