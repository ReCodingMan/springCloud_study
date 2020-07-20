package com.cc1021.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // eureka开启
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
