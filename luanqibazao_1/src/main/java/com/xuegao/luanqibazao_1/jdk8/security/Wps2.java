package com.xuegao.luanqibazao_1.jdk8.security;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.security
 * <br/> @ClassName：Wps
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 14:21
 */
public class Wps2 {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        String appSecret = "as_sddf2s!@S88";
        String appKey = "ak_paperless";
        String md5Code = "a332321ac3146ca3382b9d1e6f6aa633";
        String ticket = "ST-1429-5XxN9xYeLYd4zC23NuFn-casnode1";
        String fileSize = "1000";
        String fileType = "pptx";
        long timestamp = System.currentTimeMillis();
        String sign = appSecret + "appKey" + appKey + "fileSize" + fileSize + "fileType" + fileType + "md5Code" + md5Code + "timestamp" + timestamp + appSecret;
        System.out.println(sign);
        String signMd51 = DigestUtils.md5DigestAsHex(sign.getBytes());
        String signMd52 = Md5Test.string2MD5(sign);
        System.out.println(signMd51);
        System.out.println(signMd52);
        String signMd53 = Md5Test.convertMD5(Md5Test.convertMD5(sign));
        System.out.println(signMd53);
        System.out.println(sign.equals(signMd53));
        jsonObject.put("appKey", appKey);
        jsonObject.put("md5Code", md5Code);
        jsonObject.put("ticket", ticket);
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("fileSize", fileSize);
        jsonObject.put("fileType", fileType);
        jsonObject.put("sign", signMd51);
        System.out.println(jsonObject);
    }
}