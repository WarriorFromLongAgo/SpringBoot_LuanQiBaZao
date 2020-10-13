package com.xuegao.luanqibazao_1.jdk8.nio.filechannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.nio.filechannel
 * <br/> @ClassName：FileChannel
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/10/13 10:18
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileChannel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);


        //下面就是数据读写的流程了

        while (true){
            byteBuffer.clear(); //清空buffer
            int read = fileChannel01.read(byteBuffer);

            System.out.println("read =" + read);
            if(read == -1) { //表示读完
                break;
            }

            //将buffer 中的数据写入到 fileChannel02 -- 2.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);

            //将buffer 中的数据写入到 fileChannel02 -- 2.txt
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }

    // 作者：六脉神剑
    // 链接：https://juejin.im/post/6860275544655659015
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}