package com.jk.bean;

import lombok.Data;

/**
 * @program: cloud-reception
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-23 15:54
 **/
@Data
public class MallClassTwo {
    /**
     * t_mall_class_2(分类2表)
     * -----------------------------
     * Id(编号)           PKInteger
     * flmch2(分类名称2)  String
     * flbh1(分类编号1)   Integer
     */
    Integer id;
    String flmch2;
    String flbh1;

}
