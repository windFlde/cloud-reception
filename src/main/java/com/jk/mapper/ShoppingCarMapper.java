package com.jk.mapper;

import com.jk.bean.Shoping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCarMapper{
    void addShopping(Shoping shoping);

    List<Shoping> getShopping();

    Integer getShoppingById(Integer sku_id);

    void deleteKc(@Param("tjsl") Integer tjsl, @Param("sku_id") Integer sku_id);

    Shoping getShoppingBySkuid(Integer sku_id);

    Shoping getShoppingZF(Integer sku_id);

    void addTjsl(@Param("tjshl")Integer tjshl,@Param("sku_id")Integer sku_id);
}
