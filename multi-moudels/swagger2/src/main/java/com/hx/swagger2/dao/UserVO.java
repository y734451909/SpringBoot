package com.hx.swagger2.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("用户对象")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVO {

    @ApiModelProperty(required = true,notes = "用户名",example = "blues")
    private String name;

    @ApiModelProperty(required = true,notes = "用户返回消息",example = "hello world")
    private String words;

}
