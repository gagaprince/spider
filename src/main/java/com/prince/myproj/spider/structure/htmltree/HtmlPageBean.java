package com.prince.myproj.spider.structure.htmltree;

import com.prince.util.RegUtil.RegUtil;
import com.prince.util.httputil.HttpUtil;


/**
 * Created by zidong.wang on 2015/12/14.
 */
public class HtmlPageBean {


    public HttpUtil httpUtil;
    public RegUtil regUtil;
    private String title;//page title
    private String allContent;//网页所有内容 //一般不会用
    private String tag;  //全局唯一标识
    private String pageUrl;//当前页面的url
    private String rootUrl;//当前页面的rootUrl

    public HtmlPageBean(){
        httpUtil = HttpUtil.getInstance();
        regUtil = RegUtil.getInstance();
    }

    public String getAllContent() {
        return allContent;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String getTag() {
        return tag;
    }

    public String getTitle() {
        return title;
    }

    public void setAllContent(String allContent) {
        this.allContent = allContent;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    public void clearPage(){
        this.setAllContent("");
    }
}
