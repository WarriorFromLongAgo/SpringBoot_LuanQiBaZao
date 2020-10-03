// package com.xuegao.video_conver.ppt;
//
// import com.spire.presentation.Presentation;
//
// import javax.imageio.ImageIO;
// import java.awt.image.BufferedImage;
// import java.io.File;
//
// /**
//  * <br/> @PackageName：com.xuegao.video_conver.ppt
//  * <br/> @ClassName：SpirePPt
//  * <br/> @Description：
//  * <br/> @author：花名 xuegao
//  * <br/> @date：2020/8/31 20:13
//  */
// public class SpirePPt1 {
//     public static void main(String[] args) throws Exception {
//         //创建Presentation对象
//         Presentation ppt = new Presentation();
//         //加载示例文档
//         ppt.loadFromFile("d:\\user\\80004960\\桌面\\1.pptx");
//         //遍历幻灯片
//         for (int i = 0; i < ppt.getSlides().getCount(); i++) {
//             //将幻灯片保存为BufferedImage对象
//             BufferedImage image = ppt.getSlides().get(i).saveAsImage();
//             //将BufferedImage保存为PNG格式文件
//             String fileName = "F:\\file\\" + System.currentTimeMillis() + ".png";
//             ImageIO.write(image, "PNG", new File(fileName));
//         }
//         ppt.dispose();
//
//         //创建Presentation对象
//         Presentation ppt2 = new Presentation();
//         //加载示例文档
//         ppt2.loadFromFile("d:\\user\\80004960\\桌面\\2.pptx");
//         //遍历幻灯片
//         for (int i = 0; i < ppt2.getSlides().getCount(); i++) {
//             //将幻灯片保存为BufferedImage对象
//             BufferedImage image = ppt2.getSlides().get(i).saveAsImage();
//             //将BufferedImage保存为PNG格式文件
//             String fileName = "F:\\file\\" + System.currentTimeMillis() + ".png";
//             ImageIO.write(image, "PNG", new File(fileName));
//         }
//         ppt2.dispose();
//
//     }
// }