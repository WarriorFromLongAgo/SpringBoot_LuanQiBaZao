package com.xuegao.luanqibazao_1.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JackSonTest {

    private Integer id;

    private String month;
    @JsonIgnore
    private Integer customerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
