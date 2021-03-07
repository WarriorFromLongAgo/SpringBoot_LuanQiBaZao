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

        String sign = Constant.appSecret + "appKey" + Constant.appKey + "fileSize" + Constant.fileSize + "fileType" + Constant.fileType + "md5Code" + Constant.md5Code + "ticket" + Constant.ticket + "timestamp" + Constant.timestamp + Constant.appSecret;
        System.out.println(sign);
        String signMd51 = DigestUtils.md5DigestAsHex(sign.getBytes());
        String signMd52 = Md5Test.string2MD5(sign);
        System.out.println(signMd51);
        System.out.println(signMd52);
        String signMd53 = Md5Test.convertMD5(Md5Test.convertMD5(sign));
        System.out.println(signMd53);
        System.out.println(sign.equals(signMd53));
        jsonObject.put("appKey", Constant.appKey);
        jsonObject.put("md5Code", Constant.md5Code);
        jsonObject.put("ticket", Constant.ticket);
        jsonObject.put("timestamp", Constant.timestamp);
        jsonObject.put("fileSize", Constant.fileSize);
        jsonObject.put("fileType", Constant.fileType);
        jsonObject.put("sign", signMd51);
        System.out.println(jsonObject);
    }
}