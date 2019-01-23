package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class MallSku {

    private Integer Id;
    private Integer shp_id;
    private Integer kc;
    private Double jg;
    private String sku_mch;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date chjshj;
    private Integer sku_xl;
    private String kcdz;

    //临时字段
    private String shp_mch;     //商品名称
    private String sh_tp;     //商品图片
    private String shp_sx;   //商品属性值和名


}
