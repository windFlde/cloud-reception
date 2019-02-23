package com.jk.controller;

import com.jk.bean.QueryParam;
import com.jk.bean.Result;
import com.jk.bean.User;
import com.jk.client.LoginClient;
import com.jk.utils.Constant;
import com.jk.utils.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("phoneLogin")
public class PhoneLoginController {

    @Resource
    LoginClient loginClient;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @ResponseBody
    @RequestMapping("sendCode")
    public Result sendCode(QueryParam queryParam) {
        Result rs = new Result();
            /*redis start*/
            // 每次都从redis中取一下当前手机号 如果有值 说明是刷新界面多次获取验证码
            Boolean hasPhone = redisTemplate.hasKey(Constant.multiple_code + queryParam.getPhone_no());
            if (hasPhone) {
                // 两次获取验证码的时间没有超过60s
                rs.setCode(2);// code =2 已经获取过验证码
            }else{
                rs.setCode(1);
                int r = (int) ((Math.random() * 8999) + 1000);
                redisTemplate.opsForValue().set(Constant.phone_code + queryParam.getPhone_no(), r+"", 30,
                        TimeUnit.MINUTES);
                System.out.println("验证码为=======================>" + r);
                HashMap<String, Object> params = new HashMap<>();
                params.put("key", "cc404476e2df5661752256e53d2743c1");
                params.put("mobile", queryParam.getPhone_no());
                params.put("tpl_id", "124829");
                params.put("tpl_value", "%23code%23%3D" + r);

                String result = HttpClient.sendGet("http://v.juhe.cn/sms/send", params);
                System.out.println(result);
                redisTemplate.opsForValue().set(Constant.multiple_code + queryParam.getPhone_no(), "jk", 60,
                        TimeUnit.SECONDS);
            }
            /*redis end*/


        return rs;
    }
    @ResponseBody
    @RequestMapping("checkCode")
    public String checkCode(QueryParam queryParam, HttpSession session) {

        String verify_code = queryParam.getVerify_code();
        //y验证验证码是不是对的
        String codeFromRedis=redisTemplate.opsForValue().get(Constant.phone_code+queryParam.getPhone_no());
        /*if start <<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        if(codeFromRedis!=null&&codeFromRedis.equals(verify_code)) {
            //用户验证码是对的;
            User userf=loginClient.sendCode(queryParam);
            /*if start----------======*/
            if(userf!=null){
                /*if start*/
                if (userf.getStatus() ==1) {
                    //用户的手机号没有在黑名单中 继续执行
                    session.setAttribute("userf", userf);
                    //登录成功后验证码就失效
                    redisTemplate.delete(Constant.phone_code+queryParam.getPhone_no());
                    return "1";
                }else{
                    //如果等于2的话 就是在黑名单中 返回2
                    return "2";
                }
                /*if end*/
            }else{
                //如果userPhone==null 用户的手机号没有在表中 返回3
                return "3";
            }
            /*if end--------------=====*/
        }
        /*if end>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
            return "";
    }

    @ResponseBody
    @RequestMapping("getALlLoginAccount")
    public String  getALlLoginAccount(User user) {
        List<User>listUserLoginAccount=loginClient.getALlLoginAccount(user);
//        redisTemplate.opsForValue().set(user.getLoginacct(),);
        for (User userList : listUserLoginAccount) {
            redisTemplate.opsForValue().set(userList.getLoginacct(),"1",1,TimeUnit.MINUTES);
        }
        return "1";
    }
    @ResponseBody
    @RequestMapping("registerUser")
    public String registerUser(User user) {
        loginClient.registerUser(user);
        redisTemplate.opsForValue().set(user.getLoginacct(),"1",1,TimeUnit.MINUTES);
        String mail="";
        mail+=user.getUsername();
        mail+="-";
        mail+=user.getEmail();
        return mail;
    }
    @ResponseBody
    @RequestMapping("haveLoginAccount")
    public String haveLoginAccount(User user) {
        String theLoginAccount=redisTemplate.opsForValue().get(user.getLoginacct());
        /*if start*/
        if (theLoginAccount!=null) {
            return "1";
        }else{
            return "2";
        }
        /*if end*/
    }

    @ResponseBody
    @RequestMapping("toBackHtml")
    public String toBackHtml(QueryParam queryParam,HttpSession session) {
        session.setAttribute("reUrl",queryParam);
        return "";
    }

}
