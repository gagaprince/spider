package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.model.novel.NovelDaoModel;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageContentBean;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageSpiderTreeNode extends NovelPageTreeNode{
    private NovelDaoModel novelDaoModel;

    public NovelPageSpiderTreeNode(NovelPageCateBean page){
        novelDaoModel = new NovelDaoModel();

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
        analysisNovelModel(novelDaoModel);
    }

    private void analysisNovelModel(NovelDaoModel novelDaoModel){
        //正则表达取数据 填入novelDaoModel
    }

    private void preparedChildren(){}


    public void setNovelDaoModel(NovelDaoModel novelDaoModel) {
        this.novelDaoModel = novelDaoModel;
    }

    public NovelDaoModel getNovelDaoModel() {
        return novelDaoModel;
    }
}
