package com.prince.myproj.spider.structure.htmltree;

import java.util.List;

/**
 * Created by zidong.wang on 2015/12/14.
 */
public abstract class HtmlPageTree {
    private HtmlPageTreeNode root;


    public void inorderTraversal(){
        inorderTraversalNode(root);
    }

    private void inorderTraversalNode(HtmlPageTreeNode node){
        node.onVisit();
        List<HtmlPageTreeNode> children = node.getChildren();
        int size = children.size();
        for(int i=0;i<size;i++){
            HtmlPageTreeNode child = children.get(i);
            inorderTraversalNode(child);
        }
    }

    public abstract void createTree();

    public HtmlPageTreeNode getRoot() {
        return root;
    }

    public void setRoot(HtmlPageTreeNode root) {
        this.root = root;
    }


}
