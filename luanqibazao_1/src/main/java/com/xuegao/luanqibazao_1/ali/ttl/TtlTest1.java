package com.xuegao.luanqibazao_1.ali.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/18 14:04
 */
public class TtlTest1 {
    public static void main(String[] args) {
        ThreadLocal<String> parent = new TransmittableThreadLocal<>();
        parent.set("hello");
        System.out.println("1 = " + parent.get());

    }

    private static void enter() {
        System.out.println("===========================");
    }



}