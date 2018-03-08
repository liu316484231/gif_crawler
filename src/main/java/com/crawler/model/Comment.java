package com.crawler.model;

import java.util.Date;

/**
 * Created by admin on 2018/3/8.
 */
public class Comment {
    private Integer id;
    private Integer gid;
    private String comment;
    private String user;
    private Date createTime;
    private Integer status;
    private Integer isCream;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsCream() {
        return isCream;
    }

    public void setIsCream(Integer isCream) {
        this.isCream = isCream;
    }
}
