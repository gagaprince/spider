package com.prince.myproj.spider.structure;

import java.util.List;

/**
 * Created by zidong.wang on 2015/12/14.
 */
public class HtmlPageTreeNode {

    private HtmlPageBean page;

    private HtmlPageTreeNode parent;

    private List<HtmlPageTreeNode> children;

    public void addChild(HtmlPageTreeNode child){

        children.add(child);
    }



    public HtmlPageBean getPage() {
        return page;
    }

    public void setPage(HtmlPageBean page) {
        this.page = page;
    }

    public HtmlPageTreeNode getParent() {
        return parent;
    }

    public void setChildren(List<HtmlPageTreeNode> children) {
        this.children = children;
    }

    public List<HtmlPageTreeNode> getChildren() {
        return children;
    }

    public void setParent(HtmlPageTreeNode parent) {
        this.parent = parent;
    }
}
