// package com.xuegao.design_patterns.jiegou.facade.tea;
//
// /**
//  * 张三、李四各自泡茶喝，各自都需要准备茶具、茶叶、水，各自还要完成烧水、泡茶等操作
//  *
//  * @author xuegao
//  * @version 1.0
//  * @date 2022/2/4 23:48
//  */
// public class Main1 {
//     public static void main(String[] args) {
//         Man zhangsan = new Man("张三");
//         KettleService kettleService1 = new KettleService();
//         TeasetService teasetService1 = new TeasetService();
//         Water water1 = new Water();
//         TeaLeaf teaLeaf1 = new TeaLeaf("西湖龙井");
//         kettleService1.waterBurning(zhangsan.getName(), water1, 4);
//         Teawater teawater1 = teasetService1.makeTeaWater(zhangsan.getName(), water1, teaLeaf1);
//         zhangsan.drink(teawater1);
//         System.out.println();
//
//         Man lisi = new Man("李四");
//         KettleService kettleService2 = new KettleService();
//         TeasetService teasetService2 = new TeasetService();
//         Water water2 = new Water(10, 15);
//         TeaLeaf teaLeaf2 = new TeaLeaf("碧螺春");
//         kettleService2.waterBurning(lisi.getName(), water2, 4);
//         Teawater teawater2 = teasetService2.makeTeaWater(lisi.getName(), water2, teaLeaf2);
//         lisi.drink(teawater2);
//     }
// }