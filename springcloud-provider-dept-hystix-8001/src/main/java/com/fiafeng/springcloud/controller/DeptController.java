package com.fiafeng.springcloud.controller;


import com.fiafeng.springcloud.pojo.Dept;
import com.fiafeng.springcloud.service.DeptClientService;
import com.fiafeng.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供rest服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("id不存在");
        }

        return deptService.queryById(id);
    }

    // 备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept().setDname("id=>" + id + "数据库中没有对应的信息,null--@Hystrix")
                .setDeptno(id)
                .setDb_source("没有这个数据");
    }


}
