package com.xuegao.luanqibazao_1;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：filename
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/3 17:23
 */
public class filename {
    public static void main(String[] args) {
        String filename = "akdjkaldas.ppt";
        String getsuffix = getsuffix(filename);
        System.out.println(getsuffix);
    }

    private static String getsuffix(String fileName) {
        String substring = fileName.substring(fileName.lastIndexOf(".") + 1);
        return substring;
    }
}