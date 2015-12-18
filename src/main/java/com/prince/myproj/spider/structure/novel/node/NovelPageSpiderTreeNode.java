package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.bridge.NovelSaveBridge;
import com.prince.myproj.spider.model.novel.NovelDaoModel;
import com.prince.myproj.spider.services.SpiderService;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageContentBean;
import com.prince.util.RegUtil.interfaces.OnMatch;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.regex.Matcher;

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

    public void preparedPage(){
        logger.info("spider preparedPage");
        NovelPageContentBean contentBean = (NovelPageContentBean)this.getPage();
        logger.info("spider url:" + contentBean.getPageUrl());
        analysisPage(contentBean);
//        logger.info(contentBean.getAllContent());
        analysisNovelModel(novelDaoModel);
        print(novelDaoModel);
        NovelSaveBridge novelSaveBridge = NovelSaveBridge.getInstance();
        SpiderService spiderService = novelSaveBridge.getSpiderService();
        spiderService.addNovel(novelDaoModel);
    }

    private void analysisNovelModel(NovelDaoModel novelDaoModel){
        //正则表达取数据 填入novelDaoModel
        NovelPageContentBean contentBean = (NovelPageContentBean)this.getPage();
        novelDaoModel.setCate(contentBean.getCate());
        novelDaoModel.setTitle(contentBean.getTitle());
        novelDaoModel.setPageUrl(contentBean.getPageUrl());
        novelDaoModel.setCreateTime(new Date());
        /*String pattern = "<tbody><tr><td>(.+?)</td>";
        regUtil.getMatchs(contentBean.getAllContent(), pattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                novelDaoModel.setContent(matcher.group(1).trim());
            }
        });*/
        this.getAnalysiser().analysisNovelModel(novelDaoModel,contentBean);
    }

    public void print(NovelDaoModel novelDaoModel){
        logger.info("title:"+novelDaoModel.getTitle());
        logger.info("cate:"+novelDaoModel.getCate());
//        logger.info("content:"+novelDaoModel.getContent());
    }

    public void preparedChildren(){}


    public void setNovelDaoModel(NovelDaoModel novelDaoModel) {
        this.novelDaoModel = novelDaoModel;
    }

    public NovelDaoModel getNovelDaoModel() {
        return novelDaoModel;
    }
}
