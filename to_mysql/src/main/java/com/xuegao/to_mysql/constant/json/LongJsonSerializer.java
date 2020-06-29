package com.xuegao.to_mysql.constant.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * <br/> @PackageName：com.fff.springbootapiseedtest.constant.json
 * <br/> @ClassName：LongJsonSerializer
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/4/6 21:48
 */
public class LongJsonSerializer extends JsonSerializer<Long> {

    @Override
    public void serialize(Long value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        LocalDateTime localDateTime = Instant.ofEpochMilli(value).atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
        System.out.println(localDateTime);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDate = format.format(localDateTime);
        jgen.writeString(formattedDate);
    }

}