package com.xuegao.luanqibazao_1.http.download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http.download
 * <br/> @ClassName：getHtml
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/11 22:42
 */
public class getHtml {
    public static void main(String[] args) throws IOException {
        String imgUrl = "http://113.105.119.26:9082/filepreview/preview/getPreviewHtml302?previewToken=356bca2e9a30be743cbd7af1b6cf6e862a5068c5516adc93c62f79581e99db23c7a10184570812480d9368ac4dac6629c646eba69b52a5b5376cd17c4b15f45b6622fcd81dff776a16d3bcb19220123f84f49ff738ed63c24b886cf9e02fc1bb8a368caa9668065e7e0b7477b3024bbf57ae949f2bc17928bc10ad8f6f46b85c";
        // 构造URL

        Document doc = Jsoup.parse(new URL(imgUrl), (100000000));
        String s = doc.toString();
        System.out.println(s);


    }
}