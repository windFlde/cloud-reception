package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudReceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudReceptionApplication.class, args);
    }

}

