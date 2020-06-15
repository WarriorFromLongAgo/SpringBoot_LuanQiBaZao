package com.xuegao.design_patterns.command;

public class WangTeacher extends Command {

    public WangTeacher(Student student) {
        super(student);
    }

    @Override
    void execute(String name) {
        student.doHomeWork(name);
    }
}