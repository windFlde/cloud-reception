package com.jk.client;

import com.jk.bean.MallAttr;
import com.jk.bean.MallValue;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("service-houtai")
public interface ProductClient {

    @RequestMapping("getSx")
    List<MallAttr> getSx(String id);

    @RequestMapping("getValue")
    List<MallValue> getValue(String ids);
}
