package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Shoping implements Serializable {

    Integer id;//(编号)          PKInteger

    Integer tjshl;//(添加数量)   Integer
    Integer hj;//(合计)          decimal
    Integer yh_id=0;//(用户id)     Integer
    Integer shp_id;//(商品id)    Integer
    Integer price;
    Integer sku_id;//(skuid)     Integer

    Integer shfxz=1;//(是否选中)   String(1)



    Double jg;
    String mch;
    String shptp;
    Date sj;

}
