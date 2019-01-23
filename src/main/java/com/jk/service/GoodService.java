package com.jk.service;


import com.jk.bean.Class1;
import com.jk.bean.Class2;
import com.jk.bean.MallSku;

import java.util.List;



public interface GoodService {
    Class1 getvalue(String id);

    Class2 getClass2(String id);

    List<MallSku> getGoodName(Integer id);

}
