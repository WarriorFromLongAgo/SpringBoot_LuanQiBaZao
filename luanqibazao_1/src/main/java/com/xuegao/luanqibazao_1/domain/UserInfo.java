package com.xuegao.luanqibazao_1.domain;

import java.io.Serializable;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.domain
 * <br/> @ClassName：UserInfo
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 14:28
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -3924560697306128600L;

    private String id;
    private String name;
    private Integer age;
    private String address;
    private String sex;

    private String beginTime;

    private String endTime;

    private Integer index;

    private String cardId;

    public UserInfo() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}