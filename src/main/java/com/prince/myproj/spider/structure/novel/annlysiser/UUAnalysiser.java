package com.prince.myproj.spider.structure.novel.annlysiser;


import com.prince.myproj.spider.model.novel.NovelDaoModel;
import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;
import com.prince.util.RegUtil.RegUtil;
import com.prince.util.RegUtil.interfaces.OnMatch;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by zidong.wang on 2015/12/18.
 */
public class UUAnalysiser extends AnalysisTemlate{

    public static final Logger logger = Logger.getLogger(UUAnalysiser.class);

    private RegUtil regUtil;
    public UUAnalysiser(){
        regUtil = RegUtil.getInstance();
    }
    /**
    * 分析出目录的大概结构
    *
    * */
    @Override
    public void analysisMap(HtmlPageBean page, final Map<String, String> titleMap) {
        String menuPattern = "<ul class=\"menu.+?\">.+?<a href=.+?>(.+?)</a>.+?</ul>";
        String content = page.getAllContent();
        regUtil.getMatchs(content, menuPattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                String matchContent = matcher.group();
                String key = matcher.group(1);
                titleMap.put(key, matchContent);
//                logger.info(key);
//                logger.info(matchContent);
            }
        });
    }
    /**
     * 分析出每个大分类的地址 小地址列表
     *
     * */
    @Override
    public void analysisCateMap(Map<String, List<HtmlPageBean>> novelIndexCateMap, Map<String, String> novelIndexMap, final HtmlPageBean currentPage) {
        Set<String> titles = novelIndexMap.keySet();
        Iterator<String> it = titles.iterator();
        while (it.hasNext()){
            final List<HtmlPageBean> htmlPageList = new ArrayList<HtmlPageBean>();
            String title = it.next();
            logger.info("bigCate:"+title);
            String titleContent = novelIndexMap.get(title);
            String pattern = "<li><a href=\"(.+?)\">(.+?)</a></li>";
            regUtil.getMatchs(titleContent, pattern, new OnMatch() {
                public void onMatch(Matcher matcher) {
                    String url = matcher.group(1);
                    String title = matcher.group(2);
                    logger.info("url: "+url);
                    logger.info("title: " + title);
                    HtmlPageBean page = new HtmlPageBean();
                    page.setTitle(title);
                    page.setPageUrl(currentPage.getRootUrl()+url);
                    page.setRootUrl(currentPage.getPageUrl());
                    htmlPageList.add(page);
                }
            });
            novelIndexCateMap.put(title,htmlPageList);
        }
    }



    /**
     * 分析出小说正文页的链接
     * */
    @Override
    public void analysisSpiderPages(final List<NovelPageCateBean> novelSpiderPages, final NovelPageCateBean cateBean) {
        String mainPattern = "<ul class=\"textList\">(.+?)</ul>";
        final String[] mainContents = new String[1];
        regUtil.getMatchs(cateBean.getAllContent(), mainPattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                mainContents[0] = matcher.group(1);
            }
        });
        String pattern = "<li><a href=\"(.+?)\".+?><span>.+?</span>(.+?)</a></li>";
        regUtil.getMatchs(mainContents[0], pattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                String title = matcher.group(2);
                String url = matcher.group(1);
                logger.info("cate:" + cateBean.getCate());
                logger.info("title:" + title);
                logger.info("url:" + url);
                NovelPageCateBean page = new NovelPageCateBean();
                page.setPageUrl(cateBean.getRootUrl() + url);
                page.setRootUrl(cateBean.getRootUrl());
                page.setCate(cateBean.getCate());
                page.setTitle(title);
                novelSpiderPages.add(page);
            }
        });
    }
    /**
     * 分析出小说目录页下一页
     * */
    @Override
    public void analysisNextPage(final NovelPageCateBean cateBean, final NovelPageCateBean nextPage) {
        String pattern = "</strong>.+<a href=\"(.+?)\">下一页</a>.+?<a href=\"(.+?)\">末页</a>";
        regUtil.getMatchs(cateBean.getAllContent(), pattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                String nextUrl = matcher.group(1);
                String lastUrl = matcher.group(2);

                logger.info("nextUrl:"+nextUrl);
                logger.info("lastUrl:"+lastUrl);
                logger.info("isLast:" + cateBean.getPageUrl().contains(lastUrl));

                nextPage.setPageUrl(cateBean.getRootUrl() + nextUrl);
                nextPage.setRootUrl(cateBean.getRootUrl());
                nextPage.setTitle(cateBean.getTitle());
                cateBean.setIsLastPage(cateBean.getPageUrl().contains(lastUrl));
            }
        });
    }




    /**
     * 分析出小说正文
     * */
    @Override
    public void analysisNovelModel(final NovelDaoModel novelDaoModel,HtmlPageBean contentBean) {
        String pattern = "<tbody><tr><td>(.+?)</td>";
        regUtil.getMatchs(contentBean.getAllContent(), pattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                novelDaoModel.setContent(matcher.group(1).trim());
            }
        });
    }



}
