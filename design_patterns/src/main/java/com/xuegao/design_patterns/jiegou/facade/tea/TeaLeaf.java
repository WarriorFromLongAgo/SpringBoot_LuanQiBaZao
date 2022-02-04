package com.xuegao.design_patterns.jiegou.facade.tea;

/**
 * 泡茶需要茶叶 TeaLeaf
 *
 * @author xuegao
 * @version 1.0
 * @date 2022/2/4 23:42
 */
public class TeaLeaf {

    private String teaName;

    public TeaLeaf() {
    }

    public TeaLeaf(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}