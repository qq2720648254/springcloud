package com.fiafeng.springcloud.controller;


import com.fiafeng.springcloud.pojo.Dept;
import com.fiafeng.springcloud.service.DeptClientService;
import com.fiafeng.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供rest服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/dept/add")
    public Boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept addDept(@PathVariable Long id){
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
}
