package com.xuegao.luanqibazao_1.tools.JsonAreaDuplicate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

// const json = '{"result":true, "count":42}';
// const obj = JSON.parse(json);
// console.log(obj.count);
// // expected output: 42
// console.log(obj.result);
// // expected output: true

// const obj = JSON.parse(json);
// const ret = obj.data.rows.map(item => {
// const {beginAreaCode, endAreaCode, id} = item
// return {
// beginAreaCode,
// endAreaCode,
// id
// }
// })
// console.log(ret)

public class JsonDeal {
    public static void main(String[] args) {
        JSONArray data1 = JsonData1.JSON_DATA;
        for (Object o : data1) {
            checkCodeLength2(o);
        }
        JSONArray data2 = JsonData2.JSON_DATA;


    }

    public static void checkCodeLength2(Object o) {
        System.out.println(o);

    }

}
