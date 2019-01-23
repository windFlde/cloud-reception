package com.jk.controller;

import com.jk.bean.Class1;
import com.jk.bean.Class2;
import com.jk.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("js")
public class GoodController {

    @Autowired
    private GoodService goodService;

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

}
