package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;
import com.prince.util.RegUtil.interfaces.OnMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageCateTreeNode extends NovelPageTreeNode{

    private List<NovelPageCateBean> novelSpiderPages;
    private NovelPageCateBean nextPage;

    public NovelPageCateTreeNode(HtmlPageBean page) {
        this.novelSpiderPages = new ArrayList<NovelPageCateBean>();
        this.nextPage = new NovelPageCateBean();

        NovelPageCateBean cateBean = new NovelPageCateBean();
        cateBean.setRootUrl(page.getRootUrl());
        cateBean.setPageUrl(page.getPageUrl());
        cateBean.setTitle(page.getTitle());
        cateBean.setCate(page.getTitle());
        this.setPage(cateBean);
    }

    @Override
    public void analysis() {
        preparedPage();
        preparedChildren();
    }

    @Override
    public void clear() {

    }

    public void preparedPage(){
        NovelPageCateBean cateBean = (NovelPageCateBean)this.getPage();
        analysisPage(cateBean);
        analysisSpiderPages(novelSpiderPages, cateBean);
        analysisNextPage(cateBean,nextPage);
    }

    public void analysisPage(NovelPageCateBean cateBean){
        String url = cateBean.getPageUrl();
        logger.info("catePageUrl:"+url);
        String content = httpUtil.getContentByUrl(url,"gbk");
        cateBean.setAllContent(content);
    }

    public void analysisSpiderPages(final List<NovelPageCateBean> novelSpiderPages,final NovelPageCateBean cateBean){
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

    public void analysisNextPage(final NovelPageCateBean cateBean, final NovelPageCateBean nextPage){
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

    public void preparedChildren(){
        int size = novelSpiderPages.size();
        for(int i=0;i<size;i++){
            NovelPageCateBean spiderPage = novelSpiderPages.get(i);
            logger.info("spider page Url:"+spiderPage.getPageUrl());
            NovelPageSpiderTreeNode spiderTreeNode = new NovelPageSpiderTreeNode(spiderPage);
            this.addChild(spiderTreeNode);
        }
        NovelPageCateBean cateBean = (NovelPageCateBean)this.getPage();
        if (!cateBean.isLastPage()){
            NovelPageCateTreeNode cateTreeNode = new NovelPageCateTreeNode(nextPage);
            logger.info("nextPage:"+nextPage.getPageUrl());
            this.addChild(cateTreeNode);
        }

    }

    public List<NovelPageCateBean> getNovelSpiderPages() {
        return novelSpiderPages;
    }

    public void setNovelSpiderPages(List<NovelPageCateBean> novelSpiderPages) {
        this.novelSpiderPages = novelSpiderPages;
    }

    public NovelPageCateBean getNextPage() {
        return nextPage;
    }

    public void setNextPage(NovelPageCateBean nextPage) {
        this.nextPage = nextPage;
    }
}
