package com.voidking.pandawork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by voidking on 2017/5/13.
 */
@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    public @ResponseBody String test() {
        return "hello, world! This com from spring!";
    }

    @RequestMapping("/hellotpl")
    public String index(ModelMap modelMap){
        modelMap.put("title","测试freemarker");
        return "index";
    }

    @RequestMapping("/hellotpl2")
    public ModelAndView index2()
    {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("title","测试freemarker2");
        return modelAndView;
    }

    @RequestMapping("/getPath")
    public @ResponseBody String getPath(){
        String basePath = System.getProperty("pandaworkWeb.root");
        return basePath;
    }

    @RequestMapping("/login")
    public String loginpage(ModelMap modelMap){
        return "user/login";
    }
}
