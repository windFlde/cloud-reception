package com.jk.mapper;

import com.jk.bean.*;

import java.util.List;

public interface HomeMapper {

    List<Img> queryImg();
    List<MallClassOne> getAllClassOneData();

    List<MallClassTwo> getAllClassTwoData(String id);

    List<GroudUrl> getQueryDG(GroudUrl groudUrl);

    List<HotSerarch> getHotSearch(String num);
}
