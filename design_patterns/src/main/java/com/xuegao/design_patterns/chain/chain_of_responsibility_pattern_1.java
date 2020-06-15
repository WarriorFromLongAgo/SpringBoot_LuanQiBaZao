package com.xuegao.design_patterns.chain;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.chain
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 17:49
 */
public class chain_of_responsibility_pattern_1 {
    public static void main(String[] args) {
        String name = "xuwujing";
        String something = "去聚餐";
        String something2 = "去旅游";
        Learder learder1 = new Supervisor(name, something);
        Learder learder2 = new BranchManager(name, something);
        Learder learder3 = new GeneralManager(name, something);
        learder1.setLearder(learder2);
        learder2.setLearder(learder3);
        learder1.handler(1);

        Learder learder4 = new Supervisor(name, something2);
        Learder learder5 = new BranchManager(name, something2);
        Learder learder6 = new GeneralManager(name, something2);
        learder4.setLearder(learder5);
        learder5.setLearder(learder6);
        learder4.handler(0);

        // 主管未能处理       xuwujing所述的<去聚餐>事情!转交给上级!
        // 部门经理同意了     xuwujing所述的<去聚餐>事情!
        // 主管未能处理       xuwujing所述的<去旅游>事情!转交给上级!
        // 部门经理未能处理    xuwujing所述的<去旅游>事情!转交给上级!
        // 总经理不同意       xuwujing所述的<去旅游>事情!
    }
}