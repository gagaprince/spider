package com.prince.myproj.spider.controller;

import com.prince.myproj.spider.services.SpiderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zidong.wang on 2015/12/14.
 */
@Controller
@RequestMapping("/spider/ctrl")
public class SpiderCtrlController {
    public static final Logger logger = Logger.getLogger(SpiderCtrlController.class);

    @Autowired
    private SpiderService spiderService;

    @RequestMapping("/test")
    public String test(HttpServletRequest request,HttpServletResponse response, Model model){
        spiderService.startSpiderNovel();
        return "novel";
    }
}
