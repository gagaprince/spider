package com.prince.myproj.spider.structure.novel.pagebean;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageContentBean extends NovelPageCateBean {
    private String novelContent;
    public String getNovelContent() {
        return novelContent;
    }
    public void setNovelContent(String novelContent) {
        this.novelContent = novelContent;
    }
}
