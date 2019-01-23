package com.jk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@EnableDiscoveryClient*/
@SpringBootApplication
@MapperScan("com.jk.mapper")
/*@EnableFeignClients*/
public class CloudReceptionApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudReceptionApplication.class, args);
    }


}

