// package com.xuegao.video_conver.ppt;
//
// import com.spire.presentation.FileFormat;
// import com.spire.presentation.Presentation;
//
// /**
//  * <br/> @PackageName：com.xuegao.video_conver.ppt.service
//  * <br/> @ClassName：SpirePptSplit
//  * <br/> @Description：只有一页
//  * <br/> @author：花名 xuegao
//  * <br/> @date：2020/9/10 15:03
//  */
// public class SpirePptSplit {
//     public static void main(String[] args) throws Exception {
//         Presentation presentation = new Presentation();
//         presentation.loadFromFile("d:\\user\\80004960\\桌面\\仙鹤中国风潮PPT模板.pptx");
//
//         Presentation newPptx1 = new Presentation();
//         for (int i = 0; i < 10; i++) {
//             newPptx1.getSlides().removeAt(0);
//             newPptx1.getSlides().append(presentation.getSlides().get(i));
//         }
//         newPptx1.saveToFile("F:\\file\\仙鹤中国风潮PPT模板_java_1.pptx", FileFormat.PPTX_2013);
//
//         Presentation newPptx2 = new Presentation();
//         for (int i = 10; i < 20; i++) {
//             newPptx2.getSlides().removeAt(0);
//             newPptx2.getSlides().append(presentation.getSlides().get(i));
//         }
//         newPptx2.saveToFile("F:\\file\\仙鹤中国风潮PPT模板_java_2.pptx", FileFormat.PPTX_2013);
//
//
//         Presentation newPptx3 = new Presentation();
//         for (int i = 20; i < presentation.getSlides().getCount() - 20; i++) {
//             newPptx3.getSlides().removeAt(0);
//             newPptx3.getSlides().append(presentation.getSlides().get(i));
//         }
//         newPptx3.saveToFile("F:\\file\\仙鹤中国风潮PPT模板_java_3.pptx", FileFormat.PPTX_2013);
//
//     }
// }