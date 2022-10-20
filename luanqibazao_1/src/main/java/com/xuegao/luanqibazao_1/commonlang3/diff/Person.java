package com.xuegao.luanqibazao_1.commonlang3.diff;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Person implements Diffable<Person> {

    private static final Logger log = LoggerFactory.getLogger(Person.class);

    String name;
    int age;
    boolean smoker;

    @Override
    public DiffResult<Person> diff(Person obj) {
        // No need for null check, as NullPointerException correct if obj is null
        return new DiffBuilder<>(this, obj, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("name", this.name, obj.name)
                .append("age", this.age, obj.age)
                .append("smoker", this.smoker, obj.smoker)
                .build();
    }

    public static void main(String[] args) {
        Person a = new Person();
        a.name = "deniro";
        a.age = 21;
        a.smoker = false;

        Person b = new Person();
        b.name = "jack";
        b.age = 22;
        b.smoker = true;

        DiffResult<Person> result = a.diff(b);
        log.info("result -> {}。", result);
    }
}

