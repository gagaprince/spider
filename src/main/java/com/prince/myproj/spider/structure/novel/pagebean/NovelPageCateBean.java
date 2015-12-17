package com.prince.myproj.spider.structure.novel.pagebean;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import org.apache.log4j.Logger;
/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageCateBean extends HtmlPageBean{
    public static final Logger logger = Logger.getLogger(NovelPageCateBean.class);

    private String cate;
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
}
