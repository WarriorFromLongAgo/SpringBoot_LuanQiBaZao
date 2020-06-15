package com.xuegao.design_patterns.command;

abstract class Command {
    protected Student student;

    public Command(Student student) {
        this.student = student;
    }

    abstract void execute(String name);
}