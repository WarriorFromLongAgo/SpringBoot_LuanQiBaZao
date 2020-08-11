package com.xuegao.video_conver;

import java.util.Arrays;

/**
 * <br/> @PackageName：com.xuegao.video_conver
 * <br/> @ClassName：tostring
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/5 11:06
 */
public class tostring {
    public static void main(String[] args) {

        String sajh = sajh("1", "2", "3");
        // String sajh = sajh();
        System.out.println(sajh);
        String substring = sajh.substring(1, sajh.length() - 1);
        System.out.println("substring" + substring);
    }

    public static String sajh(String... type) {
        String s = Arrays.toString(type);
        String substring = s.substring(1, s.length() - 1);
        return substring;
    }


}