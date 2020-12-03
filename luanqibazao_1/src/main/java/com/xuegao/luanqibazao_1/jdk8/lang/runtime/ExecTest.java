package com.xuegao.luanqibazao_1.jdk8.lang.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.runtime
 * <br/> @ClassName：ExecTest
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/2 18:24
 */
public class ExecTest {

    public static void exec(String cmd) {
        int result = -1;
        BufferedReader successResult = null;
        BufferedReader errorResult = null;
        StringBuilder successMsg = null;
        StringBuilder errorMsg = null;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            result = process.waitFor();
            successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
            errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String s;
            successMsg = new StringBuilder();
            while ((s = successResult.readLine()) != null) {
                successMsg.append(s).append("\n");
            }
            errorMsg = new StringBuilder();
            while ((s = errorResult.readLine()) != null) {
                errorMsg.append(s).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (successResult != null) {
                    successResult.close();
                }
                if (errorResult != null) {
                    errorResult.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String success = successMsg == null ? "" : successMsg.toString();
        if (success.endsWith("\n")) {
            success = success.substring(0, success.length() - 1);
        }
        String error = errorMsg == null ? "" : errorMsg.toString();
        if (error.endsWith("\n")) {
            error = error.substring(0, error.length() - 1);
        }


        System.out.println(result);
        System.out.println(success);
        System.out.println(error);
    }
}