package com.xuegao.video_conver.ppt.seccoding.ppt;

import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.sl.usermodel.SlideShow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PPT {

	public SlideShow getSlideShow(File pptFile) {
		try {
			return new HSLFSlideShow(new FileInputStream(pptFile));
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
