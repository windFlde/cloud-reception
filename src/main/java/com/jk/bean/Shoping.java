package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Shoping implements Serializable {

    Integer Id;//(编号)          PKInteger

    Integer tjshl=1;//(添加数量)   Integer
    Integer hj;//(合计)          decimal
    Integer yh_id=1;//(用户id)     Integer
    Integer shp_id=1;//(商品id)    Integer
    Integer price=200;
    Integer sku_id=2;//(skuid)     Integer

    Integer shfxz=1;//(是否选中)   String(1)



}