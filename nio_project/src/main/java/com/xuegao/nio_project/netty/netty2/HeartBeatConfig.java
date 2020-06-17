// package com.xuegao.nio_project.netty.netty2;
//
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// public class HeartBeatConfig {
//
//     @Value("${channel.id}")
//     private long id ;
//
//
//     @Bean(value = "heartBeat")
//     public CustomProtocol heartBeat(){
//         return new CustomProtocol(id,"ping") ;
//     }
// }
//
// // 作者：crossoverJie
// // 链接：https://juejin.im/post/5b0b50a4f265da0dbd7a697d
// // 来源：掘金
// // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。