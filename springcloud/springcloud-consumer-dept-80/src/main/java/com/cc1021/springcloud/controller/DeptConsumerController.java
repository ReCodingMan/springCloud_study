package com.cc1021.springcloud.controller;

import com.cc1021.springcloud.pojo.Dept;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    // 理解：消费者，不应该有 service 层～
    // RestTemplate... 供我们直接调用就可以了！注册到 spring 中
    // (url, 实体:Map, Class<T> responseType)

    @Autowired
    private RestTemplate restTemplate; // 提供多种便捷访问远程http服务的方法，简单的 restful 服务模版～

    // Ribbon。我们这里的地址，应该是一个变量，通过服务名来访问
    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    /**
     * http://localhost:8001/dept/list
     *
     * @param id
     * @return
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    /**
     * 新增
     * @param dept
     * @return
     */
    @RequestMapping("/consumer/dept/add")
    public boolean add (Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    /**
     * 列表
     * @return
     */
        @RequestMapping("/consumer/dept/list")
    public List<Dept> list () {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}
