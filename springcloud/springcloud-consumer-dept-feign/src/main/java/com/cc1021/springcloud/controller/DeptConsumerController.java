package com.cc1021.springcloud.controller;

import com.cc1021.springcloud.pojo.Dept;
import com.cc1021.springcloud.service.DeptClientService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    /**
     * http://localhost:8001/dept/list
     *
     * @param id
     * @return
     */
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.deptClientService.queryById(id);
    }

    /**
     * 新增
     * @param dept
     * @return
     */
    @RequestMapping("/consumer/dept/add")
    public boolean add (Dept dept) {
        return this.deptClientService.addDept(dept);
    }

    /**
     * 列表
     * @return
     */
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list () {
        return this.deptClientService.queryAll();
    }
}
