package com.xuegao.luanqibazao_1.ifelse;

import com.alibaba.fastjson.JSONObject;
import com.xuegao.luanqibazao_1.domain.CourseCatalogueDTO;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.ifelse.ifelse
 * <br/> @ClassName：Bean_If_Else
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/10 13:58
 */
public class Bean_If_Else {
    public static void main(String[] args) {

        // CourseCatalogueDTO courseCatalogueDTO = JSONObject.parseObject("{\n" +
        //         "    \"id\": \"\",\n" +
        //         "    \"coursesId\": \"616\",\n" +
        //         "    \"coursewareId\": \"443\",\n" +
        //         "    \"teachingMaterialId\": \"356\",\n" +
        //         "    \"content\": \"\"\n" +
        //         "}", CourseCatalogueDTO.class);

        CourseCatalogueDTO courseCatalogueDTO = JSONObject.parseObject("{\n" +
                "    \"id\": \"\",\n" +
                "    \"coursesId\": \"616\",\n" +
                "    \"coursewareId\": \"443\",\n" +
                "    \"teachingMaterialId\": \"\",\n" +
                "    \"content\": \"\"\n" +
                "}", CourseCatalogueDTO.class);

        // 检测输入信息
        if (isEmpty(courseCatalogueDTO.getCoursesId())) {
            throw new RuntimeException("请指定需要修改的课程id");
        }
        System.out.println(courseCatalogueDTO);
        if (isEmpty(courseCatalogueDTO.getCoursewareId())) {
            throw new RuntimeException("请指定需要修改的多媒体id");
        }

        boolean empty = isEmpty(courseCatalogueDTO.getTeachingMaterialId());
        System.out.println(empty);
        boolean blank = StringUtils.isBlank(courseCatalogueDTO.getContent());
        System.out.println(blank);

        // if (!(empty && blank)) {
        //     throw new RuntimeException("输入异常信息，不能同时处理课件和图文信息111111111");
        // }
        if (!isEmpty(courseCatalogueDTO.getTeachingMaterialId()) && StringUtils.isNotBlank(courseCatalogueDTO.getContent())) {
            throw new RuntimeException("输入异常信息，不能同时处理课件和图文信息222222222");
        }
        if (isEmpty(courseCatalogueDTO.getTeachingMaterialId()) && StringUtils.isBlank(courseCatalogueDTO.getContent())) {
            throw new RuntimeException("输入异常信息，课件和图文信息不能同时为空");
        }

    }

    private static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }

        // else
        return false;
    }
}