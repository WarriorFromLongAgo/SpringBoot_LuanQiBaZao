// package com.xuegao.video_conver.ppt;
//
// import com.spire.presentation.FileFormat;
// import com.spire.presentation.Presentation;
//
// /**
//  * <br/> @PackageName：com.xuegao.video_conver.ppt
//  * <br/> @ClassName：SpirePPt
//  * <br/> @Description：
//  * <br/> @author：花名 xuegao
//  * <br/> @date：2020/8/31 20:13
//  */
// public class SpirePpt3 {
//     public static void main(String[] args) throws Exception {
//         //创建Presentation对象
//         Presentation ppt = new Presentation();
//
//         //加载PPTX文档
//         ppt.loadFromFile("C:/Users/Administrator/Desktop/example.pptx");
//
//         //保存为PPT文档
//         ppt.saveToFile("output/ToPPT.ppt",FileFormat.PPT);
//
//         //PPT转PPTX
//         //ppt.loadFromFile("C:/Users/Administrator/Desktop/example.ppt");
//         //ppt.saveToFile("output/ToPPTX.pptx",FileFormat.PPTX_2013);
//
//         ppt.dispose();
//     }
// }