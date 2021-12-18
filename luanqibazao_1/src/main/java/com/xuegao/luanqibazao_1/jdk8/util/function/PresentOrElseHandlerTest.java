package com.xuegao.luanqibazao_1.jdk8.util.function;

import java.util.function.Consumer;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/14 13:31
 */
public class PresentOrElseHandlerTest {
    public static void main(String[] args) {
        isBlankOrNoBlank("").presentOrElseHandle(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s = " + s);
            }
        }, new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });
    }

    /**
     * 参数为true或false时，分别进行不同的操作
     *
     * @param str
     * @return com.example.demo.func.BranchHandle
     **/
    public static PresentOrElseHandler<?> isBlankOrNoBlank(String str) {

        return (consumer, runnable) -> {
            if (str == null || str.length() == 0) {
                runnable.run();
            } else {
                consumer.accept(str);
            }
        };
    }
}