package com.prince.myproj.spider.structure.novel.pagebean;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelDaoModel {
    private String cate;
    private String title;
    private String content;

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
}
