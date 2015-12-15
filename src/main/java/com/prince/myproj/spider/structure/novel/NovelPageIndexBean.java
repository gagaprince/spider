package com.prince.myproj.spider.structure.novel;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.PageDo;
import org.apache.log4j.Logger;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageIndexBean extends HtmlPageBean implements PageDo{

    public static final Logger logger = Logger.getLogger(NovelPageIndexBean.class);

    public void analysis() {
        String url = this.getPageUrl();
        String content = httpUtil.getContentByUrl(url,"utf-8");
        logger.info(content);
        this.setAllContent(content);
    }


}
