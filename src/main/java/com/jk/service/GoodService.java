package com.jk.service;


import com.jk.bean.*;

import java.util.List;



public interface GoodService {
    Class1 getvalue(String id);

    Class2 getClass2(String id);

    List<MallSku> getGoodName(Integer id);

    List<TradeMark> getTrade(String id);

    List<MallValue> getValue(String id);

    List<MallAttr> getSx(String id);

    MallSku getAll(Integer id);

    SendPage getgoulist(ReceivePage receivePage);

    void deleteItem(String ids);
}
