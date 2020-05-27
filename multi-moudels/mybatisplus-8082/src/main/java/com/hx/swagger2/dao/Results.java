package com.hx.swagger2.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@ApiModel("通用接口返回对象")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Results<T> {
    @ApiModelProperty(required = true,notes = "结果码",example = "200")
    private int state;
    @ApiModelProperty(required = true,notes = "时间戳",example = "2020-05-22T05:19:37.161+0000")
    private Date time;
    @ApiModelProperty(required = true,notes = "返回信息",example = "SUCCESS")
    private String message;
    @ApiModelProperty(required = true,notes = "返回数据",example = "{\"name\":\"blues\"}")
    private T content;
}
