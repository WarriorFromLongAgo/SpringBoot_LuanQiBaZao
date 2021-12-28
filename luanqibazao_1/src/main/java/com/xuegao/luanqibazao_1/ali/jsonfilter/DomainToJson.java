package com.xuegao.luanqibazao_1.ali.jsonfilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author xuegao
 * @version 1.0
 * @date 2021/12/28 17:39
 */
public class DomainToJson {
    private static String json = "";

    public static void main(String[] args) {
        json = json.trim();


    }

    /**
     * Object 转换为 json 文件
     *
     * @param finalPath finalPath 是绝对路径 + 文件名，请确保欲生成的文件所在目录已创建好
     * @param object    需要被转换的 Object
     */
    public static void object2JsonFile(String finalPath, Object object) {
        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(System.currentTimeMillis() + finalPath);
            OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            osw.write(jsonObject.toJSONString());
            osw.flush();
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject.toJSONString());
    }
}