package com.jk.controller;

import com.jk.bean.MallProductComment;
import com.jk.service.ProductCommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
        mallProductComment.setPlshj(new Date());
        Integer name = mallProductComment.getYh_id();
        if (name == null) {
            //游客登录
            mallProductComment.setYh_id(8);
        }
        productCommentService.addProductComment(mallProductComment);
    }
    @ResponseBody
    @RequestMapping("getAllProductComment")
    public List<MallProductComment> getAllProductComment(MallProductComment mallProductComment){
        List<MallProductComment> list = productCommentService.getAllProductComment(mallProductComment);
        return list;
    }
}
