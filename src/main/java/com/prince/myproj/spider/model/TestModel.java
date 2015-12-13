package com.prince.myproj.spider.model;

import java.util.Date;

/**
 * Created by gagaprince on 15-12-13.
 */
public class TestModel {
    public Long id;
    public String content;
    public String title;
    public Date createTime;

    public Long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
