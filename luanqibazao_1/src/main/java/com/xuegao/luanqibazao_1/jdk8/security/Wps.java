package com.xuegao.luanqibazao_1.jdk8.security;

import com.alibaba.fastjson.JSONObject;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.security
 * <br/> @ClassName：Wps
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 14:21
 */
public class Wps {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        String appSecret = "as_sddf2s!@S88";
        String appKey = "ak_paperless";
        String md5Code = "a332321ac3146ca3382b9d1e6f6aa633";
        String ticket = "ST-1429-5XxN9xYeLYd4zC23NuFn-casnode1";
        String fileSize = "1000";
        String fileType = "pptx";
        String sign = appSecret + "appKey" + appKey + "fileSize" + fileSize + "md5code" + md5Code + appSecret;
        String signMd5 = Md5Test.string2MD5(sign);
        System.out.println(signMd5);
        String signMd52 = Md5Test.convertMD5(Md5Test.convertMD5(sign));
        System.out.println(signMd52);
        jsonObject.put("appKey", appKey);
        jsonObject.put("md5Code", md5Code);
        jsonObject.put("ticket", ticket);
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("fileSize", fileSize);
        jsonObject.put("fileType", fileType);
        jsonObject.put("sign", signMd5);
        System.out.println(jsonObject);
    }
}