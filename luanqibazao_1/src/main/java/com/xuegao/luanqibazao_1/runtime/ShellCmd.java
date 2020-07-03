package com.xuegao.luanqibazao_1.runtime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.runtime
 * <br/> @ClassName：ShellCmd
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/2 18:27
 */
public class ShellCmd {
    private static Logger logger = LoggerFactory.getLogger(ShellCmd.class.getName());

    private static final String COMMAND_SH = "sh";
    private static final String COMMAND_LINE_END = "\n";
    private static final String COMMAND_EXIT = "exit\n";
    private static ExecutorService pool;

    private static Process process(String command) {
        Runtime rt = Runtime.getRuntime();
        Process p = null;
        try {
            p = rt.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
            p = null;
        }
        return p;
    }

    private static void initPool() {
        if (pool != null) {
            pool.shutdownNow();
            pool = null;
        }
        pool = Executors.newCachedThreadPool();
    }

    public static String exec(String command) {
        if (StringUtils.isEmpty(command)) return "nil";
        int runningStatus = -1;
        try {
            initPool();
            Process process = process(COMMAND_SH);
            try {
                DataOutputStream dos = new DataOutputStream(process.getOutputStream());
                dos.write(command.getBytes());
                dos.writeBytes(COMMAND_LINE_END);
                dos.flush();
                dos.writeBytes(COMMAND_EXIT);
                dos.flush();
                dos.close();
                InputStream err = process.getErrorStream();
                InputStream normal = process.getInputStream();
                List<Future<String>> futureList = new ArrayList<>();
                futureList.add(pool.submit(new StreamReaderWorker(normal, StreamType.NORMAL)));
                futureList.add(pool.submit(new StreamReaderWorker(err, StreamType.ERROR)));
                runningStatus = process.waitFor();
                for (Future<String> future : futureList) {
                    try {
                        String str = future.get();
                        logger.warn(str);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                process.destroy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "" + runningStatus;
    }
}