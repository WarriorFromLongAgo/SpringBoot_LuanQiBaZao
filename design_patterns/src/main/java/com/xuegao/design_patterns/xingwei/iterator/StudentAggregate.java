package com.xuegao.design_patterns.xingwei.iterator;

import com.xuegao.design_patterns.domain.Student;

public interface StudentAggregate {
    void addStudent(Student student);

    void removeStudent(Student student);

    StudentIterator getStudentIterator();
}
