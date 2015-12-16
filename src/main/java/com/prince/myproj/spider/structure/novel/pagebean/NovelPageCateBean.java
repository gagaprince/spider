package com.prince.myproj.spider.structure.novel.pagebean;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import org.apache.log4j.Logger;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageCateBean extends HtmlPageBean{
    public static final Logger logger = Logger.getLogger(NovelPageCateBean.class);

    public void analysis(){
        analysisPage();

    }
    public void analysisPage(){
        String url = this.getPageUrl();
        String content = httpUtil.getContentByUrl(url,"gbk");
        this.setAllContent(content);
        logger.info(content);
    }
}
