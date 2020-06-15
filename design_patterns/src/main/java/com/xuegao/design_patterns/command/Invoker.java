package com.xuegao.design_patterns.command;

import java.util.ArrayList;
import java.util.List;

class Invoker {
    private List<Command> commands = new ArrayList<Command>();

    public void setCommand(Command command) {
        if (commands.size() > 0) {
            System.out.println("不执行 WangTeacher 的命令!");
        } else {
            commands.add(command);
        }
    }

    public void executeCommand(String name) {
        commands.forEach(command -> {
            command.execute(name);
        });
    }

    public void undoCommand(Command command) {
        commands.remove(command);
        System.out.println("撤销该命令!");
    }
}