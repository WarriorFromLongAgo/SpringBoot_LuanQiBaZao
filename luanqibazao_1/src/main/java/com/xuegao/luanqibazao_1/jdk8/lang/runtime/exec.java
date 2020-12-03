package com.xuegao.luanqibazao_1.jdk8.lang.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.runtime
 * <br/> @ClassName：exec
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/4 9:46
 */
public class exec {
    public static void main(String[] args) {
        testProcess1();
    }

    public static void testProcess1() {
        try {
            Runtime runtime = Runtime.getRuntime();
            // 执行命令
            Process process = runtime.exec("java -version");
            // 错误信息
            StreamOutput error = new StreamOutput(process.getErrorStream(), "ERROR");
            // 输出信息（Runtime的输出，即Process的输入）
            StreamOutput output = new StreamOutput(process.getInputStream(), "OUTPUT");
            // 启动执行
            error.start();
            output.start();
            // 子进程退出状态，0表示正常终止
            int exitVal = process.waitFor();
            System.out.println("ExitValue: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    // ERROR>Error: Could not create the Java Virtual Machine.
    // ERROR>Error: A fatal exception has occurred. Program will exit.
    // ERROR>Unrecognized option: -dfsversion
    // ExitValue: 1

    // ERROR>java version "1.8.0_221"
    // ERROR>Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
    // ERROR>Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)
    // ExitValue: 0
}

class StreamOutput extends Thread {
    InputStream is;
    String type;

    StreamOutput(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    public void run() {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(is, "GBK");
            br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(type + ">" + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}