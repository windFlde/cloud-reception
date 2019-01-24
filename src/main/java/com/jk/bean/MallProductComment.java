package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: cloud-reception
 * @description:
 * @author: Mr.Xue
 * @create: 2019-01-24 18:40
 **/
@Data
public class MallProductComment {
    /**
     * t_mall_product_comment(商品评论表)
     * -----------------------------------
     * Id(编号)           PKInteger
     * yh_id(用户id)      Integer
     * plnr(评论内容)     String(1000)
     * plshj(平路时间)    Date
     * hpjb(好评级别)     Integer
     * sku_id(skuid)      Integer
     * sku_mch(sku名称)   String(100)
     * shp_id(商品id)     Integer
     * shp_mch(商品名称)  String(100)
     * dd_id(订单id)      Integer
     */
    Integer id;
    Integer yh_id;
    String plnr;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date plshj;
    Integer hpjb;
    Integer sku_id;
    String sku_mch;
    Integer shp_id;
    String shp_mch;
    Integer dd_id;
    Integer start = 0;

    String yhmz;
}
