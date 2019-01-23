package com.jk.bean;

import lombok.Data;

/**
 * @program: cloud-reception
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-23 14:17
 **/
@Data
public class MallClassOne {
    /**
     * t_mall_class_1(分类1表)
     * -----------------------------
     * Id(编号)           PKInteger
     * flmch1(分类名称1)  String(100)
     *  
     */
    Integer id ;
    String flmch1;
}
