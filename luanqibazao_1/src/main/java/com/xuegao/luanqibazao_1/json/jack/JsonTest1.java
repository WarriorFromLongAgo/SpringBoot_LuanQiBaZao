package com.xuegao.luanqibazao_1.json.jack;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuegao.luanqibazao_1.domain.JackSonTest;

public class JsonTest1 {
    // 不是所有的字段都支持序列化和反序列化，需要符合以下规则：
    // 如果字段的修饰符是 public，则该字段可序列化和反序列化（不是标准写法）。
    // 如果字段的修饰符不是 public，但是它的 getter 方法和 setter 方法是 public，则该字段可序列化和反序列化。
    // getter 方法用于序列化，setter 方法用于反序列化。
    // 如果字段只有 public 的 setter 方法，而无 public 的 getter 方 法，则该字段只能用于反序列化。
    // 如果反序列化的对象有带参的构造方法，它必须有一个空的默认构造方法，否则将会抛出 InvalidDefinitionException 一行。

    public static void main(String[] args) throws JsonProcessingException {
        JackSonTest jackSonTest = new JackSonTest();
        jackSonTest.setId(1);
        jackSonTest.setCustomerId(2);
        jackSonTest.setMonth("2020-01");

        ObjectMapper mapper = new ObjectMapper();
        String jsonString1 = mapper.writeValueAsString(jackSonTest);
        System.out.println(jsonString1);
        System.out.println("========================================");
        String jsonString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jackSonTest);
        System.out.println(jsonString2);

        JackSonTest jackSonTest1 = mapper.readValue(jsonString1, JackSonTest.class);
        System.out.println(mapper.writeValueAsString(jackSonTest1));
        JackSonTest jackSonTest2 = mapper.readValue(jsonString2, JackSonTest.class);
        System.out.println(mapper.writeValueAsString(jackSonTest2));
    }

    // 在 getter 上使用 @JsonFormat 注解。
    // GMT+8 是指格林尼治的标准时间，在加上八个小时表示你现在所在时区的时间
    // @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    // 可以通过 configure() 方法忽略掉这些“无法识别”的字段。
    // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    // 在序列化时忽略值为 null 的属性
// mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
// 忽略值为默认值的属性
// mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);

    // @JsonIgnore
    // 单个字段过滤
    // @JsonIgnoreProperties(value = { "age","birthday" })
    // class Writer{
    // 多个字段过滤
}
