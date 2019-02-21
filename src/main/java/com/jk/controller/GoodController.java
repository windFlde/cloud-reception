package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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


    //查询
    @ResponseBody
    @RequestMapping("getgoulist")
    public SendPage getBooks(ReceivePage receivePage, HttpSession session,Integer yhid){
        SendPage list = goodService.getgoulist(receivePage);
        return list;
    }
    @ResponseBody
    @RequestMapping("getgouwu")
    public List <Shoping> getgouwu( HttpSession session,Integer yhid){
        List <Shoping> list=goodService.getgouwu(yhid);

        return list;
    }
    //统计选中的价格
    @ResponseBody
    @RequestMapping("jieSuanCheckPrice")
    public Double jieSuanCheckPrice(String ids){
        double price = 0.0;
        List<Shoping>  sc = goodService.jieSuanCheckPrice(ids);
        for (Shoping sp: sc) {
            price += sp.getTjshl()*sp.getJg();
        }

        return price;
    }
    //修改价格
    @ResponseBody
    @RequestMapping("updateSl")
    public  String updateSl(Integer state,Integer id, Double price){

        goodService.updateSl(state,id,price);
        return "1";
    }




    //删除
    @ResponseBody
    @RequestMapping("deleteItem")
    public String deleteItem(String ids){
        goodService.deleteItem(ids);
        return "1";
    }
    //js
    @ResponseBody
    @RequestMapping("queryGood")
    public List<Shoping> queryGood(Integer yh_id){
        return goodService.queryGood(yh_id);
    }

    @ResponseBody
    @RequestMapping("countGood")
    public Integer countGood(Integer yh_id){

        return goodService.countGood(yh_id);
    }


}
