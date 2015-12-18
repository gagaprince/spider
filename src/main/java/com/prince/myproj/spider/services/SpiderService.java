package com.prince.myproj.spider.services;

import com.prince.myproj.spider.dao.novel.NovelDao;
import com.prince.myproj.spider.model.novel.NovelDaoModel;
import com.prince.myproj.spider.structure.novel.NovelPageTree;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zidong.wang on 2015/12/14.
 */
@Service
public class SpiderService {
    public static final Logger logger = Logger.getLogger(SpiderService.class);
    @Autowired
    public NovelDao novelDao;
    @Autowired
    public NovelPageTree novelPageTree;

    public void startSpiderNovel(){
        logger.info("开始抓取小说");
        novelPageTree.createTree();
        novelPageTree.inorderTraversal();
        logger.info("小说抓取完毕");
    }

    public void addNovel(NovelDaoModel novelDaoModel){
        logger.info("addNovel:"+novelDaoModel.getTitle());
        novelDao.save(novelDaoModel);
    }
}
