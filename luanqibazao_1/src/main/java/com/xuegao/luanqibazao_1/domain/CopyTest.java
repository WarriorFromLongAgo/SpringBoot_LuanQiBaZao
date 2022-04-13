package com.xuegao.luanqibazao_1.domain;

import java.util.List;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/3/11 12:21
 */
public class CopyTest implements Cloneable {

    private String name;

    private Integer age;

    private List<String> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public CopyTest clone() {
        try {
            return (CopyTest) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}