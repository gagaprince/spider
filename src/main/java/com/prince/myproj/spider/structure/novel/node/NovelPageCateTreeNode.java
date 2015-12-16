package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.HtmlPageTreeNode;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageCateTreeNode extends HtmlPageTreeNode{

    public NovelPageCateTreeNode(HtmlPageBean page){
        NovelPageCateBean cateBean = new NovelPageCateBean();
        cateBean.setRootUrl(page.getRootUrl());
        cateBean.setPageUrl(page.getPageUrl());
        cateBean.setTitle(page.getTitle());
        this.setPage(cateBean);
    }

    @Override
    public void onVisit() {
        preparedPage();
    }

    public void preparedPage(){
        NovelPageCateBean cateBean = (NovelPageCateBean)this.getPage();
        cateBean.analysis();
    }
}
