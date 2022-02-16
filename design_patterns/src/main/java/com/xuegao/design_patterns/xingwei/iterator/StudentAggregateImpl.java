package com.xuegao.design_patterns.xingwei.iterator;

import com.xuegao.design_patterns.domain.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAggregateImpl implements StudentAggregate {
    private List<Student> list;  // 学生列表

    public StudentAggregateImpl() {
        this.list = new ArrayList<Student>();
    }

    @Override
    public void addStudent(Student student) {
        this.list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        this.list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}

