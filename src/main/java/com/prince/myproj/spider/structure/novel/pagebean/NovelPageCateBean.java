package com.prince.myproj.spider.structure.novel.pagebean;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.novel.node.NovelPageSpiderTreeNode;
import com.prince.util.RegUtil.interfaces.OnMatch;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageCateBean extends HtmlPageBean{
    public static final Logger logger = Logger.getLogger(NovelPageCateBean.class);

    private String cate;
    private List<HtmlPageBean> novelSpiderPages;
    private HtmlPageBean nextPage;
    private boolean isLastPage;

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public List<HtmlPageBean> getNovelSpiderPages() {
        return novelSpiderPages;
    }

    public void setNovelSpiderPages(List<HtmlPageBean> novelSpiderPages) {
        this.novelSpiderPages = novelSpiderPages;
    }

    public HtmlPageBean getNextPage() {
        return nextPage;
    }

    public void setNextPage(HtmlPageBean nextPage) {
        this.nextPage = nextPage;
    }

    public void analysis(){
        analysisPage();
        analysisSpiderPages();
        analysisNextPage();
        clearPage();
    }
    public void analysisPage(){
        String url = this.getPageUrl();
        String content = httpUtil.getContentByUrl(url,"gbk");
        this.setAllContent(content);
//        logger.info(content);
    }

    public void analysisSpiderPages(){
        final List<HtmlPageBean> novelSpiderPages = new ArrayList<HtmlPageBean>();
        String pattern = "<li><a href=\"(.+?)\".+?><span>.+?</span>(.+?)</a></li>";
        regUtil.getMatchs(this.getAllContent(), pattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                String title = matcher.group(2);
                String url = matcher.group(1);
                logger.info("cate:"+getCate());
                logger.info("title:" + title);
                logger.info("url:" + url);
                HtmlPageBean page = new HtmlPageBean();
                page.setPageUrl(getRootUrl()+url);
                page.setRootUrl(getRootUrl());
                page.setTitle(title);
                novelSpiderPages.add(page);
            }
        });
        this.setNovelSpiderPages(novelSpiderPages);
    }
    public void analysisNextPage(){
        final HtmlPageBean nextPage = new HtmlPageBean();
        String pattern = "</strong>.+<a href=\"(.+?)\">下一页</a>.+?<a href=\"(.+?)\">末页</a>";
        regUtil.getMatchs(this.getAllContent(), pattern, new OnMatch() {
            public void onMatch(Matcher matcher) {
                String nextUrl = matcher.group(1);
                String lastUrl = matcher.group(2);

                logger.info("nextUrl:"+nextUrl);
                logger.info("lastUrl:"+lastUrl);
                logger.info("isLast:"+getPageUrl().contains(lastUrl));

                nextPage.setPageUrl(getRootUrl()+nextUrl);
                nextPage.setRootUrl(getRootUrl());
                nextPage.setTitle(getTitle());
                setIsLastPage(getPageUrl().contains(lastUrl));
            }
        });

        this.setNextPage(nextPage);
    }
    public void clearPage(){
        this.setAllContent("");
    }
}
