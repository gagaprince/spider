package com.prince.myproj.spider.structure.novel;

import com.prince.myproj.spider.structure.htmltree.HtmlPageTree;
import com.prince.myproj.spider.structure.novel.node.NovelPageTreeNode;

import java.util.List;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTree extends HtmlPageTree{

    private List<NovelPageTreeNode> novelPageNodeList;

    @Override
    public void createTree() {

        /*//初始化一个pagebean
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
        }*/
        NovelPageTreeNode root = new NovelPageTreeNode();

        if(novelPageNodeList!=null){
            int size = novelPageNodeList.size();
            for(int i=0;i<size;i++){
                NovelPageTreeNode novelPageTreeNode = novelPageNodeList.get(i);
                root.addChild(novelPageTreeNode);
            }
        }

        this.setRoot(root);
    }


    public List<NovelPageTreeNode> getNovelPageNodeList() {
        return novelPageNodeList;
    }

    public void setNovelPageNodeList(List<NovelPageTreeNode> novelPageNodeList) {
        this.novelPageNodeList = novelPageNodeList;
    }
}
