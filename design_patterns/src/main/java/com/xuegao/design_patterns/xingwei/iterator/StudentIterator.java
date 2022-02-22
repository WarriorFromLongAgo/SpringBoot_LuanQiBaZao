package com.xuegao.design_patterns.xingwei.iterator;

import com.xuegao.design_patterns.domain.Student;

public interface StudentIterator {
    boolean hashNext();
    Student next();
}