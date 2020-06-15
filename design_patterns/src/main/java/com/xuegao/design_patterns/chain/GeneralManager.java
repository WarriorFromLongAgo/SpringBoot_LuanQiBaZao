package com.xuegao.design_patterns.chain;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.chain
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 17:58
 */
public class GeneralManager extends Learder {

    private String name;
    private String something;

    public GeneralManager(String name, String something) {
        this.name = name;
        this.something = something;
    }

    @Override
    void handler(int level) {
        boolean flag = false;
        //如果级别在自己的处理范围之内
        if (level > -1) {
            //这就就直接设置不同意了
            if (flag) {
                System.out.println("总经理同意了  " + name + "所述的<" + something + ">事情!");
            } else {
                System.out.println("总经理不同意  " + name + "所述的<" + something + ">事情!");
            }

        } else {
            System.out.println("总经理未能处理  " + name + "所述的<" + something + ">事情!转交给上级!");
            getLearder().handler(level);
        }
    }
}