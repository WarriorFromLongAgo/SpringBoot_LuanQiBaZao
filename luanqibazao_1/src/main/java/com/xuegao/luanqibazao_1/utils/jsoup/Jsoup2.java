package com.xuegao.luanqibazao_1.utils.jsoup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Jsoup2 {
    private static final Logger log = LoggerFactory.getLogger(Jsoup2.class);

    public static void main(String[] args) throws IOException {
        String downKey = "down";
        String folderKey = "folder";
        String url = "http://s%E5%9F%B9%E5%85%BB/";
        Map<String, List<FileNameUrl>> resultMap = JsoupUtilsV2.getUrl(url, downKey, folderKey);
        List<FileNameUrl> downList = resultMap.get(downKey);
        List<FileNameUrl> folderList = resultMap.get(folderKey);
        System.out.println();
    }
}
