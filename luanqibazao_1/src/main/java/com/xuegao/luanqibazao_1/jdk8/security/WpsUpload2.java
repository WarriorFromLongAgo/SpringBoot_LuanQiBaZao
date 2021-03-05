package com.xuegao.luanqibazao_1.jdk8.security;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.security
 * <br/> @ClassName：Wps
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/03/02 14:21
 */
public class WpsUpload2 {
    // public static void main(String[] args) {
    //     Map<String, String> map = new HashMap<>(8);
    //     map.put("md5Code", Constant.md5Code);
    //     map.put("fileSize", Constant.fileSize);
    //     map.put("fileType", Constant.fileType);
    //     map.put("appKey", Constant.appKey);
    //     map.put("timestamp", String.valueOf(Constant.timestamp));
    //     map.put("ticket", Constant.ticket);
    //     System.out.println(map);
    //     String md5Sign = md5Sign(map, Constant.appSecret);
    //     System.out.println(md5Sign);
    // }
    //
    // private static String md5Sign(Map<String, String> map, String appSecret) {
    //     Map<String, String> paramMap = new TreeMap<>(map);
    //     StringBuilder requestSb = new StringBuilder();
    //     for (Map.Entry<String, String> entry : paramMap.entrySet()) {
    //         requestSb.append(entry.getKey()).append(entry.getValue());
    //     }
    //     return md5(appSecret + requestSb.toString() + appSecret);
    // }
    //
    // private static String md5(String value) {
    //     return DigestUtils.md5DigestAsHex(value.getBytes());
    // }
}