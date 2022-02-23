package com.xuegao.video_conver.jxls;

import java.util.ArrayList;
import java.util.List;

public class Grade {

    private String name;
    private List<Student> studentList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}