package com.prince.myproj.spider.structure.htmltree;

import com.prince.util.RegUtil.RegUtil;
import com.prince.util.httputil.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zidong.wang on 2015/12/14.
 */
public abstract class HtmlPageTreeNode {

    protected HtmlPageBean page;

    protected HtmlPageTreeNode parent;

    protected List<HtmlPageTreeNode> children;

    public HttpUtil httpUtil;

    public RegUtil regUtil;

    public HtmlPageTreeNode(){
        httpUtil = HttpUtil.getInstance();
        regUtil = RegUtil.getInstance();
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

    //对当前page进行分析，结果存储在持有的page中
    public abstract void analysis();

    //把将当前页面清除 一般是释放不必要的内存 一般在完成分析并且执行自身遍历后清除
    public abstract void clear();


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
