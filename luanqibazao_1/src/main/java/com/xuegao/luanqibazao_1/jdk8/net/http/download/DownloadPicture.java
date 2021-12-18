package com.xuegao.luanqibazao_1.jdk8.net.http.download;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http
 * <br/> @ClassName：DownloadPicture
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 10:08
 */
public class DownloadPicture {
    public static void main(String[] args) {
        String imgUrl = "http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200901/1598975974446/1.jpg";//图片地址
        try {
            // 构造URL
            URL url = new URL(imgUrl);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream is = con.getInputStream();
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            OutputStream os = new FileOutputStream("D:\\nfsc\\KMS\\train.homework\\" + System.currentTimeMillis() + ".jpg");//保存路径
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}