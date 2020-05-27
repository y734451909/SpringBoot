package com.hx.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/porosDemoUser")
@Api(tags = "增删改查接口")
public class Controller {
    @ApiOperation("查询")
    @GetMapping("/all")
    public String queryUserList(){
        return "查询是否正确";
    }
    @ApiOperation("修改")
    @GetMapping("/edit")
    public String edit(){
        return "修改 is OK!";
    }
    @ApiOperation("删除")
    @GetMapping("/delete")
    public String delete(){
        return "删除 is OK!";
    }
}
