package com.jk.controller;

import com.jk.bean.Shoping;
import com.jk.service.ShoppingCarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("shopping")
public class ShoppingCarController {

    @Resource
    ShoppingCarService shoppingCarService;

    @ResponseBody
    @RequestMapping("addShopping")
    public String addShopping(Shoping shoping) {

        shoppingCarService.addShopping(shoping);
        return "";
    }

    @ResponseBody
    @RequestMapping("getShopping")
    public List<Shoping> getShopping() {


        return  shoppingCarService.getShopping();
    }
}
