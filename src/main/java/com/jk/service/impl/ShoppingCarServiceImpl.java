package com.jk.service.impl;

import com.jk.bean.Shoping;
import com.jk.mapper.ShoppingCarMapper;
import com.jk.service.ShoppingCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Resource
    ShoppingCarMapper shoppingCarMapper;

    @Override
    public void addShopping(Shoping shoping) {

        Shoping zf = getShoppingZF(shoping.getSku_id());
        if (zf != null) {
            if(zf.getSku_id().equals(shoping.getSku_id())){
                addTjsl(shoping.getTjshl(),shoping.getSku_id());
            }

        }else {
        shoppingCarMapper.addShopping(shoping);
        }
        deleteKc(shoping.getTjshl(),shoping.getSku_id());
    }

    @Override
    public List<Shoping> getShopping() {
        return shoppingCarMapper.getShopping();
    }

    @Override
    public Integer getShoppingById(Integer sku_id) {
        return shoppingCarMapper.getShoppingById(sku_id);
    }

    @Override
    public void deleteKc(Integer tjshl, Integer sku_id) {

        shoppingCarMapper.deleteKc(tjshl,sku_id);
    }

    @Override
    public Shoping getShoppingBySkuid(Integer sku_id) {
        return shoppingCarMapper.getShoppingBySkuid(sku_id);
    }

    @Override
    public Shoping getShoppingZF(Integer sku_id) {

        return shoppingCarMapper.getShoppingZF(sku_id);
    }

    @Override
    public void addTjsl(Integer tjshl,Integer sku_id) {
         shoppingCarMapper.addTjsl(tjshl,sku_id);
    }

}
