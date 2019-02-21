package com.jk.bean;

import lombok.Data;

@Data
public class QueryParam {

    String phone_no;// 发送验证码的手机号

    String verify_code;// 用户输入的验证码

    String requestUrl; //前台传过来的url



}
