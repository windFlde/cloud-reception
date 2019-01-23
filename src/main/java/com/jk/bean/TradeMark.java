package com.jk.bean;

import lombok.Data;

@Data
public class TradeMark {

    Integer id; //(编号)         PKInteger
    String ppmch; //(品牌名称)  String(100)
    String url; //(品牌图片)    String(100)
}
