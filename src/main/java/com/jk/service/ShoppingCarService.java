package com.jk.service;

import com.jk.bean.Shoping;

import java.util.List;

public interface ShoppingCarService {

    void addShopping(Shoping shoping);

    List<Shoping> getShopping();

    Integer getShoppingById(Integer sku_id);

    void deleteKc(Integer tjsl, Integer sku_id);

    Shoping getShoppingBySkuid(Integer sku_id);

    Shoping getShoppingZF(Integer sku_id);

    void addTjsl(Integer tjshl,Integer sku_id);
}
