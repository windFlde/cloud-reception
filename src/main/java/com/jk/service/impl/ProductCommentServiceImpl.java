package com.jk.service.impl;

import com.jk.bean.MallProductComment;
import com.jk.mapper.ProductCommentMapper;
import com.jk.service.ProductCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: cloud-reception
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-24 18:52
 **/
@Service
public class ProductCommentServiceImpl implements ProductCommentService {

    @Resource
    ProductCommentMapper productCommentMapper;

    @Override
    public void addProductComment(MallProductComment mallProductComment) {
        productCommentMapper.addProductComment(mallProductComment);
    }

    @Override
    public List<MallProductComment> getAllProductComment(MallProductComment mallProductComment) {
        return productCommentMapper.getAllProductComment(mallProductComment);
    }
}
