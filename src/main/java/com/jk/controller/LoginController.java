package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.User;
import com.jk.client.LoginClient;
import com.jk.utils.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    LoginClient loginClient;


    @ResponseBody
    @RequestMapping("toLoginByNameAndPassword")
    public String toLoginByNameAndPassword(User user, HttpSession session, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
       User userFromDB= loginClient.login(user);
        if (userFromDB==null) {
            return "2";
        }
            session.setAttribute("userf",userFromDB);
        if (userFromDB != null) {
            System.out.println(userFromDB);
        }
        //正确
        //判断有没有记住密码
        if (user.getRemempwd()!=null) {

//            String jsonString = JSONObject.toJSONString(user);
//            String encode = URLEncoder.encode(jsonString, "utf-8");
//            Cookie pwd = new Cookie("pwd",encode);
//            response.addCookie(pwd);
            Cookie cookie=new Cookie(Constant.remPwd,user.getName()+Constant.splitChar+user.getPassword());
            //设置cookie的时间
            cookie.setMaxAge(410381);
            cookie.setPath("/");
            //发送到浏览器上
            response.addCookie(cookie);
        }else{
            Cookie cc=new Cookie(Constant.remPwd,"");
            cc.setMaxAge(0);
            cc.setPath("/");
            response.addCookie(cc);
        }
            return "1";
    }
    @RequestMapping("toLoginHtml")
    public String toLogin(HttpServletRequest request,Model m) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constant.remPwd)) {
                    String val = cookie.getValue();
                    String[] strings = val.split(Constant.splitChar);
                    User user = new User();
                    user.setName(strings[0]);
                    user.setPassword(strings[1]);
                    m.addAttribute("user", user);
                }
            }
        }
            return "login";
        }

        @RequestMapping("toIndex")
        public String toIndex() {
            return "html/index";
        }
        @RequestMapping("toView")
        public String toView(String viewName) {

            return viewName;
        }


}


