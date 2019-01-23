package com.jk.mapper;

import com.jk.bean.GroudUrl;
import com.jk.bean.MallClassOne;
import com.jk.bean.MallClassTwo;

import java.util.List;

public interface HomeMapper {
    List<MallClassOne> getAllClassOneData();

    List<MallClassTwo> getAllClassTwoData(String id);

    List<GroudUrl> getQueryDG(GroudUrl groudUrl);
}
