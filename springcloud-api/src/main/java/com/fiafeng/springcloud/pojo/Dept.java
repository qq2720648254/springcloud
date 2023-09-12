package com.fiafeng.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) // 链式写法
public class Dept implements Serializable { // Dept 实体类
    private Long deptno; // 数据库主键

    private String dname;  // 部门表

    private String db_source;   // 数据所处数据库

    public Dept(String dname) {
        this.dname = dname;
    }
}
