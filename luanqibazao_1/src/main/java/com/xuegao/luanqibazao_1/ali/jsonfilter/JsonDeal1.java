package com.xuegao.luanqibazao_1.ali.jsonfilter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class JsonDeal1 {
    private static String json = "";

    public static void main(String[] args) {
        json = json.trim();

        List<JSONObject> addList = JSON.parseArray(json, JSONObject.class);
        List<JSONObject> kafkaList = new ArrayList<>(addList.size());

        for (JSONObject temp : addList) {
            String id = temp.getString("id");
            String customerId = temp.getString("customer_id");
            String beginEndAddress = temp.getString("begin_end_address");
            String beginAreaCode = temp.getString("begin_area_code");
            String endAreaCode = temp.getString("end_area_code");
            String startingAreaCode = temp.getString("starting_airport_code");
            String destinationAreaCode = temp.getString("destination_airport_code");

            JSONObject kafkaJsonObject = new JSONObject();
            kafkaJsonObject.put("customer_fly_offer_id", id);
            kafkaJsonObject.put("customer_id", customerId);
            kafkaJsonObject.put("begin_end_address", beginEndAddress);
            kafkaJsonObject.put("begin_area_code", beginAreaCode);
            kafkaJsonObject.put("end_area_code", endAreaCode);
            kafkaJsonObject.put("starting_airport_code", startingAreaCode);
            if (StringUtils.isBlank(startingAreaCode)) {
                kafkaJsonObject.put("starting_airport_code", beginAreaCode);
            }
            kafkaJsonObject.put("destination_area_code", destinationAreaCode);
            if (StringUtils.isBlank(destinationAreaCode)) {
                kafkaJsonObject.put("destination_area_code", endAreaCode);
            }
            kafkaList.add(kafkaJsonObject);
        }
        System.out.println(kafkaList);
    }

    private static void extracted() {
        // JSONObject jsonObject = JSON.parseObject(json);
        // String customerId = jsonObject.getString("customerId");
        // String addListStr = jsonObject.getString("addList");

        List<JSONObject> addList = JSON.parseArray(json, JSONObject.class);
        for (JSONObject temp : addList) {
            String id = temp.getString("id");
            String customerId = temp.getString("customerId");
            String beginEndAddress = temp.getString("beginEndAddress");
            String beginAddress = temp.getString("beginAddress");
            String endAddress = temp.getString("endAddress");
            String beginAreaCode = temp.getString("beginAreaCode");
            String endAreaCode = temp.getString("endAreaCode");
            String startingAreaCode = temp.getString("startingAreaCode");
            String destinationAreaCode = temp.getString("destinationAreaCode");


        }
    }

    private static void createSql() {
        String sql = "";

    }
}