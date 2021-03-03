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
public class WpsPreview {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        String appSecret = "as_sddf2s!@S88";
        String appKey = "ak_paperless";
        String md5Code = "a332321ac3146ca3382b9d1e6f6aa633";
        String ticket = "ST-8640-gmQB9hpbYJm5YhtGrh7d-casnode1";
        String fileSize = "1000";
        String fileType = "pptx";
        String sign = appSecret + "appKey" + appKey + "fileSize" + fileSize + "fileType" + fileType + "md5Code" + md5Code + "ticket" + ticket + "timestamp" + System.currentTimeMillis() + appSecret;
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
        jsonObject.put("timestamp", System.currentTimeMillis());
        jsonObject.put("fileSize", fileSize);
        jsonObject.put("fileType", fileType);
        jsonObject.put("sign", signMd51);
        System.out.println(jsonObject);
        // as_sddf2s!@S88appKeyak_paperlessfileSize1000fileTypepptxmd5Codea332321ac3146ca3382b9d1e6f6aa633 ticketST-8190-SVc55DpjFfpYMh5zA9qr-casnode1 timestamp1614763334822as_sddf2s!@S88
        // as_sddf2s!@S88appKeyak_paperlessfileSize1000fileTypepptxmd5Codea332321ac3146ca3382b9d1e6f6aa633 ticketST-1429-5XxN9xYeLYd4zC23NuFn-casnode1 timestamp1614677913477as_sddf2s!@S88
    }
}