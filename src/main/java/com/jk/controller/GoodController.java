package com.jk.controller;


import com.jk.bean.Class1;
import com.jk.bean.Class2;
import com.jk.bean.Mallproduct;

import com.jk.bean.MallSku;

import com.jk.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.List;


@Controller
@RequestMapping("js")
public class GoodController {
    @Autowired
    private GoodService goodService;


    @ResponseBody
    @RequestMapping("getGoodName")
    public List <MallSku> getGoodName(Integer id){
        List <MallSku> list=goodService.getGoodName(id);
       return list;
    }



    @ResponseBody
    @RequestMapping("getClass")
    public Class1 getClass(String id) {
        return goodService.getvalue(id);
    }

    @ResponseBody
    @RequestMapping("getClass")
    public Class2 getClass2(String id) {
        return goodService.getClass2(id);
    }

}
