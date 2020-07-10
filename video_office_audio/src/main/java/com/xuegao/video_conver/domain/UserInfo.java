package com.xuegao.video_conver.domain;

import java.util.Date;

/**
 * <br/> @PackageName：com.xuegao.video_conver.domain
 * <br/> @ClassName：UserInfo
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/7/11 2:21
 */
public class UserInfo {
    private String name;
    private String username;
    private Date createTime;

    public UserInfo() {
    }

    public UserInfo(String name, String username, Date createTime) {
        this.name = name;
        this.username = username;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}