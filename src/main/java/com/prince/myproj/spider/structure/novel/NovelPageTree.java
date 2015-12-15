package com.prince.myproj.spider.structure.novel;

import com.prince.myproj.spider.structure.htmltree.HtmlPageTree;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTree extends HtmlPageTree{
    @Override
    public void createTree() {
        NovelPageBean npb = new NovelPageBean();
        npb.setPageUrl("http://www.tooopen.com/img/87.aspx");
        NovelPageTreeNode root = new NovelPageTreeNode();
        root.setPage(npb);
    }
}
