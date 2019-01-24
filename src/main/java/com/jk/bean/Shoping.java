package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Shoping implements Serializable {

    Integer Id;//(编号)          PKInteger
    Integer tjshl;//(添加数量)   Integer
    Integer yh_id;//(用户id)     Integer
    Integer sku_id;//(skuid)     Integer
    Integer price;//(物品单价)
    Integer hj;//(合计)          decimal//
    Integer shp_id;//(商品id)    Integer//
    Integer shfxz;//(是否选中)   String(1)//

}
