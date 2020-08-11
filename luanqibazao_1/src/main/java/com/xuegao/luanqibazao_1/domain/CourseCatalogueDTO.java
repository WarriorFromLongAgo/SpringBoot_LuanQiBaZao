package com.xuegao.luanqibazao_1.domain;

import java.io.Serializable;

/**
 * <br/> @PackageName：com.sf.module.train.domain.dto
 * <br/> @ClassName：CourseCatalogueDTO
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/1 16:19
 */
public class CourseCatalogueDTO implements Serializable {

    private Long id;
    // 课程ID
    private Long coursesId;

    // 这里不是 课件ID
    // 是 音视频id
    private Long coursewareId;
    // 课件id PPTid
    private Long teachingMaterialId;
    // 图文
    private String content;

    public CourseCatalogueDTO() {
    }

    @Override
    public String toString() {
        return "CourseCatalogueDTO {" +
                "id=" + id +
                ", coursesId=" + coursesId +
                ", coursewareId=" + coursewareId +
                ", teachingMaterialId=" + teachingMaterialId +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(Long coursesId) {
        this.coursesId = coursesId;
    }

    public Long getCoursewareId() {
        return coursewareId;
    }

    public void setCoursewareId(Long coursewareId) {
        this.coursewareId = coursewareId;
    }

    public Long getTeachingMaterialId() {
        return teachingMaterialId;
    }

    public void setTeachingMaterialId(Long teachingMaterialId) {
        this.teachingMaterialId = teachingMaterialId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}