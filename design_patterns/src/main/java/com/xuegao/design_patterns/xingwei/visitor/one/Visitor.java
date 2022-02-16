package com.xuegao.design_patterns.xingwei.visitor.one;

// 通用访问者接口
public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}