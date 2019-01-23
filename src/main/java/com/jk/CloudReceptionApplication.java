package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.jk.mapper")
@EnableFeignClients
public class CloudReceptionApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudReceptionApplication.class, args);
    }


}

