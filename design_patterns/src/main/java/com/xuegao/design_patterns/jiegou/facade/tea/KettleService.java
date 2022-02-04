package com.xuegao.design_patterns.jiegou.facade.tea;

/**
 * 烧水需要用水壶烧，将水加热后放入水壶中
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/2/4 23:42
 */
public class KettleService {
    public void waterBurning(String who, Water water, int burnTime) {
        // 烧水，计算最终温度
        int finalTermperature = Math.min(100, water.getTemperature() + burnTime * 20);
        water.setTemperature(finalTermperature);
        System.out.println(who + " 使用水壶烧水，最终水温为 " + finalTermperature);
    }
}