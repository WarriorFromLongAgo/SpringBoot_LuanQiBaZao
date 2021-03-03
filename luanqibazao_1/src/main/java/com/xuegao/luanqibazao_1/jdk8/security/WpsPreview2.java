package com.xuegao.luanqibazao_1.jdk8.security;

import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.security
 * <br/> @ClassName：Wps
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 14:21
 */
public class WpsPreview2 {
    public static void main(String[] args) {
        String appSecret = "as_sddf2s!@S88";
        String appKey = "ak_paperless";
        String md5Code = "a332321ac3146ca3382b9d1e6f6aa633";
        String ticket = "ST-9739-rPr3eqSuW2y6NTfODqqe-casnode1";
        String fileSize = "1000";
        String fileType = "pptx";
        long timestamp = System.currentTimeMillis();

        Map<String, String> map = new HashMap<>(8);
        map.put("md5Code", md5Code);
        map.put("fileSize", fileSize);
        map.put("fileType", fileType);
        map.put("appKey", appKey);
        map.put("timestamp", String.valueOf(timestamp));
        map.put("ticket", ticket);
        System.out.println(map);
        String md5Sign = md5Sign(map, appSecret);
        System.out.println(md5Sign);
    }

    private static String md5Sign(Map<String, String> map, String appSecret) {
        Map<String, String> paramMap = new TreeMap<>(map);
        StringBuilder requestSb = new StringBuilder();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            requestSb.append(entry.getKey()).append(entry.getValue());
        }
        return md5(appSecret + requestSb.toString() + appSecret);
    }

    private static String md5(String value) {
        return DigestUtils.md5DigestAsHex(value.getBytes());
    }
}