package com.prince.myproj;

import com.prince.myproj.spider.dao.TestDao;
import com.prince.myproj.spider.model.TestModel;
import com.prince.util.RegUtil.RegUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by zidong.wang on 2015/12/9.
 */
@Controller
@RequestMapping("/firstTest")
public class FirstTest {

    public static final Logger logger = Logger.getLogger(FirstTest.class);

    @Autowired
    private TestDao testDao;

    @RequestMapping(value="/index" , method = RequestMethod.GET)
    public String testIndex(HttpServletRequest request,HttpServletResponse response, Model model){
        model.addAttribute("name","test");
        request.setAttribute("aaa", "123");
        logger.info("这是一次请求");

        RegUtil regUtil = RegUtil.getInstance();
        boolean isNum = regUtil.isAllNum("1234567");
        logger.info("1234567 is allNum:"+isNum);


        TestModel test = new TestModel();
        test.setTitle("这是一次test1");
        test.setContent("这是test的内容1");
        test.setCreateTime(new Date());
        testDao.save(test);

        return "index";
    }
}
