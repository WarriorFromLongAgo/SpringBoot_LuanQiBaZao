package com.xuegao.luanqibazao_1.utils.auto_incr;

/**
 * <br/> @PackageName：com.xuegao.video_conver.audio
 * <br/> @ClassName：AutoIncrmentTest
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 14:03
 */
public class AutoIncrmentTest {
    public static void main(String[] args) {
        long l = IdUtil.nextId();
        System.out.println(l);
        System.out.println(String.valueOf(l).length());
        System.out.println(String.valueOf(Integer.MAX_VALUE).length());
    }
}