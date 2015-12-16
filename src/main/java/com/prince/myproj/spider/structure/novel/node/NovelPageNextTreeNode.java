package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageTreeNode;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageCateBean;
import org.apache.log4j.Logger;

/**
 * Created by gagaprince on 15-12-16.
 */
public class NovelPageNextTreeNode extends HtmlPageTreeNode {
    public static final Logger logger = Logger.getLogger(NovelPageNextTreeNode.class);
    @Override
    public void onVisit() {

        logger.info("visit:"+this.getPage().getPageUrl());
    }
}
