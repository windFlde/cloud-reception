package com.jk.service.impl;

import com.jk.bean.Class1;
import com.jk.bean.Class2;
import com.jk.bean.Mallproduct;
import com.jk.mapper.GoodMapper;
import com.jk.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public Class1 getvalue(String id) {
        return goodMapper.getvalue(id);
    }

    @Override
    public Class2 getClass2(String id) {
        return goodMapper.getClass2(id);
    }
}
