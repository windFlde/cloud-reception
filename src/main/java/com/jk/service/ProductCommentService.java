package com.jk.service;

import com.jk.bean.MallProductComment;

import java.util.List;

public interface ProductCommentService {
    void addProductComment(MallProductComment mallProductComment);
    List<MallProductComment> getAllProductComment(MallProductComment mallProductComment);
}
