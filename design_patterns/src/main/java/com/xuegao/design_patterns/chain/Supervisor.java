package com.xuegao.design_patterns.chain;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.chain
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 17:57
 */
public class Supervisor extends Learder {

    private String name;
    private String something;

    public Supervisor(String name, String something) {
        this.name = name;
        this.something = something;
    }

    @Override
    void handler(int level) {
        //如果级别在自己的处理范围之内
        if (level > 1) {
            System.out.println("主管同意了  " + name + "所述的<" + something + ">事情!");
        } else {
            System.out.println("主管未能处理  " + name + "所述的<" + something + ">事情!转交给上级!");
            getLearder().handler(level);
        }
    }
}