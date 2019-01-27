package com.jk.controller;

import com.jk.bean.Shoping;
import com.jk.service.ShoppingCarService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("shopping")
public class ShoppingCarController {

    @Resource
    private RedisTemplate<String, Shoping> redisTemplate;

    @Resource
    ShoppingCarService shoppingCarService;

    @ResponseBody
    @RequestMapping("addShopping")
    public String addShopping(Shoping shoping) {


       /* Integer i = shoppingCarService.getShoppingById(shoping.getSku_id());*/

            Shoping zf = shoppingCarService.getShoppingZF(shoping.getSku_id());
        if (zf != null) {
            if(zf.getSku_id().equals(shoping.getSku_id())){
                shoppingCarService.addTjsl(shoping.getTjshl(),shoping.getSku_id());
            }

        }else {
            shoppingCarService.addShopping(shoping);
        }
        shoppingCarService.deleteKc(shoping.getTjshl(),shoping.getSku_id());
            return "1";


    }

    @ResponseBody
    @RequestMapping("getShopping")
    public List<Shoping> getShopping() {



        return  shoppingCarService.getShopping();
    }

    @ResponseBody
    @RequestMapping("redisAddShoping")
    public void redisAddShoping(Shoping shoping, HttpServletRequest request, HttpServletResponse response) {
        Shoping shopingFromDb = shoppingCarService.getShoppingBySkuid(shoping.getSku_id());
        shopingFromDb.setHj(shoping.getPrice()*shoping.getTjshl());
        shopingFromDb.setTjshl(shoping.getTjshl());
        shopingFromDb.setPrice(shoping.getPrice());
        shopingFromDb.setShfxz(shoping.getShfxz());
        Cookie[] cookies = request.getCookies();
        String str = "";
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("keyUUid")) {
                    str = cookie.getValue();
                }
            }
        }

        //判断用户有没有cookie
        if (str.equals("")) {
            //第一增加
            String uuid = UUID.randomUUID().toString();
            String keyUUid = uuid.replaceAll("-", "");
            Cookie ShopingTemp = new Cookie("keyUUid",keyUUid);

            //设置cookie的时间
            ShopingTemp.setMaxAge(410381);
            ShopingTemp.setPath("/");

            response.addCookie(ShopingTemp);

            //shopingFromDb
            redisTemplate.opsForList().leftPush(keyUUid, shopingFromDb);
            redisTemplate.expire(keyUUid,7, TimeUnit.DAYS);
        }else{
            //有cookie 查reid  包含或者不包含
            boolean tag = true;
            if (redisTemplate.hasKey(str)) {
                List<Shoping> shopingFormDb = redisTemplate.opsForList().range(str, 0, -1);
                for (int i = 0; i < shopingFormDb.size(); i++) {

                    if (shopingFormDb.get(i).getSku_id().equals(shoping.getSku_id())) {
                        Integer tjsh1 = shopingFormDb.get(i).getTjshl() + shoping.getTjshl();
                        shopingFormDb.get(i).setTjshl(tjsh1);
                        redisTemplate.opsForList().set(str, i, shopingFormDb.get(i));
                        tag = false;
                    }
                }

                if (tag) {

                    //shopingFromDb
                    redisTemplate.opsForList().leftPush(str, shopingFromDb);
                }
            } else {

                redisTemplate.opsForList().leftPush(str, shopingFromDb);
            }


        }




    }

    @ResponseBody
    @RequestMapping("getShopingTemp")
    public List<Shoping> getShopingTemp(HttpServletRequest request) {
        List<Shoping> list = null;
        Cookie[] cookies = request.getCookies();
        String str = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("keyUUid")) {
                    str = cookie.getValue();
                }
            }
        }

        if (!str.equals("")) {
            list = redisTemplate.opsForList().range(str, 0, -1);
        }

        return list;
    }
}
