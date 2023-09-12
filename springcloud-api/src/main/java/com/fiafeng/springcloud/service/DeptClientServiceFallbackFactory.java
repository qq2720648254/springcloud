package com.fiafeng.springcloud.service;


import com.fiafeng.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id).setDname("id=>" + id + "没有对应信息，客户端提供降级信息，这个服务已经被关闭").setDb_source("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
