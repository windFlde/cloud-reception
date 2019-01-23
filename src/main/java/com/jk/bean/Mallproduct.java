package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Mallproduct {

    Integer id;
    String shp_mch;
    String shp_tp;
    Integer flbh1;
    Integer flbh2;
    Integer pp_id;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date chjshj;
    String shp_msh;
}

