package com.xuegao.design_patterns.strategy;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.strategy
 * <br/> @ClassName：StrategyPattern
 * <br/> @Description：策略设计模式
 * <br/> @author：feijm
 * <br/> @date：2020/6/26 17:41
 */
public class StrategyPattern {
    public static void main(String[] args) {
        int a = 4, b = 2;
        CalculatorContext context = new CalculatorContext(new OperationAdd());
        System.out.println("a + b = " + context.executeStrategy(a, b));

        CalculatorContext context2 = new CalculatorContext(new OperationSub());
        System.out.println("a - b = " + context2.executeStrategy(a, b));

        CalculatorContext context3 = new CalculatorContext(new OperationMul());
        System.out.println("a * b = " + context3.executeStrategy(a, b));

        CalculatorContext context4 = new CalculatorContext(new OperationDiv());
        System.out.println("a / b = " + context4.executeStrategy(a, b));
    }
}

class OperationAdd implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

interface CalculateStrategy {
    int doOperation(int num1, int num2);
}

class CalculatorContext {
    private CalculateStrategy strategy;

    public CalculatorContext(CalculateStrategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}

class OperationSub implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMul implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class OperationDiv implements CalculateStrategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 / num2;
    }
}