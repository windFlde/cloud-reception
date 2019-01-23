package com.jk.controller;

import com.jk.bean.Img;

import com.jk.bean.GroudUrl;
import com.jk.bean.MallClassOne;
import com.jk.bean.MallClassTwo;
import com.jk.service.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @ResponseBody
    @RequestMapping("getAllClassOneData")
    public List<MallClassOne> getAllClassOneData(){
        List<MallClassOne> list = homeService.getAllClassOneData();
        return list;
    }

    @ResponseBody
    @RequestMapping("getAllClassTwoData")
    public List<MallClassTwo> getAllClassTwoData(String id){
        List<MallClassTwo> list = homeService.getAllClassTwoData(id);
        return list;
    }

    @RequestMapping("toIndexes")
    public String toIndexes(String class1, String class2, Model model){
        model.addAttribute("class1",class1);
        model.addAttribute("class2",class2);
        return "search";
    }

    /*
    * 导购
    * */

    @RequestMapping("getQueryDG")
    @ResponseBody
    public List<GroudUrl> getQueryDG(GroudUrl groudUrl){

      List<GroudUrl> groudUrlList = homeService.getQueryDG(groudUrl);

        return groudUrlList;
    }

}
