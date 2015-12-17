package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageContentBean;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageSpiderTreeNode extends NovelPageTreeNode{

    public NovelPageSpiderTreeNode(NovelPageCateBean page){
        NovelPageContentBean contentBean = new NovelPageContentBean();
        contentBean.setPageUrl(page.getPageUrl());
        contentBean.setRootUrl(page.getRootUrl());
        contentBean.setTitle(page.getTitle());
        contentBean.setCate(page.getCate());
        this.setPage(contentBean);
    }

    private void preparedPage(){
        NovelPageContentBean contentBean = (NovelPageContentBean)this.getPage();
        analysisPage(contentBean);
    }

    private void preparedChildren(){}

}
