package com.xuegao.video_conver.ppt.seccoding.ppt;

import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PPTX {

	public SlideShow getSlideShow(File pptFile) {
		try {
			return new XMLSlideShow(new FileInputStream(pptFile));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
