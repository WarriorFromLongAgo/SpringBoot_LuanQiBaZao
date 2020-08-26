package com.xuegao.video_conver;

/**
 * <br/> @PackageName：com.xuegao.video_conver
 * <br/> @ClassName：asjkda
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/26 17:00
 */
public class stringDeal {
    public static void main(String[] args) {
        sh();
    }

    private static void sh() {
        String path = "D:\\nfsc\\KMS\\train.homework\\001\\598\\432\\359\\560\\052ab303-33bd-487d-bba0-bd1eb8bfa6de.ppt";
        int i = path.indexOf("train.homework");
        System.out.println(i);
        String substring = path.substring(i);
        System.out.println(substring);

        String substring1 = path.substring(path.indexOf("train.homework"));
        System.out.println(substring1);
    }
}