package com.xuegao.design_patterns.command;

public class LiTeacher extends Command {

    public LiTeacher(Student student) {
        super(student);
    }

    @Override
    void execute(String name) {
        student.cleanClassRoom(name);
    }
}
