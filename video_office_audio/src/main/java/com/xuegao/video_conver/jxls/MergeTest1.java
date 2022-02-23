package com.xuegao.video_conver.jxls;

import java.util.ArrayList;
import java.util.List;

public class MergeTest1 {

    public static void main(String[] args) {
        //模拟10条学生信息
        Grade grade1 = new Grade();
        grade1.setName("1年级");
        grade1.getStudentList().add(new Student("小明", "男", "9", "1年级"));
        grade1.getStudentList().add(new Student("小天", "男", "9", "1年级"));
        grade1.getStudentList().add(new Student("小妮", "女", "10", "1年级"));
        grade1.getStudentList().add(new Student("小友", "女", "10", "1年级"));
        grade1.getStudentList().add(new Student("小空", "男", "10", "1年级"));

        Grade grade2 = new Grade();
        grade2.setName("2年级");
        grade2.getStudentList().add(new Student("小马", "男", "11", "2年级"));
        grade2.getStudentList().add(new Student("小易", "女", "11", "2年级"));
        grade2.getStudentList().add(new Student("小启", "女", "11", "2年级"));
        grade2.getStudentList().add(new Student("小曲", "女", "12", "2年级"));
        grade2.getStudentList().add(new Student("小浪", "男", "12", "2年级"));

        List<Grade> gradeList = new ArrayList<>();
        gradeList.add(grade1);
        gradeList.add(grade2);

        for (Grade grade : gradeList) {
            System.out.println("班级：" + grade.getName());
            System.out.println("班级：" + grade.getStudentList());


        }


    }
}
// ————————————————
// 版权声明：本文为CSDN博主「David.Huang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/hezudao0324/article/details/103635959