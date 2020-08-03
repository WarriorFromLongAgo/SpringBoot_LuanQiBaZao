package com.xuegao.video_conver.ppt.seccoding.ppt;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        Converter converter = new Converter("F:\\file\\");
        Converter.Result result = converter.convert(
                new File("d:\\user\\xuegao\\桌面\\MySQL体系结构.ppt"), "Output Path Dir", "png"
        );

        System.out.println(result.getFileName());
        System.out.println(result.getOutputFolder());
        System.out.println(result.getPageSize());
        System.out.println(result.getOriginalFilePath());
    }

}
