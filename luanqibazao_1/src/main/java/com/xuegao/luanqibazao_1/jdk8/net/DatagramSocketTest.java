package com.xuegao.luanqibazao_1.jdk8.net;

/**
 * 此类表示用来发送和接收数据报包的套接字，又称数据报套接字。
 * 数据报套接字是包投递服务的发送或接收点，使用UDP协议发送数据包
 *
 * DatagramSocket()
 * 构造数据报套接字并将其绑定到本地主机上任何可用的端口。套接字将被绑定到通配符地址，IP 地址由内核来选择。
 * DatagramSocket(int port)port -表示要使用的端口。
 * 创建数据报套接字并将其绑定到本地主机上的指定端口。
 *
 * void send(DatagramPacket p)
 * 从此套接字发送数据报包。DatagramPacket 包含的信息指示：将要发送的数据、其长度、远程主机的 IP 地址和远程主机的端口号。
 *
 *
 *       void receive(DatagramPacket p)
 *       从此套接字接收数据报包。当此方法返回时，DatagramPacket 的缓冲区已经填充了接收的数据。数据报包也包含发送方的 IP 地址和发送方机器上的端口号。此方法在接收到数据报包前一直阻塞。
 *
 *
 *       InetAddress getLocalAddress()
 *       返回套接字绑定的本地地址，如果套接字没有绑定则返回表示任何本地地址的InetAddress。
 *
 *
 *       int getPort()
 *       返回此套接字的端口。如果套接字未连接，则返回 -1。
 *
 * 作者：刘Java
 * 链接：https://juejin.cn/post/6994275835905572872
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * <br/> @ClassName：DatagramSocketTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/8/11 9:23
 */
public class DatagramSocketTest {
    public static void main(String[] args) {

    }
}