package com.prince.myproj.spider.structure.novel.pagebean;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.PageDo;
import com.prince.util.RegUtil.interfaces.OnMatch;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageIndexBean extends HtmlPageBean implements PageDo{

    public static final Logger logger = Logger.getLogger(NovelPageIndexBean.class);

    private Map<String,String> novelIndexMap;

    private Map<String,List<HtmlPageBean>> novelIndexBeanMap;

    public void setNovelIndexBeanMap(Map<String, List<HtmlPageBean>> novelIndexBeanMap) {
        this.novelIndexBeanMap = novelIndexBeanMap;
    }

    public Map<String, List<HtmlPageBean>> getNovelIndexBeanMap() {
        return novelIndexBeanMap;
    }

    public void setNovelIndexMap(Map<String, String> novelIndexMap) {
        this.novelIndexMap = novelIndexMap;
    }

    public Map<String, String> getNovelIndexMap() {
        return novelIndexMap;
    }

    public void analysis() {
        analysisPage();
        analysisMap();
        analysisTitleMap();
        clearPage();
    }

    public void analysisPage(){
        String url = this.getPageUrl();
        String content = httpUtil.getContentByUrl(url,"gbk");
        this.setAllContent(content);
    }

    public void analysisMap(){
        final Map<String,String> titleMap = new HashMap<String, String>();
        String menuPattern = "<ul class=\"menu.+?\">.+?<a href=.+?>(.+?)</a>.+?</ul>";
        String content = this.getAllContent();
//        logger.info(content);
        regUtil.getMatchs(content, menuPattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                String matchContent = matcher.group();
                String key = matcher.group(1);
                titleMap.put(key,matchContent);
//                logger.info(key);
//                logger.info(matchContent);
            }
        });
        this.setNovelIndexMap(titleMap);
    }

    public void analysisTitleMap(){
        Map<String,List<HtmlPageBean>> novelIndexBeanMap = new HashMap<String, List<HtmlPageBean>>();
        Set<String> titles = novelIndexMap.keySet();
        Iterator<String> it = titles.iterator();

        while (it.hasNext()){
            final List<HtmlPageBean> htmlPageList = new ArrayList<HtmlPageBean>();
            String title = it.next();
            String titleContent = novelIndexMap.get(title);
            /*
            * <ul class="menu">
                <li class="active"><a href="/">激情图区</a></li>
                <li><a href="/html/part/index9.html">自拍偷拍</a></li><li><a href="/html/part/index10.html">亚洲色图</a></li><li><a href="/html/part/index11.html">欧美色图</a></li><li><a href="/html/part/index12.html">美腿丝袜</a></li><li><a href="/html/part/index13.html">清纯唯美</a></li><li><a href="/html/part/index14.html">乱伦熟女</a></li><li><a href="/html/part/index15.html">卡通动漫</a></li><li><a href="/html/part/index16.html">综合色图</a></li>
              </ul>
            * */
            String pattern = "<li><a href=\"(.+?)\">(.+?)</a></li>";
            regUtil.getMatchs(titleContent, pattern, new OnMatch() {
                public void onMatch(Matcher matcher) {
                    String url = matcher.group(1);
                    String title = matcher.group(2);
                    logger.info("url: "+url);
                    logger.info("title: " + title);
                    HtmlPageBean page = new HtmlPageBean();
                    page.setTitle(title);
                    page.setPageUrl(getPageUrl() + url);
                    page.setRootUrl(getPageUrl());
                    htmlPageList.add(page);
                }
            });
            novelIndexBeanMap.put(title,htmlPageList);
        }
        this.setNovelIndexBeanMap(novelIndexBeanMap);
    }

    public void clearPage(){
        this.setAllContent("");
    }

}
