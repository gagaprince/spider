package com.prince.myproj.spider.structure.novel;

import com.prince.myproj.spider.structure.htmltree.HtmlPageTree;
import com.prince.myproj.spider.structure.novel.node.NovelPageTreeNode;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTree extends HtmlPageTree{
    @Override
    public void createTree() {
        NovelPageTreeNode root = new NovelPageTreeNode();
        this.setRoot(root);
    }

}
