package com.jk.service.impl;

import com.jk.bean.*;
import com.jk.mapper.HomeMapper;
import com.jk.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: cloud-reception
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-23 13:54
 **/
@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    HomeMapper homeMapper;

    @Override
    public List<Img> queryImg() {

        return homeMapper.queryImg();
    }

    @Override
    public List<MallClassOne> getAllClassOneData() {
        List<MallClassOne> list = homeMapper.getAllClassOneData();
        return list;
    }

    @Override
    public List<GroudUrl> getQueryDG(GroudUrl groudUrl) {
        return homeMapper.getQueryDG(groudUrl);
    }

    @Override
    public List<MallClassTwo> getAllClassTwoData(String id) {
        List<MallClassTwo> list = homeMapper.getAllClassTwoData(id);
        return list;
    }

    @Override
    public List<HotSerarch> getHotSearch(String num) {
        return homeMapper.getHotSearch(num);
    }
}
