package com.jk.mapper;


import com.jk.bean.Class1;
import com.jk.bean.Class2;
import com.jk.bean.MallSku;
import com.jk.bean.TradeMark;

import java.util.List;

public interface GoodMapper {

    Class1 getvalue(String id);

    Class2 getClass2(String id);

    List<MallSku> getGoodName(Integer id);

    List<TradeMark> getTrade(String id);
}
