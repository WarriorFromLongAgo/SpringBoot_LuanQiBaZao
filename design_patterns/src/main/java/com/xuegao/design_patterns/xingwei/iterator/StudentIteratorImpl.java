package com.xuegao.design_patterns.xingwei.iterator;

import com.xuegao.design_patterns.domain.Student;

import java.util.List;

public class StudentIteratorImpl implements StudentIterator {
    private List<Student> list;
    private int position = 0;
    private Student currentStudent;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hashNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        currentStudent = list.get(position);
        position++;
        return currentStudent;
    }
}

