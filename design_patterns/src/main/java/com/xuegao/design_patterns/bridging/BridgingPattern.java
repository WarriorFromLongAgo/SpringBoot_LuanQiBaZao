package com.xuegao.design_patterns.bridging;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.bridging
 * <br/> @ClassName：BridgingPattern
 * <br/> @Description：桥接设计模式
 * <br/> @author：feijm
 * <br/> @date：2020/6/26 18:51
 */
public class BridgingPattern {
    public static void main(String[] args) {
        Paper paper = new ExaminationPaper();
        paper.setPen(new RedPen());
        paper.writing();

        Paper paper2 = new NewsPaper();
        paper2.setPen(new BlackPen());
        paper2.writing();
    }
}

interface Pen {
    void write();
}

class RedPen implements Pen {
    @Override
    public void write() {
        System.out.println("红色的字");
    }
}

class BlackPen implements Pen {
    @Override
    public void write() {
        System.out.println("黑色的字");
    }
}


abstract class Paper {
    protected Pen pen;

    void setPen(Pen pen) {
        this.pen = pen;
    }

    abstract void writing();
}

class ExaminationPaper extends Paper {
    @Override
    void writing() {
        pen.write();
    }
}

class NewsPaper extends Paper {
    @Override
    void writing() {
        pen.write();
    }
}