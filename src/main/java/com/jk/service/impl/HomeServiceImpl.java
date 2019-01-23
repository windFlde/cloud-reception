package com.jk.service.impl;

import com.jk.mapper.HomeMapper;
import com.jk.service.HomeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
