package com.xuegao.luanqibazao_1.ali.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.json.fastjson
 * <br/> @ClassName：JsonObjectPut
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/02 15:13
 */
public class JsonObjectPut {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appUrl", "aaaaaaaaaaaaaaaa");
        System.out.println(jsonObject);
        System.out.println("================================");
        jsonObject.put("appUrl", "bbbbbbbbbbbbbbbb");
        System.out.println(jsonObject);
    }
}