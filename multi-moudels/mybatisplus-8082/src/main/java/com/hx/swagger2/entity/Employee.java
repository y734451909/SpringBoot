package com.hx.swagger2.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.hx.swagger2.toos.enums.GradeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="dept02") //指定数据库中的表的名称
public class Employee extends BaseEntity{
    private String name="Tom";
    private String age="18";
    private GradeEnum grade;

    @TableField(fill = FieldFill.INSERT)
    private String operator;
}
