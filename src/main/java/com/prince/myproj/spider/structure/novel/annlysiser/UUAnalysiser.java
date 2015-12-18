package com.prince.myproj.spider.structure.novel.annlysiser;


import com.prince.myproj.spider.model.novel.NovelDaoModel;
import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;

import java.util.List;
import java.util.Map;

/**
 * Created by zidong.wang on 2015/12/18.
 */
public class UUAnalysiser extends AnalysisTemlate{
    /**
    * 分析出目录的大概结构
    *
    * */
    @Override
    public void analysisMap(HtmlPageBean page, Map<String, String> titleMap) {

    }
    /**
     * 分析出每个大分类的地址 小地址列表
     *
     * */
    @Override
    public void analysisCateMap(Map<String, List<HtmlPageBean>> novelIndexCateMap, Map<String, String> novelIndexMap, HtmlPageBean currentPage) {

    }



    /**
     * 分析出小说正文页的链接
     * */
    @Override
    public void analysisSpiderPages(List<NovelPageCateBean> novelSpiderPages, NovelPageCateBean cateBean) {

    }
    /**
     * 分析出小说目录页下一页
     * */
    @Override
    public void analysisNextPage(NovelPageCateBean cateBean, NovelPageCateBean nextPage) {

    }




    /**
     * 分析出小说正文
     * */
    @Override
    public void analysisNovelModel(NovelDaoModel novelDaoModel) {

    }



}
