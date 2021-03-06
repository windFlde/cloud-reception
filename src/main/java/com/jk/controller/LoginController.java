package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Shoping;
import com.jk.bean.User;
import com.jk.client.LoginClient;
import com.jk.service.ShoppingCarService;
import com.jk.utils.Constant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    @Resource
    LoginClient loginClient;

    @Resource
    private JavaMailSenderImpl mailSender;

    @Resource
    private RedisTemplate<String, Shoping> redisTemplate;


    @Resource
    ShoppingCarService shoppingCarService;

    @ResponseBody
    @RequestMapping("toLoginByNameAndPassword")
    public String toLoginByNameAndPassword(User user, HttpSession session, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
       User userFromDB= loginClient.login(user);
        if (userFromDB==null) {
            return "2";
        }
        if(userFromDB.getStatus()==2){
            return "12";
        }
            session.setAttribute("userf",userFromDB);

        String mycookie=request.getHeader("cookie");
        Cookie[] cookies = request.getCookies();
        String str = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("keyUUid")) {
                str = cookie.getValue();
            }
        }
        if (!str.equals("")) {
            List<Shoping> list = redisTemplate.opsForList().range(str, 0, -1);
            for (Shoping shoping : list) {
                shoping.setYh_id(userFromDB.getId());
                shoppingCarService.addShopping(shoping);
            }
            redisTemplate.delete(str);
        }


        if (userFromDB != null) {
            System.out.println(userFromDB);
        }
        //正确
        //判断有没有记住密码
        if (user.getRemempwd()!=null) {

            String jsonString = JSONObject.toJSONString(user);
            String encode = URLEncoder.encode(jsonString, "utf-8");
            Cookie pwd = new Cookie("pwd",encode);
            pwd.setMaxAge(410381);
            pwd.setPath("/");
            response.addCookie(pwd);

            /*将用户的用户名称存放到cookie中 start*/
            Cookie userName=new Cookie(Constant.userName,userFromDB.getUsername());
            userName.setMaxAge(410381);
            userName.setPath("/");
            response.addCookie(userName);
            /*将用户的用户名称存放到cookie中 end*/

//            Cookie cookie=new Cookie(Constant.remPwd,user.getLoginacct()+Constant.splitChar+user.getUserpswd());
//            //设置cookie的时间
//            cookie.setMaxAge(410381);
//            cookie.setPath("/");
//            //发送到浏览器上
//            response.addCookie(cookie);
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
                    user.setLoginacct(strings[0]);
                    user.setUserpswd(strings[1]);
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
    @ResponseBody
    @RequestMapping("removeUser")
    public String removeUser(HttpSession session){
            session.removeAttribute("userf");
            return "1";
        }


    @ResponseBody
    @RequestMapping("userLoginAccount")
    public String userLoginAccount(User user) {
        Integer userCount=loginClient.queryLoginAccount(user);
        if (userCount>0) {
            return "loginUser";
        }else{
            return "1";
        }
    }
    /**
     * 发送邮箱
     */
    @ResponseBody
    @RequestMapping("sendEmail")
    public String sendEmail(String username,String email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 设置收件人，寄件人
        simpleMailMessage.setTo(new String[]{email});
        simpleMailMessage.setFrom("xzh120101@163.com");
        simpleMailMessage.setSubject("注册信息");
        simpleMailMessage.setText("恭喜"+username+"注册成功！！！");
        // 发送邮件
        mailSender.send(simpleMailMessage);
        System.out.println("邮件已发送");
        return "";
    }

}


