package com.prince.myproj.spider.structure.novel.node;

import com.prince.myproj.spider.structure.htmltree.HtmlPageBean;
import com.prince.myproj.spider.structure.htmltree.HtmlPageTreeNode;
import com.prince.myproj.spider.structure.novel.node.NovelPageCateTreeNode;
import com.prince.myproj.spider.structure.novel.pagebean.NovelPageIndexBean;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTreeNode extends HtmlPageTreeNode {

    public NovelPageTreeNode(){
    }

    @Override
    public void onVisit() {
        preparedPage();
        preparedChildren();
    }

    private void preparedPage(){
        NovelPageIndexBean indexPage = (NovelPageIndexBean)this.getPage();
        indexPage.analysis();
    }

    public void preparedChildren(){
        NovelPageIndexBean indexPage = (NovelPageIndexBean)this.getPage();
        Map<String,List<HtmlPageBean>> novelIndexBeanMap = indexPage.getNovelIndexBeanMap();
        Set<String> titleKeySet = novelIndexBeanMap.keySet();
        Iterator<String> it = titleKeySet.iterator();
        while (it.hasNext()){
            String titleKey = it.next();
            if ("自拍偷拍".equals(titleKey)){

            }else if("情色小说".equals(titleKey)){
                preparedNovelChildren(novelIndexBeanMap.get(titleKey));
            }else if("电影专区".equals(titleKey)){

            }
        }
    }

    public void preparedPICChildren(){}
    public void preparedNovelChildren(List<HtmlPageBean> pages){
        int size = pages.size();
        for(int i=0;i<size;i++){
            HtmlPageBean page = pages.get(i);
            NovelPageCateTreeNode novelPageCateTreeNode = new NovelPageCateTreeNode(page);
            this.addChild(novelPageCateTreeNode);
        }
    }
    public void preparedMovieChildren(){}
}
