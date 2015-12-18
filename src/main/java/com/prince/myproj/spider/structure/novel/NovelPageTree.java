package com.prince.myproj.spider.structure.novel;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.HtmlPageTree;
import com.prince.myproj.spider.structure.novel.annlysiser.AnalysisTemlate;
import com.prince.myproj.spider.structure.novel.node.NovelPageTreeNode;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTree extends HtmlPageTree{


    @Override
    public void createTree() {
        NovelPageTreeNode root = new NovelPageTreeNode();
        //初始化一个pagebean
        HtmlPageBean pageBean = new HtmlPageBean();
        pageBean.setPageUrl("http://www.2000hh.com/");
        pageBean.setRootUrl(pageBean.getPageUrl());
        root.setPage(pageBean);

        try {
            Class Analysiser = Class.forName("com.prince.myproj.spider.structure.novel.annlysiser.UUAnalysiser");
            AnalysisTemlate analysiser = (AnalysisTemlate)Analysiser.newInstance();
            root.setAnalysiser(analysiser);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        this.setRoot(root);
    }

}
