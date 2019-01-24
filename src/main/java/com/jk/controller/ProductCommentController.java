package com.jk.controller;

import com.jk.bean.MallProductComment;
import com.jk.service.ProductCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @program: cloud-reception
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-24 18:49
 **/
@Controller
@RequestMapping("comment")
public class ProductCommentController {

    @Resource
    ProductCommentService productCommentService;

    @ResponseBody
    @RequestMapping("addProductComment")
    public void addProductComment(MallProductComment mallProductComment){
        productCommentService.addProductComment(mallProductComment);
    }
}
