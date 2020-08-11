package com.xuegao.luanqibazao_1;

import com.alibaba.fastjson.JSONObject;
import com.xuegao.luanqibazao_1.domain.CoursesDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：objectToJson
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/5 16:33
 */
public class objectToJson {
    public static void main(String[] args) {
        CoursesDTO coursesDTO = new CoursesDTO();
        String s = JSONObject.toJSONString(coursesDTO);
        System.out.println(s);

        List<String> stringList = new ArrayList<>();
        stringList.add("aa");
        stringList.add("bb");
        stringList.add("cc");
        stringList.add("dd");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            if (i < stringList.size() - 1) {
                stringBuilder.append(stringList.get(i)).append(", ");
                continue;
            }
            stringBuilder.append(stringList.get(i));
        }

        String s1 = stringBuilder.toString();
        System.out.println(s1);
    }
}