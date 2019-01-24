package com.jk.service;

import com.jk.bean.Shoping;

import java.util.List;

public interface ShoppingCarService {

    void addShopping(Shoping shoping);

    List<Shoping> getShopping();

    Integer getShoppingById(Integer sku_id);

    void deleteKc(Integer sku_id);
}
