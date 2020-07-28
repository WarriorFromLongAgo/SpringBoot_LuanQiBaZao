package com.xuegao.video_conver.ppt.seccoding.ppt;

import org.apache.poi.sl.usermodel.SlideShow;

import java.io.File;

public class SlideShowFactory {

	public static SlideShow getSlideShow(File pptFile) {
		
		String fileName = pptFile.getName();
		if ( fileName.toLowerCase().endsWith(".ppt") ) {
			return new PPT().getSlideShow(pptFile);
		}
		else if ( fileName.toLowerCase().endsWith(".pptx") ) {
			return new PPTX().getSlideShow(pptFile);
		}
		
		throw new RuntimeException("PowerPoint 파일이 아닙니다.");
		
	}
	
}
