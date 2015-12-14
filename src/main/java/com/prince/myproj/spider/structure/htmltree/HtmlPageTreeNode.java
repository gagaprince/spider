package com.prince.myproj.spider.structure.htmltree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zidong.wang on 2015/12/14.
 */
public abstract class HtmlPageTreeNode {

    private HtmlPageBean page;

    private HtmlPageTreeNode parent;

    private List<HtmlPageTreeNode> children;

    public HtmlPageTreeNode(){
        children = new ArrayList<HtmlPageTreeNode>();
    }

    public void addChild(HtmlPageTreeNode child){
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(HtmlPageTreeNode child){
        int size = children.size();
        for(int i=0;i<size;i++){
            HtmlPageTreeNode childIn = children.get(i);
            if(childIn==child){
                children.remove(i);
                childIn.setParent(null);
                childIn=null;
                break;
            }
        }
    }

    //当遍历时执行
    public abstract void onVisit();


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
