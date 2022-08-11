package com.xuegao.luanqibazao_1.jdk8.util.concurrent.completablefuture.util;

@FunctionalInterface
public interface ThriftAsyncCall {
    void invoke() throws RuntimeException ;
}