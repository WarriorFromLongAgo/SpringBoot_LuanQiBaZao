package com.xuegao.video_conver.ppt;

import com.aspose.slides.Presentation;
import com.aspose.slides.SaveFormat;

/**
 * <br/> @PackageName：com.xuegao.video_conver.ppt
 * <br/> @ClassName：AsposeSlides
 * <br/> @Description：pdf
 * <br/> @author：花名 xuegao
 * <br/> @date：2020/8/31 19:43
 */
public class AsposeSlides {
    public static void main(String[] args) {
        Presentation pres = new Presentation("d:\\user\\80004960\\桌面\\仙鹤中国风潮PPT模板.pptx");
        pres.save("F:\\file\\" + System.currentTimeMillis() + ".pdf", SaveFormat.Pdf);

        // ppt 转 图片
        // PPT 转 PDF
    }
}