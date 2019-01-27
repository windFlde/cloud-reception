package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface HomeService {
    List<Img> queryImg();
    List<MallClassOne> getAllClassOneData();

    List<GroudUrl> getQueryDG(GroudUrl groudUrl);

    List<MallClassTwo> getAllClassTwoData(String id);

    List<HotSerarch> getHotSearch(String num);
}
