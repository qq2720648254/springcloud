package com.fiafeng.springcloud.controller;

import com.fiafeng.springcloud.pojo.Dept;
import com.fiafeng.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignDeptConsumerController {

    @Autowired
    public DeptClientService deptClientService;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id") Long id){
        return deptClientService.queryById(id);
    }

    @GetMapping("/consumer/dept/list/")
    public List<Dept> getDeptAll(){
        return deptClientService.queryAll();
    }

    @PostMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return deptClientService.addDept(dept);
    }

}
