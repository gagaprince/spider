package com.prince.myproj.spider.structure.novel;

import com.prince.myproj.spider.structure.htmltree.HtmlPageTree;
import com.prince.myproj.spider.structure.novel.node.NovelPageTreeNode;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageIndexBean;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTree extends HtmlPageTree{
    @Override
    public void createTree() {
        NovelPageIndexBean npb = new NovelPageIndexBean();
        npb.setPageUrl("http://www.2000hh.com/");
        NovelPageTreeNode root = new NovelPageTreeNode();
        root.setPage(npb);
        this.setRoot(root);
    }

}
