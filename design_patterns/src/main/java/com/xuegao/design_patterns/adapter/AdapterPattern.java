package com.xuegao.design_patterns.adapter;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.adapter
 * <br/> @ClassName：AdapterPattern
 * <br/> @Description：适配器设计模式
 * <br/> @author：feijm
 * <br/> @date：2020/6/26 18:43
 */
public class AdapterPattern {
    public static void main(String[] args) {
        Mp4 mp4 = new VideoPlayer();
        mp4.playMp4();
        Avi avi = new FormatFactory();
        avi.playAvi();
    }
}

interface Mp4 {
    void playMp4();
}

interface Avi {
    void playAvi();
}

interface Rvmb {
    void playRvmb();
}

class VideoPlayer implements Mp4 {

    @Override
    public void playMp4() {
        System.out.println("播放Mp4格式的视频文件.");
    }
}

class FormatFactory extends VideoPlayer implements Avi {
    @Override
    public void playAvi() {
        //转换成MP4格式的视频
        playMp4();
    }
}


