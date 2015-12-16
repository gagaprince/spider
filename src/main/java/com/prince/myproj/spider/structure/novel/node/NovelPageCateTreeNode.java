package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.HtmlPageTreeNode;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;

import java.util.List;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageCateTreeNode extends HtmlPageTreeNode{

    public NovelPageCateTreeNode(HtmlPageBean page){
        NovelPageCateBean cateBean = new NovelPageCateBean();
        cateBean.setRootUrl(page.getRootUrl());
        cateBean.setPageUrl(page.getPageUrl());
        cateBean.setTitle(page.getTitle());
        cateBean.setCate(page.getTitle());
        this.setPage(cateBean);
    }

    @Override
    public void onVisit() {
        preparedPage();
        preparedChildren();
    }

    public void preparedPage(){
        NovelPageCateBean cateBean = (NovelPageCateBean)this.getPage();
        cateBean.analysis();
    }
    public void preparedChildren(){
        NovelPageCateBean cateBean = (NovelPageCateBean)this.getPage();
        List<HtmlPageBean> spiderPages = cateBean.getNovelSpiderPages();
        HtmlPageBean nextPage = cateBean.getNextPage();

        int size = spiderPages.size();
        for(int i=0;i<size;i++){
            HtmlPageBean spiderPage = spiderPages.get(i);
            NovelPageSpiderTreeNode spiderTreeNode = new NovelPageSpiderTreeNode(spiderPage,cateBean.getCate());
            this.addChild(spiderTreeNode);
        }

        if (!cateBean.isLastPage()){
            NovelPageCateTreeNode cateTreeNode = new NovelPageCateTreeNode(nextPage);
            this.addChild(cateTreeNode);
        }

    }
}
