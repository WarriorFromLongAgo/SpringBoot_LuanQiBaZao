package com.xuegao.luanqibazao_1.http;

import java.io.*;
import java.net.URL;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http
 * <br/> @ClassName：DownloadPicture3
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 11:04
 */
public class DownloadPicture3 {
    public static void main(String[] args) {
        // 图片地址
        String imgUrl = "http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/1.jpg";
        download(imgUrl);
    }

    public static Long download(String imgUrl) {
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        long startTime = System.currentTimeMillis();
        try {

            inputStream = new URL(imgUrl).openConnection().getInputStream();
            // 可以使用
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\nfsc\\KMS\\train.homework\\" + System.currentTimeMillis() + ".jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}