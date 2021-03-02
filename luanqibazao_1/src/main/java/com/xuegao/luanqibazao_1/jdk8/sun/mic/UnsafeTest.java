// package com.xuegao.luanqibazao_1.jdk8.sun.mic;
//
// import com.xuegao.luanqibazao_1.domain.RequestV1DTO;
// import org.apache.tomcat.jni.Error;
// import sun.misc.Unsafe;
//
// import java.lang.reflect.Field;
//
// /**
//  * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.sun.mic
//  * <br/> @ClassName：UnsafeTest
//  * <br/> @Description：
//  * <br/> @author：xuegao
//  * <br/> @date：2021/03/01 11:25
//  */
// public class UnsafeTest {
//     private static final Unsafe UNSAFE;
//
//     // 只能通过反射获取Unsafe对象的实例
//     static {
//         try {
//             UNSAFE = (Unsafe) Unsafe.class.getDeclaredField("theUnsafe").get(null);
//         } catch (Exception e) {
//             try {
//                 throw new Throwable();
//             } catch (Throwable throwable) {
//                 throwable.printStackTrace();
//             }
//         }
//     }
//
//     public static void main(String[] args) {
//         Field[] fields = RequestV1DTO.class.getDeclaredFields();
//         for (Field field : fields) {
//             System.out.println(field.getName() + "---offSet:" + UNSAFE.objectFieldOffset(field));
//         }
//     }
// }