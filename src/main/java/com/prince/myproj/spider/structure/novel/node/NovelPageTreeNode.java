package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.HtmlPageTreeNode;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTreeNode extends HtmlPageTreeNode {

    public static final Logger logger = Logger.getLogger(NovelPageTreeNode.class);

    private Map<String,String> novelIndexMap;// 存放初步的大分类 和 小分类内容

    private Map<String,List<HtmlPageBean>> novelIndexCateMap;   //存放已经归类的 大分类 和 小分类列表

    public NovelPageTreeNode(){
        super();
        //初始化目录map结构
        this.novelIndexMap = new HashMap<String, String>();
        this.novelIndexCateMap = new HashMap<String, List<HtmlPageBean>>();
        //初始化一个pagebean
        HtmlPageBean pageBean = new HtmlPageBean();
        pageBean.setPageUrl("http://www.2000hh.com/");
        pageBean.setRootUrl(pageBean.getPageUrl());
        this.setPage(pageBean);
    }

    @Override
    public void onVisit() {
        analysis();
        clear();
    }

    @Override
    public void analysis() {
        preparedPage();
        preparedChildren();
    }

    @Override
    public void clear() {

    }

    private void preparedPage(){
        HtmlPageBean indexPage = this.getPage();
        analysisPage(indexPage);
        analysisMap(indexPage, novelIndexMap);
        analysisCateMap(novelIndexCateMap,novelIndexMap,indexPage);
    }

    protected void analysisPage(HtmlPageBean page){
        String url = page.getPageUrl();
        String content = httpUtil.getContentByUrl(url, "gbk");
        page.setAllContent(content);
    }

    private void analysisMap(HtmlPageBean page,final Map<String,String> titleMap){
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

    private void analysisCateMap(Map<String,List<HtmlPageBean>> novelIndexCateMap,Map<String,String> novelIndexMap, final HtmlPageBean currentPage){
        Set<String> titles = novelIndexMap.keySet();
        Iterator<String> it = titles.iterator();
        while (it.hasNext()){
            final List<HtmlPageBean> htmlPageList = new ArrayList<HtmlPageBean>();
            String title = it.next();
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

    private void preparedChildren(){
        Set<String> titleKeySet = novelIndexCateMap.keySet();
        Iterator<String> it = titleKeySet.iterator();
        while (it.hasNext()){
            String titleKey = it.next();
            if ("自拍偷拍".equals(titleKey)){

            }else if("情色小说".equals(titleKey)){
                preparedNovelChildren(novelIndexCateMap.get(titleKey));
            }else if("电影专区".equals(titleKey)){

            }
        }
    }


    public void preparedPICChildren(){}
    public void preparedNovelChildren(List<HtmlPageBean> pages){
        int size = pages.size();
        for(int i=0;i<size;i++){
            HtmlPageBean page = pages.get(i);
            NovelPageCateTreeNode novelPageCateTreeNode = new NovelPageCateTreeNode(page);
            this.addChild(novelPageCateTreeNode);
        }
    }
    public void preparedMovieChildren(){}
}
