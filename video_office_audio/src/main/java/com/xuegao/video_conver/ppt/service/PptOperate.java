package com.xuegao.video_conver.ppt.service;

import org.apache.poi.hslf.usermodel.HSLFSlideShow;

import java.io.InputStream;

/**
 * @ClassName PptOperate
 * @Author Baird Li
 * @Date 2019-09-03 13:51
 **/
public class PptOperate extends ApachePoiHandle {

    public PptOperate(InputStream inputStream)throws Exception{
        super(new HSLFSlideShow(inputStream));
    }

}
