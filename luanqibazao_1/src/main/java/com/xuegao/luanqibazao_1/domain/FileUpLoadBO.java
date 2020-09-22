package com.xuegao.luanqibazao_1.domain;

import java.io.Serializable;

/**
 * <br/> @PackageName：com.sf.module.train.domain.bo
 * <br/> @ClassName：FileUpLoadBO
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/9/21 20:12
 */
public class FileUpLoadBO implements Serializable {
    private static final long serialVersionUID = 3912555189337092655L;

    private String status;
    private String fileType;
    private String flag;
    private String container;
    private String fileName;
    private String json;
    private Integer htmlWidth;

    public FileUpLoadBO() {
    }

    @Override
    public String toString() {
        return "FileUpLoadBO{" +
                "status='" + status + '\'' +
                ", fileType='" + fileType + '\'' +
                ", flag='" + flag + '\'' +
                ", container='" + container + '\'' +
                ", fileName='" + fileName + '\'' +
                ", json='" + json + '\'' +
                ", htmlWidth=" + htmlWidth +
                '}';
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

    public Integer getHtmlWidth() {
        return htmlWidth;
    }

    public void setHtmlWidth(Integer htmlWidth) {
        this.htmlWidth = htmlWidth;
    }
}