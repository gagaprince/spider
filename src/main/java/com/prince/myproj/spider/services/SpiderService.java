package com.prince.myproj.spider.services;

import com.prince.myproj.spider.structure.novel.NovelPageTree;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by zidong.wang on 2015/12/14.
 */
@Service
public class SpiderService {
    public static final Logger logger = Logger.getLogger(SpiderService.class);

    public void startSpiderNovel(){
        logger.info("开始抓取小说");
        NovelPageTree novelPageTree = new NovelPageTree();
        novelPageTree.createTree();
        novelPageTree.inorderTraversal();
        logger.info("小说抓取完毕");
    }
}
