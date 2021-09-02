package com.xuegao.luanqibazao_1.jdk8.io.bio.bio20210830;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class BIOEchoClient {


    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(client.getOutputStream());
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String inputData = scanner.nextLine().trim();
            out.println(inputData);
            if ("byebye".equalsIgnoreCase(inputData)) {
                flag = false;
                System.out.println("和客户端说再见拉!!!");
            }
        }
        client.close();
    }
}

// 作者：宁在春
// 链接：https://juejin.cn/post/7001471411478872094
// 来源：掘金
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。