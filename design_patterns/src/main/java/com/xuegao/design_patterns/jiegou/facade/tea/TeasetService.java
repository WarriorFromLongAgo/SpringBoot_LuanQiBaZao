package com.xuegao.design_patterns.jiegou.facade.tea;

/**
 * 泡茶，将烧好的水与茶叶进行冲泡，最终得到一杯茶水
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/2/4 23:42
 */
public class TeasetService {
    public Teawater makeTeaWater(String who, Water water, TeaLeaf teaLeaf) {
        String teawater = "一杯容量为 " + water.getCapacity() + ", 温度为 " + water.getTemperature() + " 的" + teaLeaf.getTeaName() + "茶水";
        System.out.println(who + " 泡了" + teawater);
        return new Teawater(teawater);
    }
}