package com.xuegao.design_patterns.command;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.command
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 18:08
 */
public class CommandPattern {
    public static void main(String[] args) {
        String name = "xuwujing";
        Student student = new Student();
        Command command1 = new LiTeacher(student);
        Command command2 = new WangTeacher(student);
        Invoker invoker = new Invoker();
        invoker.setCommand(command1);
        invoker.setCommand(command2);
        invoker.executeCommand(name);
    }
}