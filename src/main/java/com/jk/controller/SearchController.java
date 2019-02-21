package com.jk.controller;

import com.jk.bean.MallSku;
import com.jk.client.SearchClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Resource
    SearchClient searchClient;

    @ResponseBody
    @RequestMapping("getSku")
    public List<MallSku> getSku(@RequestParam(value = "name")String name){

        return searchClient.getSku(name);
    }


}
