package com.jk.client;

import com.jk.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider")
public interface LoginClient {

    @RequestMapping("user/login")
    User login(User user);
}
