package com.hx.swagger2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@TableName(value="dept01") //指定数据库中的表的名称
public class Dept{
    @TableId(value = "deptno",type = IdType.AUTO)
    private Long deptno;
    private String dname;
    private String dbSource;
}
