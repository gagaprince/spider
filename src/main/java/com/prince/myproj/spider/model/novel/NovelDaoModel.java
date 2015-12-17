package com.prince.myproj.spider.model.novel;

import java.util.Date;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelDaoModel {
    private Long id;
    private String cate;
    private String title;
    private String content;
    private Date createTime;
    private String pageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCate() {
        return cate;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
}
