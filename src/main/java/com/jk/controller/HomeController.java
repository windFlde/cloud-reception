package com.jk.controller;

import com.jk.bean.Img;
import com.jk.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import java.util.List;

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


    /**
     * 方法：轮播动态从数据库查询图片
     * 姓名：王亚辉
     * @return
     */
    @RequestMapping("queryImg")
    @ResponseBody
    public List<Img> queryImg(){
       List<Img>  img =homeService.queryImg();
        return img;
    }

}
