package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {


    Integer id;
    String loginacct;
    String userpswd;
    String remempwd;
    String username;
    String email;
    Date createtime;
    Integer status;
    String phone;

}
