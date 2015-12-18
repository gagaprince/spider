package com.prince.myproj.spider.structure.novel.annlysiser;

import com.prince.myproj.spider.model.novel.NovelDaoModel;
import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.interfaces.IAnalysis;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;

import java.util.List;
import java.util.Map;

/**
 * Created by zidong.wang on 2015/12/18.
 */
public class AnalysisTemlate implements IAnalysis{

    public void analysisMap(HtmlPageBean page, Map<String, String> titleMap) {

    }

    public void analysisCateMap(Map<String, List<HtmlPageBean>> novelIndexCateMap, Map<String, String> novelIndexMap, HtmlPageBean currentPage) {

    }

    public void analysisNovelModel(NovelDaoModel novelDaoModel,HtmlPageBean contentBean) {

    }

    public void analysisSpiderPages(List<NovelPageCateBean> novelSpiderPages, NovelPageCateBean cateBean) {

    }

    public void analysisNextPage(NovelPageCateBean cateBean, NovelPageCateBean nextPage) {

    }
}

