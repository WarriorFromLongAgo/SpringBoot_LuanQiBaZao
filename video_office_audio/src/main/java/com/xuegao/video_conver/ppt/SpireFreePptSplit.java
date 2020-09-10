package com.xuegao.video_conver.ppt;

import com.spire.presentation.FileFormat;
import com.spire.presentation.Presentation;

/**
 * <br/> @PackageName：com.xuegao.video_conver.ppt
 * <br/> @ClassName：SpireFreePptSplit
 * <br/> @Description：
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/9/10 15:59
 */
public class SpireFreePptSplit {
    public static void main(String[] args) throws Exception {
        Presentation presentation = new Presentation();
        presentation.loadFromFile("d:\\user\\80004960\\桌面\\仙鹤中国风潮PPT模板.pptx");
        long startTime = System.currentTimeMillis();
        Presentation newPptx1 = new Presentation();
        newPptx1.getSlides().removeAt(0);
        for (int i = 0; i < 10; i++) {
            newPptx1.getSlides().append(presentation.getSlides().get(i));
        }
        newPptx1.saveToFile("F:\\file\\仙鹤中国风潮PPT模板_java_1.pptx", FileFormat.PPTX_2013);

    }
}