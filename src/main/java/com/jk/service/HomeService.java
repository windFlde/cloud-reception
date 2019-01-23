package com.jk.service;

import com.jk.bean.GroudUrl;
import com.jk.bean.MallClassOne;
import com.jk.bean.MallClassTwo;

import java.util.List;

public interface HomeService {
    List<MallClassOne> getAllClassOneData();

    List<GroudUrl> getQueryDG(GroudUrl groudUrl);

    List<MallClassTwo> getAllClassTwoData(String id);
}
