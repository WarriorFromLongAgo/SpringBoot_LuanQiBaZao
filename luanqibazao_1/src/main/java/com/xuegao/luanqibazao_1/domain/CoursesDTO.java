package com.xuegao.luanqibazao_1.domain;

import java.io.Serializable;
import java.util.List;

public class CoursesDTO implements Serializable {

    private static final long serialVersionUID = 3743128633653821798L;
    // id
    private Long id;

    // 课程封面
    private String coverImage;

    // 课程名称
    private String name;

    // 归属组织
    private String organization;

    // 课程编码
    private String code;

    // 类型： 1 面授， 2 在线， 3 混合
    private Integer type;

    // 是否公开： 0否 ， 1是
    private Integer isOpen;

    // 删除标识， 0否， 1是
    private Integer deleteFlag;

    // 1.草稿 2.发布 3.取消发布
    private Integer status;

    // 课程开发人 姓名
    private String courseDeveloperName;

    // 课程来源 id 名称  0 内部 1 外部
    private String coursesSourceId;

    // 课程来源
    private String coursesSourceName;

    // 创建人工号
    private String createrId;

    // 创建人姓名
    private String createrName;

    // 机密类型
    private String secretTypeId;

    // 职称等级 职级
    private String titleLevel;

    // 课程简介
    private String describe;

    // 讲师
    private String lecturerName;

    // 能力项————标签
    private List<String> capable;
    // 推荐范围————标签
    private List<String> recommendedRange;
    // 发布范围
    private List<String> publishScope;

    public CoursesDTO() {
    }

    @Override
    public String toString() {
        return "CoursesDTO {" +
                "id=" + id +
                ", coverImage='" + coverImage + '\'' +
                ", name='" + name + '\'' +
                ", organization='" + organization + '\'' +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", isOpen=" + isOpen +
                ", deleteFlag=" + deleteFlag +
                ", status=" + status +
                ", courseDeveloperName='" + courseDeveloperName + '\'' +
                ", coursesSourceId='" + coursesSourceId + '\'' +
                ", coursesSourceName='" + coursesSourceName + '\'' +
                ", createrId='" + createrId + '\'' +
                ", createrName='" + createrName + '\'' +
                ", secretTypeId='" + secretTypeId + '\'' +
                ", titleLevel='" + titleLevel + '\'' +
                ", describe='" + describe + '\'' +
                ", lecturerName='" + lecturerName + '\'' +
                ", capable=" + capable +
                ", recommendedRange=" + recommendedRange +
                ", publishScope=" + publishScope +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCourseDeveloperName() {
        return courseDeveloperName;
    }

    public void setCourseDeveloperName(String courseDeveloperName) {
        this.courseDeveloperName = courseDeveloperName;
    }

    public String getCoursesSourceId() {
        return coursesSourceId;
    }

    public void setCoursesSourceId(String coursesSourceId) {
        this.coursesSourceId = coursesSourceId;
    }

    public String getCoursesSourceName() {
        return coursesSourceName;
    }

    public void setCoursesSourceName(String coursesSourceName) {
        this.coursesSourceName = coursesSourceName;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public String getSecretTypeId() {
        return secretTypeId;
    }

    public void setSecretTypeId(String secretTypeId) {
        this.secretTypeId = secretTypeId;
    }

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public List<String> getCapable() {
        return capable;
    }

    public void setCapable(List<String> capable) {
        this.capable = capable;
    }

    public List<String> getRecommendedRange() {
        return recommendedRange;
    }

    public void setRecommendedRange(List<String> recommendedRange) {
        this.recommendedRange = recommendedRange;
    }

    public List<String> getPublishScope() {
        return publishScope;
    }

    public void setPublishScope(List<String> publishScope) {
        this.publishScope = publishScope;
    }
}