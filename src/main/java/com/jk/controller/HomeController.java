package com.jk.controller;

import com.jk.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @program: cloud-reception
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-23 13:51
 **/
@Controller
@RequestMapping("home")
public class HomeController {
    @Resource
    HomeService homeService;

    @RequestMapping("toView")
    public String toView(String viewName){
        return viewName;
    }
}
