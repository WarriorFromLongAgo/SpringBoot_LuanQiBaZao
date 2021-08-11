package com.xuegao.luanqibazao_1.jdk8.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <br/> @ClassName：UDPSend
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/8/11 9:33
 */
public class UDPSend {
    public static void main(String[] args) throws IOException, IOException {
        //1.创建发送端数据报包套接字socket,用来发送数据报包。如果指定一个端口号，指定的是发送端的端口号；如果不指定端口号，系统会默认分配一个。
        DatagramSocket ds = new DatagramSocket();
        //2.构造数据报包,包括:发送的数据的字节数组,起始索引,数据长度,指定远程主机的ip地址[InetAddress对象],以及远程主机上的端口号.（这里就发送到本机演示）
        DatagramPacket dp = new DatagramPacket("你好111".getBytes(), 0, "你好".getBytes().length, InetAddress.getLocalHost(), 8888);
        //3.发送数据报包
        ds.send(dp);
        //4.关闭套接字socket
        ds.close();
    }

    // 作者：刘Java
    // 链接：https://juejin.cn/post/6994275835905572872
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}