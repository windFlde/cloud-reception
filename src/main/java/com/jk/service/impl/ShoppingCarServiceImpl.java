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
        shoppingCarMapper.addShopping(shoping);
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
    public void deleteKc(Integer tjsl, Integer sku_id) {
        shoppingCarMapper.deleteKc(sku_id,tjsl);
    }

}