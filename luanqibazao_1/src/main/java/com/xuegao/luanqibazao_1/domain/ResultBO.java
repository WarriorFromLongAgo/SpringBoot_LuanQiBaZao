package com.xuegao.luanqibazao_1.domain;

import java.io.Serializable;

/**
 * <br/> @PackageName：com.sf.module.train.domain.dto
 * <br/> @ClassName：PptServerResult
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/9/2 10:24
 */
public class ResultBO implements Serializable {

    private static final long serialVersionUID = -1492311823609198597L;
    private String status;
    private String fileType;
    private String flag;
    private String container;
    private String fileName;
    private String json;
    private String htmlWidth;

    public ResultBO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getHtmlWidth() {
        return htmlWidth;
    }

    public void setHtmlWidth(String htmlWidth) {
        this.htmlWidth = htmlWidth;
    }
}