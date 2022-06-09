package com.xuegao.luanqibazao_1.utils.jsoup;


import com.alibaba.fastjson.JSON;

public class FileNameUrlV2BuilderTest {
    public static void main(String[] args) {
        FileNameUrlV2 fileNameUrlV2 = FileNameUrlV2.builder().fileName("fileNamee").build();
        System.out.println(JSON.toJSONString(fileNameUrlV2));

    }
}