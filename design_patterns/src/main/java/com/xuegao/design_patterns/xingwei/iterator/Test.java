package com.xuegao.design_patterns.xingwei.iterator;

import com.xuegao.design_patterns.domain.Student;

public class Test {
    public static void main(String[] args) {
        StudentAggregate classOne = new StudentAggregateImpl();
        classOne.addStudent(new Student("张三", 1));
        classOne.addStudent(new Student("李四", 2));
        classOne.addStudent(new Student("王五", 3));
        classOne.addStudent(new Student("赵六", 4));

        // 遍历，报数
        StudentIterator iterator = classOne.getStudentIterator();
        while (iterator.hashNext()){
            Student student = iterator.next();
            student.count();
        }
    }
}
