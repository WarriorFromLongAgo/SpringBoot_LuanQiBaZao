package com.xuegao.luanqibazao_1.jdk8.util.function;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/14 13:23
 */
public class ThrowExceptionFunctionTest {
    public static void main(String[] args) {
        isTure(false).throwMessage("参数为true");
        isTure(true).throwMessage("参数为true");

    }

    /**
     * 如果参数为true抛出异常
     *
     * @param b
     * @return com.example.demo.func.ThrowExceptionFunction
     **/
    public static ThrowExceptionFunction isTure(boolean b) {

        return (errorMessage) -> {
            if (b) {
                throw new RuntimeException(errorMessage);
            }
        };
    }
}