// package com.xuegao.nio_project.netty.netty2;
//
// import io.netty.channel.socket.nio.NioSocketChannel;
//
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;
//
// public class NettySocketHolder {
//     private static final Map<Long, NioSocketChannel> MAP = new ConcurrentHashMap<>(16);
//
//     public static void put(Long id, NioSocketChannel socketChannel) {
//         MAP.put(id, socketChannel);
//     }
//
//     public static NioSocketChannel get(Long id) {
//         return MAP.get(id);
//     }
//
//     public static Map<Long, NioSocketChannel> getMAP() {
//         return MAP;
//     }
//
//     public static void remove(NioSocketChannel nioSocketChannel) {
//         MAP.entrySet().stream().filter(entry -> entry.getValue() == nioSocketChannel).forEach(entry -> MAP.remove(entry.getKey()));
//     }
// }
//
// 作者：crossoverJie
// 链接：https://juejin.im/post/5b0b50a4f265da0dbd7a697d
// 来源：掘金
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。