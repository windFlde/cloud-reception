package com.jk.controller;

import com.jk.bean.*;
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
    public List<MallSku> getGoodName(Integer id){
        List<MallSku> goodName = goodService.getGoodName(id);
        return goodName;

    }
    @ResponseBody
    @RequestMapping("getClass1")
    public Class1 getClass(String id) {
        return goodService.getvalue(id);
    }

    @ResponseBody
    @RequestMapping("getClass2")
    public Class2 getClass2(String id) {
        return goodService.getClass2(id);
    }

    @ResponseBody
    @RequestMapping("getSx")
    public List<MallAttr> getSx(String id) {
        return goodService.getSx(id);
    }

    @ResponseBody
    @RequestMapping("getValue")
    public List<MallValue> getValue(String id) {
        return goodService.getValue(id);
    }

    @ResponseBody
    @RequestMapping("getTrade")
    public List<TradeMark> getTrade(String id) {
        return goodService.getTrade(id);
    }

    @ResponseBody
    @RequestMapping("getAll")
    public MallSku getAll(Integer id){
        return goodService.getAll(id);
    }

}
