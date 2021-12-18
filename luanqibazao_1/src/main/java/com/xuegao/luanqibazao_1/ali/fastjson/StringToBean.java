package com.xuegao.luanqibazao_1.ali.fastjson;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.xuegao.luanqibazao_1.domain.FileUpLoadBO;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.json.fastjson
 * <br/> @ClassName：StringToBean
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/21 20:16
 */
public class StringToBean {
    public static void main(String[] args) {
        String json = "{\"status\":\"complete\",\"fileType\":\"PPTX\",\"flag\":\"1\",\"container\":\"IMG\",\"fileName\":\"a25351b7-5e6f-41c3-ac2d-8422917fa6a1.pptx\",\"json\":{\"0\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/0.jpg\",\"1\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/1.jpg\",\"2\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/2.jpg\",\"3\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/3.jpg\",\"4\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/4.jpg\",\"5\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/5.jpg\",\"6\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/6.jpg\",\"7\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/7.jpg\",\"8\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/8.jpg\",\"9\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/9.jpg\",\"10\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/10.jpg\",\"11\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/11.jpg\",\"12\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/12.jpg\",\"13\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/13.jpg\",\"14\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/14.jpg\",\"15\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/15.jpg\",\"16\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/16.jpg\",\"17\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/17.jpg\",\"18\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/18.jpg\",\"19\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/19.jpg\",\"20\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/20.jpg\",\"21\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/21.jpg\",\"22\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/22.jpg\",\"23\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/23.jpg\",\"24\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/24.jpg\",\"25\":\"http://sfecp-fcs.sit.sf-express.com:1080/office/img/20200922/1600707023166/25.jpg\"},\"htmlWidth\":0}\n";
        FileUpLoadBO fileUpLoadBO = JSONObject.parseObject(json, FileUpLoadBO.class);
        System.out.println(fileUpLoadBO);
        System.out.println(fileUpLoadBO.getJson());
        Map<String, String> map = JSONObject.parseObject(fileUpLoadBO.getJson(), new TypeReference<Map<String, String>>() {
        });
        System.out.println(map);
        Map<String, String> treeMap = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int key1 = Integer.parseInt(o1);
                int key2 = Integer.parseInt(o2);
                return Integer.compare(key1, key2);
            }
        });
        treeMap.putAll(map);
        System.out.println(treeMap);
    }
}