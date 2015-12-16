package com.prince.myproj.spider.structure.novel.pagebean;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageContentBean extends HtmlPageBean {
    private NovelDaoModel model;
    private String cate;

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public NovelDaoModel getModel() {
        return model;
    }

    public void setModel(NovelDaoModel model) {
        this.model = model;
    }
}
