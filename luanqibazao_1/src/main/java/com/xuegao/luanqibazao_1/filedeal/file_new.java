package com.xuegao.luanqibazao_1.filedeal;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.filedeal
 * <br/> @ClassName：file_new
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/14 19:18
 */
public class file_new {
    public static void main(String[] args) {
        List<String> configTypeList = new ArrayList<>();
        configTypeList.add("1");
        configTypeList.add("2");
        configTypeList.add("3");
        StringBuilder stringBuilder = new StringBuilder();
        for (String configValueType : configTypeList) {
            stringBuilder.append(configValueType).append(",");
        }
        String typeStr = stringBuilder.toString();
        String substring = typeStr.substring(0, typeStr.length() - 1);
        System.out.println(substring);
    }
}