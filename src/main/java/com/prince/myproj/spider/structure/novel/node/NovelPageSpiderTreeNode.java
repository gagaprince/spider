package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.HtmlPageTree;
import com.prince.myproj.spider.structure.htmltree.HtmlPageTreeNode;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageContentBean;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageSpiderTreeNode extends HtmlPageTreeNode{

    public NovelPageSpiderTreeNode(HtmlPageBean page,String cate){
        NovelPageContentBean contentBean = new NovelPageContentBean();
        contentBean.setPageUrl(page.getPageUrl());
        contentBean.setRootUrl(page.getRootUrl());
        contentBean.setTitle(page.getTitle());
        contentBean.setCate(cate);
        this.setPage(contentBean);
    }

    @Override
    public void onVisit() {

    }
}
