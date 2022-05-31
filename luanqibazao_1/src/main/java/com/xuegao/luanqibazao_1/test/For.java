package com.xuegao.luanqibazao_1.test;

import com.alibaba.fastjson.JSON;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class For {
    public static final Map<Integer, List<TempEnum2>> DEFAULT_VIEW = new HashMap<Integer, List<TempEnum2>>() {
        private static final long serialVersionUID = -4318860703552426339L;
        {
            put(1, Collections.singletonList(TempEnum2.ADDRESS));
            put(2, Collections.singletonList(TempEnum2.ADDRESS));
            put(3, Collections.singletonList(TempEnum2.URL));
        }
    };
    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(DEFAULT_VIEW));
    }
}
enum TempEnum2 {
    ADDRESS(""),
    URL("");
    private String pptFromDetail;
    TempEnum2(String pptFromDetail) {
        this.pptFromDetail = pptFromDetail;
    }
}
