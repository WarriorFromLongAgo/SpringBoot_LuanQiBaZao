package com.xuegao.luanqibazao_1.ali.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xuegao.luanqibazao_1.domain.PptServerResultBO;

import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.json.fastjson
 * <br/> @ClassName：StringToObject
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/2 10:27
 */
public class StringToObject {
    public static void main(String[] args) {
        String jsonStr = "result: {\n" +
                "    \"status\": \"complete\",\n" +
                "    \"fileType\": \"PPTX\",\n" +
                "    \"flag\": \"1\",\n" +
                "    \"container\": \"IMG\",\n" +
                "    \"fileName\": \"市场与竞争研究-脱敏.pptx\",\n" +
                "    \"json\": {\n" +
                "        \"0\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/0.jpg\",\n" +
                "        \"1\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/1.jpg\",\n" +
                "        \"2\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/2.jpg\",\n" +
                "        \"3\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/3.jpg\",\n" +
                "        \"4\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/4.jpg\",\n" +
                "        \"5\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/5.jpg\",\n" +
                "        \"6\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/6.jpg\",\n" +
                "        \"7\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/7.jpg\",\n" +
                "        \"8\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/8.jpg\",\n" +
                "        \"9\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/9.jpg\",\n" +
                "        \"10\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/10.jpg\",\n" +
                "        \"11\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/11.jpg\",\n" +
                "        \"12\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/12.jpg\",\n" +
                "        \"13\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/13.jpg\",\n" +
                "        \"14\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/14.jpg\",\n" +
                "        \"15\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/15.jpg\",\n" +
                "        \"16\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/16.jpg\",\n" +
                "        \"17\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/17.jpg\",\n" +
                "        \"18\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/18.jpg\",\n" +
                "        \"19\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/19.jpg\",\n" +
                "        \"20\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/20.jpg\",\n" +
                "        \"21\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/21.jpg\",\n" +
                "        \"22\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/22.jpg\",\n" +
                "        \"23\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/23.jpg\",\n" +
                "        \"24\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/24.jpg\",\n" +
                "        \"25\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/25.jpg\",\n" +
                "        \"27\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/27.jpg\",\n" +
                "        \"28\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/28.jpg\",\n" +
                "        \"29\": \"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200902/1599028257600/29.jpg\"\n" +
                "    },\n" +
                "    \"htmlWidth\": 0\n" +
                "}";
        // PptServerResultBO pptServerResultBO = JSONObject.parseObject(jsonStr, PptServerResultBO.class);
        // System.out.println(pptServerResultBO);
        // ResultBO resultBO = JSONObject.parseObject(jsonStr, ResultBO.class);
        // System.out.println(resultBO);
        String replace = jsonStr.replace("result: ", "");
        JSONObject jsonObject = JSONObject.parseObject(replace);
        System.out.println(jsonObject);
        PptServerResultBO pptServerResultBO = JSONObject.toJavaObject(jsonObject, PptServerResultBO.class);
        System.out.println(pptServerResultBO);
        String json = pptServerResultBO.getJson();
        System.out.println(json);
        // Map map = JSONObject.parseObject(json, Map.class);
        // System.out.println(map);
        Map<String, String> map = JSONObject.parseObject(json, new TypeReference<Map<String, String>>() {
        });
        System.out.println(map.size());
        System.out.println(map);
    }
}