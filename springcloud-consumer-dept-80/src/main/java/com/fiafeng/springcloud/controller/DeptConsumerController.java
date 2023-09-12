package com.fiafeng.springcloud.controller;

import com.fiafeng.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class DeptConsumerController {
    @Autowired
    public RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX =  "http://springcloud-provider-dept/";
//    private static final String REST_URL_PREFIX =  "http://localhost:8001/";
    private static final String REST_URL_PREFIX =  "http://SPRINGCLOUD-PROVIDER-DEPT/";

    @GetMapping("/consumer/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/get/" + id, Dept.class);
    }

    @GetMapping("/consumer/dept/list/")
    public List<Dept> getDeptAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "dept/list", List.class);
    }

    @PostMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return Boolean.TRUE.equals(restTemplate.postForObject(REST_URL_PREFIX + "dept/add/", dept, Boolean.class));
    }

}
