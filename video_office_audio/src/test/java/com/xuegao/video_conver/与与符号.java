package com.xuegao.video_conver;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.core.Is;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * <br/> @PackageName：com.xuegao.video_conver
 * <br/> @ClassName：与与符号
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/1 16:02
 */
public class 与与符号 {

    private static boolean isEmpty(Object obj) {
        System.out.println("isempty");
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

    public static void main(String[] args) {
        String aaaa = "";
        String bbbb = "adjakdklad";
        // 测试a 为空 b 是否会进行测试 会
        if (StringUtils.isBlank(aaaa) && isEmpty(bbbb)) {
            System.out.println(" a 为 空，b 不为空 不会进里面");
            System.out.println("测试a 为空 b 是否会进行测试 会");
        }
        aaaa = "";
        bbbb = "";
        if (StringUtils.isBlank(aaaa) && StringUtils.isBlank(bbbb)) {
            System.out.println("都为空");
        }
        aaaa = "啊啊";
        bbbb = "版本";
        if (!(StringUtils.isBlank(aaaa) && StringUtils.isBlank(bbbb))) {
            System.out.println("都不为空");
        }


    }
}