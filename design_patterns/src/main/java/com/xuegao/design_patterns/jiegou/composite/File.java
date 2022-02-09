package com.xuegao.design_patterns.jiegou.composite;

public class File extends Component {
    private String name;
    private String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.getName());
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
