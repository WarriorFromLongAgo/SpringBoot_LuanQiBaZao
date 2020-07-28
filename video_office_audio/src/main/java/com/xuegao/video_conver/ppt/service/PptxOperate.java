package com.xuegao.video_conver.ppt.service;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.InputStream;

/**
 * @ClassName PptxOperate
 * @Description TODO
 * @Author Baird Li
 * @Date 2019-09-03 15:17
 **/
public class PptxOperate extends ApachePoiHandle {

    public PptxOperate(InputStream inputStream)throws Exception{
        super(new XMLSlideShow(inputStream));
    }

}
