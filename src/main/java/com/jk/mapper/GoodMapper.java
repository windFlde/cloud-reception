package com.jk.mapper;


import com.jk.bean.*;

import java.util.List;

public interface GoodMapper {

    Class1 getvalue(String id);

    Class2 getClass2(String id);

    List<MallSku> getGoodName(Integer id);

    List<TradeMark> getTrade(String id);

    List<MallValue> getValue(String id);

    List<MallAttr> getSx(String id);

    MallSku getAll(Integer id);

    List<Shoping> getgoulist();

    void deleteItem(String ids);

    List<Shoping> queryGood(Integer yh_id);

    Integer countGood(Integer yh_id);
}
