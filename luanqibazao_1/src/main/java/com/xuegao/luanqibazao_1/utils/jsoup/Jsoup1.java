package com.xuegao.luanqibazao_1.utils.jsoup;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Jsoup1 {
    private static final Logger log = LoggerFactory.getLogger(Jsoup1.class);

    public static void main(String[] args) throws IOException {
        String url = "http://soft.kyepm.com/%E4%BA%BA%E6%89%8D%E5%9F%B9%E5%85%BB/";
        List<JsoupUtils.FileNameUrl> fileNameUrlList = JsoupUtils.getHtmlV2(url);

        // String url = "http://soft.kyepm.com/%E4%BA%BA%E6%89%8D%E5%9F%B9%E5%85%BB/";
        // List<JsoupUtils.FileNameUrl> fileNameUrlList = JsoupUtils.getHtml(url);
        // log.info("[SpringBoot_LuanQiBaZao][Jsoup1][main][={}]", JSON.toJSONString(fileNameUrlList));
    }
}
