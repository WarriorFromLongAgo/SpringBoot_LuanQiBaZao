package com.xuegao.luanqibazao_1.jdk8.lang.string;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.jdk8.lang.string
 * <br/> @ClassName：StringTest
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/20 15:08
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "镇北点部、立新点部、庆丰点部、西凌点部、泖港点部、兴塔点部、张堰点部、曹行点部、春辉点部、吴泾点部、闵行北桥点部、江川点部、马桥点部、莘庄点部、惠南点部、书院点部、宣桥点部、六灶点部、鹿园点部、祝东点部、大渡河点部、丰庄点部、富平点部、遵义点部、纪王点部、徐泾点部、援干点部、白鹤点部、大盈点部、七宝点部、仓桥点部、徐汇龙华点部、平吉点部、田林点部、文化点部、徐体点部、豫园点部、南泉点部、羽山点部、北蔡点部、三林点部、孙桥点部、唐行点部";
        String[] split = s.split("、");
        System.out.println(split.length);

    }

    private static void extracted1() {
        String join = String.join("-", "a", "b");
        System.out.println(join);
    }

    private static void extracted() {
        String a = "12";
        if (StringUtils.isBlank(a)) {
            System.out.println("      aaaaaaa           ");
        } else {
            String substring = a.substring(0, a.length() - 1);
            System.out.println("substring = " + substring);
        }


        String strArr = "1,2,3";

        List<String> split = split(strArr);
        System.out.println(split);

        strArr = "";
        List<String> split1 = split(strArr);
        System.out.println(split1);

        strArr = null;
        List<String> split2 = split(strArr);
        System.out.println(split2);
    }

    private static List<String> split(String split) {
        if (StringUtils.isBlank(split)) {
            return new ArrayList<>();
        }
        return Arrays.asList(split.split(","));
    }
}