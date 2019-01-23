package com.jk.service.impl;


import com.jk.bean.*;

import com.jk.mapper.GoodMapper;
import com.jk.service.GoodService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodMapper goodMapper;

    @Override
    public Class1 getvalue(String id) {
        return goodMapper.getvalue(id);
    }

    @Override
    public Class2 getClass2(String id) {
        return goodMapper.getClass2(id);
    }
    @Override
    public List<MallSku> getGoodName(Integer id) {
        return   goodMapper.getGoodName(id);
    }

    @Override
    public List<TradeMark> getTrade(String id) {
        return goodMapper.getTrade(id);
    }
}
