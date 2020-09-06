package com.xuegao.luanqibazao_1.http;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http
 * <br/> @ClassName：DownloadPicture3
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 11:04
 */
public class DownloadPicture3 {
    public static void main(String[] args) throws IOException {
        // 图片地址
        // String imgUrl = "http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/1.jpg";
        String imgUrl = "https://s1.ax1x.com/2020/09/05/wVLTje.png";
        download(imgUrl);
    }

    public static Long download(String imgUrl) throws IOException {
        long startTime = System.currentTimeMillis();
        URLConnection urlConnection = new URL(imgUrl).openConnection();
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(urlConnection.getInputStream());
             FileChannel outputChannel = new FileOutputStream(
                     new File("D:\\nfsc\\KMS\\train.homework\\" + startTime + ".jpg")).getChannel()) {
            outputChannel.transferFrom(readableByteChannel, 0, urlConnection.getContentLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}