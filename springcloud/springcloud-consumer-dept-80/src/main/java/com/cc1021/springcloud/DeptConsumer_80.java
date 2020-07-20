package com.cc1021.springcloud;

import com.cc1021.myrule.ChengRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址和端口号
 */
@SpringBootApplication
@EnableEurekaClient // eureka开启
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = ChengRule.class)
public class DeptConsumer_80 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
