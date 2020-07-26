package com.xuegao.design_patterns.adapter;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.adapter
 * <br/> @ClassName：ObjectAdapterPattern
 * <br/> @Description：适配器设计模式
 * <br/> @author：xuegao
 * <br/> @date：2020/6/26 18:44
 */
public class ObjectAdapterPattern {
    public static void main(String[] args) {

        Rvmb rvmb = new FormatFactory2(new VideoPlayer());
        rvmb.playRvmb();

    }
}

class FormatFactory2 implements Rvmb {
    private Mp4 mp4;

    public FormatFactory2(Mp4 mp4) {
        this.mp4 = mp4;
    }

    @Override
    public void playRvmb() {
        mp4.playMp4();
    }
}