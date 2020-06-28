package com.xuegao.design_patterns.chain;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.chain
 * <br/> @ClassName：ChainOfResponsibility
 * <br/> @Description：责任链设计模式
 * <br/> @author：feijm
 * <br/> @date：2020/6/26 18:38
 */
public class ChainOfResponsibility {
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

    }
}

abstract class Learder {

    protected Learder learder;

    protected void setLearder(Learder learder) {
        this.learder = learder;
    }

    protected Learder getLearder() {
        return learder;
    }

    abstract void handler(int level);
}

class Supervisor extends Learder {
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


class BranchManager extends Learder {
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


class GeneralManager extends Learder {
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

