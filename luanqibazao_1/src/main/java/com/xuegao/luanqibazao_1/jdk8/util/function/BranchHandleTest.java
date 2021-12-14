package com.xuegao.luanqibazao_1.jdk8.util.function;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/14 13:29
 */
public class BranchHandleTest {
    public static void main(String[] args) {
        isTureOrFalse(false).trueOrFalseHandle(new Runnable() {
            @Override
            public void run() {
                System.out.println("true");
            }
        }, new Runnable() {
            @Override
            public void run() {
                System.out.println("false");
            }
        });
    }

    /**
     * 参数为true或false时，分别进行不同的操作
     *
     * @param b
     * @return com.example.demo.func.BranchHandle
     **/
    public static BranchHandle isTureOrFalse(boolean b) {

        return (trueHandle, falseHandle) -> {
            if (b) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }
}