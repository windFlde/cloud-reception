package com.jk.mapper;

import com.jk.bean.MallProductComment;

import java.util.List;

public interface ProductCommentMapper {

    void addProductComment(MallProductComment mallProductComment);

    List<MallProductComment> getAllProductComment(MallProductComment mallProductComment);
}
