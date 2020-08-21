package com.xuegao.luanqibazao_1;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：string_sub
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/13 11:37
 */
public class string_sub {
    public static void main(String[] args) {
        String sql = "ajkdh,jjjjjjjjjj,";
        String substring = sql.substring(0, sql.length() - 1);
        System.out.println(substring);
    }
}