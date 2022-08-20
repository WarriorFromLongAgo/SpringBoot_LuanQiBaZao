package com.xuegao.luanqibazao_1.jdk8.lamada_stream.group;

import com.alibaba.fastjson.JSON;
import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @date 2021/11/25 17:58
 */
public class GroupByTest {
    public static void main(String[] args) {
        List<UserInfo> list = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId("1");
            userInfo.setName("name" + i);
            userInfo.setSex("1");
            list.add(userInfo);
        }
        for (int i = 10; i < 15; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setId("2");
            userInfo.setName("name" + i);
            userInfo.setSex("2");
            list.add(userInfo);
        }
        Map<String, List<UserInfo>> collect = list.stream().collect(Collectors.groupingBy(new Function<UserInfo, String>() {
            @Override
            public String apply(UserInfo userInfo) {
                return userInfo.getId() + "-" + userInfo.getSex();
            }
        }));
        for (Map.Entry<String, List<UserInfo>> userInfoListEntry : collect.entrySet()) {
            System.out.println(JSON.toJSONString(userInfoListEntry));
        }

        CacheInstancePO cacheInstancePO1 = new CacheInstancePO();
        // List<KeyValue> keyValueList1 = cacheInstancePO1.getKeyValueList1();
        List<KeyValue> keyValueList1 = new ArrayList<>();
        KeyValue keyValue1 = new KeyValue();
        keyValue1.setId("100329");
        keyValue1.setKey("AZ");
        keyValue1.setValue("1111");
        KeyValue keyValue2 = new KeyValue();
        keyValue2.setId("100329");
        keyValue2.setKey("AZ");
        keyValue2.setValue("1111");
        KeyValue keyValue3 = new KeyValue();
        keyValue3.setId("100329");
        keyValue3.setKey("BB");
        keyValue3.setValue("1111");
        keyValueList1.add(keyValue1);
        keyValueList1.add(keyValue2);
        keyValueList1.add(keyValue3);

        Map<String, String> map = new HashMap<>();
        for (KeyValue keyValue : keyValueList1) {
            map.put(keyValue.getKey(), keyValue.getValue());
        }
        System.out.println(map);

        KeyValue keyValue4 = keyValueList1.get(0);


        // key = 100329
        // Map<String, List<KeyValue>> stringPOMap = keyValueList1.stream().collect(Collectors.groupingBy(KeyValue::getId));
        // for (Map.Entry<String, List<KeyValue>> entry : stringPOMap.entrySet()) {
        //     String id = entry.getKey();
        //     List<KeyValue> keyValueList = entry.getValue();
        //     // key = az, bb, value = List<keyvalue>
        //     Map<String, List<KeyValue>> collect1 = keyValueList.stream().collect(Collectors.groupingBy(KeyValue::getKey));
        //     A2 a2 = new A2();
        //     List<KeyValue> azPo = collect1.get("AZ");
        //
        //     // list<Po> -> list<AzVo>
        //     List<Popup> azVoList = azPo.stream().map(new Function<KeyValue, Popup>() {
        //         @Override
        //         public Popup apply(KeyValue keyValue) {
        //             javafx.stage.Popup popup = new javafx.stage.Popup();
        //             popup.setAnchorX(keyValue.getKey());
        //             popup.setAnchorY(keyValue.getValue());
        //             return popup;
        //         }
        //     }).collect(Collectors.toList());
        //
        //     a2.setAZ(azVoList);
        //
        //     A2 a2 = new A2();
        //     List<KeyValue> bb = collect1.get("BB");
        //     a2.setBB(bb);
        // }

        Map<String, KeyValue> collect2 = keyValueList1.stream().collect(Collectors.toMap(
                new Function<KeyValue, String>() {
                    @Override
                    public String apply(KeyValue keyValue) {
                        return keyValue.getKey();
                    }
                },
                new Function<KeyValue, KeyValue>() {
                    @Override
                    public KeyValue apply(KeyValue keyValue) {
                        // 返回了一个对象，map的value就是对象
                        return keyValue;
                    }
                },
                new BinaryOperator<KeyValue>() {
                    @Override
                    public KeyValue apply(KeyValue key1, KeyValue key2) {
                        return key1;
                    }
                }
        ));

        Map<String, String> collect3 = keyValueList1.stream().collect(Collectors.toMap(
                new Function<KeyValue, String>() {
                    @Override
                    public String apply(KeyValue keyValue) {
                        return keyValue.getKey();
                    }
                },
                new Function<KeyValue, String>() {
                    @Override
                    public String apply(KeyValue keyValue) {
                        // 返回了一个对象的一个字段，map的value就是对象的这个字段
                        return keyValue.getValue();
                    }
                },
                new BinaryOperator<String>() {
                    @Override
                    public String apply(String key1, String key2) {
                        return key1;
                    }
                }
        ));

        Map<String, KeyValue> collect1 = keyValueList1.stream().collect(Collectors.toMap(KeyValue::getKey, c -> c, (key1, key2) -> key1));
        Map<String, KeyValue> collect11 = keyValueList1.stream().collect(Collectors.toMap(KeyValue::getKey, c -> c, (key1, key2) -> key1));
        Map<String, String> collect111 = keyValueList1.stream().collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue));


    }

    public static class KeyValue {

        private String id;

        private String key;

        private String value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class A2 {
        private String AZ;
        private String BB;
        private String CZ;

        public String getAZ() {
            return AZ;
        }

        public void setAZ(String AZ) {
            this.AZ = AZ;
        }

        public String getBB() {
            return BB;
        }

        public void setBB(String BB) {
            this.BB = BB;
        }

        public String getCZ() {
            return CZ;
        }

        public void setCZ(String CZ) {
            this.CZ = CZ;
        }
    }

    public static class CacheInstancePO {

        private String customerId;

        private String enterpriseId;

        private List<KeyValue> keyValueList1;

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public List<KeyValue> getKeyValueList1() {
            return keyValueList1;
        }

        public void setKeyValueList1(List<KeyValue> keyValueList1) {
            this.keyValueList1 = keyValueList1;
        }
    }
}