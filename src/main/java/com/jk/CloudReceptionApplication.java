package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.jk.mapper")
public class CloudReceptionApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudReceptionApplication.class, args);
    }


}

