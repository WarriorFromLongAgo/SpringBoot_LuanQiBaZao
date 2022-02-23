package com.xuegao.video_conver.jxls;

public class Student {

    private String name;
    private String sex;
    private String age;
    private String grade;

    public Student(String name, String sex, String age, String grade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
// ————————————————
// 版权声明：本文为CSDN博主「David.Huang」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
// 原文链接：https://blog.csdn.net/hezudao0324/article/details/103635959