package com.xuegao.luanqibazao_1.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.runtime
 * <br/> @ClassName：exec
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/4 9:46
 */
public class exec2 {
    private final static Logger logger = LoggerFactory.getLogger(exec2.class);

    public static void main(String[] args) {
        String cmd = "java -version";
        exec(cmd);
    }

    public static boolean exec(String command) {
        // Process可以控制该子进程的执行或获取该子进程的信息
        Process process;
        try {
            logger.debug("exec cmd : {}", command);
            // exec()方法指示Java虚拟机创建一个子进程执行指定的可执行程序，并返回与该子进程对应的Process对象实例。
            process = Runtime.getRuntime().exec(command);
            // 下面两个可以获取输入输出流
            InputStream errorStream = process.getErrorStream();
            InputStream inputStream = process.getInputStream();
        } catch (IOException e) {
            logger.error(" exec {} error", command, e);
            return false;
        }

        int exitStatus = 0;
        try {
            // 等待子进程完成再往下执行，返回值是子线程执行完毕的返回值,返回0表示正常结束
            exitStatus = process.waitFor();
            // 第二种接受返回值的方法
            // 接收执行完毕的返回值
            int i = process.exitValue();
            logger.debug("i----" + i);
        } catch (InterruptedException e) {
            logger.error("InterruptedException  exec {}", command, e);
            return false;
        }

        if (exitStatus != 0) {
            logger.error("exec cmd exitStatus {}", exitStatus);
        } else {
            logger.debug("exec cmd exitStatus {}", exitStatus);
        }

        // 销毁子进程
        process.destroy();
        process = null;

        return true;
    }
}