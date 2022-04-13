package com.xuegao.luanqibazao_1.jdk8.lang.cloneable;

import com.google.common.collect.Lists;
import com.xuegao.luanqibazao_1.domain.CopyTest;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/3/11 12:20
 */
public class 深浅拷贝 {
    public static void main(String[] args) {
        CopyTest copyTest = new CopyTest();
        copyTest.setName("xuegao");
        copyTest.setAge(18);
        copyTest.setList(Lists.newArrayList("男", "女"));

        if(ObjectUtils.isEmpty(copyTest)){

        }

        CopyTest copyTest2 = copyTest.clone();

    }
}