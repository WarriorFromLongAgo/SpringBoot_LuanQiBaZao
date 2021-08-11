package com.xuegao.luanqibazao_1.jdk8.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * <br/> @ClassName：UDPReceiver
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/8/11 9:33
 */
public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        //创建接收端数据报包套接字socket,必须指定接收端端口号
        DatagramSocket ds = new DatagramSocket(8888);
        //循环接收数据
        while (true) {
            //构造空数据报包,用来接收数据:内部使用字节数组作为接收数据的缓冲区,可以指定起始索引和要读取的字节数.
            //如果发送的数据量大于接收空间的大小，那么数据将会丢失
            byte[] by = new byte[1024];
            DatagramPacket dp = new DatagramPacket(by, 0, by.length);
            //接收数据:将数据存入数据报包中.在接收到数据前,此方法将一直堵塞!
            ds.receive(dp);
            //打开数据报包,获得数据缓冲区数组，这里将会获取一次发送的全部数据
            byte[] data = dp.getData();
            //dp.getLength(),是指的接收到的数据的长度。
            System.out.println("data: " + new String(data, 0, dp.getLength()));
            //获得发送端ip地址
            String hostName = dp.getAddress().getHostName();
            System.out.println("hostName: " + hostName);
            //获得发送端主机名
            String hostAddress = dp.getAddress().getHostAddress();
            System.out.println("hostAddress: " + hostAddress);
            //获得发送端端口号
            int port = dp.getPort();
            System.out.println("port: " + port);
            System.out.println("----------------------------------");
        }
        //ds.close(); 接收端应该一直开着接收数据
    }

    // 作者：刘Java
    // 链接：https://juejin.cn/post/6994275835905572872
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}