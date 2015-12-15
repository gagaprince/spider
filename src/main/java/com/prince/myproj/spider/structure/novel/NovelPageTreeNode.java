package com.prince.myproj.spider.structure.novel;

import com.prince.myproj.spider.structure.htmltree.HtmlPageTreeNode;
import com.prince.util.httputil.HttpUtil;

/**
 * Created by zidong.wang on 2015/12/15.
 */
public class NovelPageTreeNode extends HtmlPageTreeNode {

    public NovelPageTreeNode(){
    }

    @Override
    public void onVisit() {
        preparedPage();
    }

    private void preparedPage(){
        NovelPageIndexBean indexPage = (NovelPageIndexBean)this.getPage();
        indexPage.analysis();
    }

}
