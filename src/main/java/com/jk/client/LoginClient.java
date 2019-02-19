package com.jk.client;

import com.jk.bean.QueryParam;
import com.jk.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("provider")
public interface LoginClient {

    @RequestMapping("user/login")
    User login(User user);

    @RequestMapping("user/sendCode")
    User sendCode(QueryParam queryParam);

    @RequestMapping("user/registerUser")
    void registerUser(User user);

    @RequestMapping("user/queryLoginAccount")
    Integer queryLoginAccount(User user);

    @RequestMapping("account/getALlLoginAccount")
    List<User> getALlLoginAccount(User user);
}
