package com.prince.myproj.spider.bridge;

import com.prince.myproj.spider.services.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * Created by gagaprince on 15-12-18.
 */
@Service
public class NovelSaveBridge {
    public static NovelSaveBridge novelSaveBridge;

    @Autowired
    public SpiderService spiderService;

    @PostConstruct
    public void init(){
        novelSaveBridge = this;
    }

    public static NovelSaveBridge getInstance(){
        return novelSaveBridge;
    }

    public void setSpiderService(SpiderService spiderService) {
        this.spiderService = spiderService;
    }

    public SpiderService getSpiderService() {
        return spiderService;
    }
}
