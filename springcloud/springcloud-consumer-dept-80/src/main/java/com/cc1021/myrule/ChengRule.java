package com.cc1021.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChengRule {

    @Bean
    public IRule myRule() {
        return new ChengRandomRule(); // 自定义策略
    }
}
