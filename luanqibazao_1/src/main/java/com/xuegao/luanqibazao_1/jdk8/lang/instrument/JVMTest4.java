package com.xuegao.luanqibazao_1.jdk8.lang.instrument;

import java.lang.instrument.Instrumentation;

public class JVMTest4 {
    private static Instrumentation inst;

    public static void premain(String agentArgs, Instrumentation instP) {
        inst = instP;
    }

    public static long sizeOf(Object obj) {
        return inst.getObjectSize(obj);
    }

    private static class ObjectA {
        // String str;co'm
        int i1;
        // byte b1;
        // byte b2;
        // int i2;
        // byte b3;
    }

    public static void main(String[] args) {
        System.out.println(sizeOf(new ObjectA()));
    }
}