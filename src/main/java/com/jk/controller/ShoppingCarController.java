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

        Integer i = shoppingCarService.getShoppingById(shoping.getSku_id());
        if(i>0){
            shoppingCarService.addShopping(shoping);
            shoppingCarService.deleteKc(shoping.getSku_id());
            return "1";
        }else {
            return "2";
        }

    }

    @ResponseBody
    @RequestMapping("getShopping")
    public List<Shoping> getShopping() {


        return  shoppingCarService.getShopping();
    }



}
