package com.xuegao.design_patterns.chain;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.chain
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 17:58
 */
public class BranchManager extends Learder {
    private String name;
    private String something;

    public BranchManager(String name, String something) {
        this.name = name;
        this.something = something;
    }

    @Override
    void handler(int level) {
        boolean flag = true;
        //如果级别在自己的处理范围之内
        if (level > 0) {
            //这就就直接设置同意了
            if (flag) {
                System.out.println("部门经理同意了  " + name + "所述的<" + something + ">事情!");
            } else {
                System.out.println("部门经理不同意  " + name + "所述的<" + something + ">事情!");
            }
        } else {
            System.out.println("部门经理未能处理  " + name + "所述的<" + something + ">事情!转交给上级!");
            getLearder().handler(level);
        }
    }
}