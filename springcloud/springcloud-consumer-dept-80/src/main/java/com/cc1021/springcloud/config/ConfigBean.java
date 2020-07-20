package com.cc1021.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration -- spring  applicationContext.xml
 */
@Configuration
public class ConfigBean {

    /**
     * 配置负载均衡实现 RestTemplate
     * @return
     */
    @Bean
    @LoadBalanced // Ribbon
    // IRule
    // AbstractLoadBalancerRule：会先过滤掉，跳闸/访问故障的服务～ 对剩下的进行轮询
    // RoundRobinRule：轮询
    // RandomRule：随机
    // RetryRule：会先按轮询获取服务～ 如果服务获取失败，则会在指定的时间内进行重试
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
