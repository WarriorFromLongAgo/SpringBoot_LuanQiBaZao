package com.xuegao.nio_client.netty3;

import java.io.Serializable;

public class CustomProtocol implements Serializable {

    private static final long serialVersionUID = -6616260732208751711L;
    private long id;
    private String content;

    public CustomProtocol() {
    }

    public CustomProtocol(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}