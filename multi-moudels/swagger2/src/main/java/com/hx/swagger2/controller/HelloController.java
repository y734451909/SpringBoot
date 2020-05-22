package com.hx.swagger2.controller;

import com.hx.swagger2.dao.Results;
import com.hx.swagger2.dao.UserVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

@Api(tags = "统一响应 测试功能接口")
@RestController
public class HelloController {

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "用户名称",required = true,dataType = "String",paramType = "path",example = "blues")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "接口返回成功状态"),
            @ApiResponse(code = 500, message = "接口返回未知错误，请联系开发人员调试")
    })
    @ApiOperation(value = "Hello 测试接口", notes = "访问此接口，返回hello语句，测试接口")
    @GetMapping("hello/{name}")
    public Results<UserVO> hello(@PathVariable String name){
        UserVO userVO = new UserVO(name,"hello " + name);
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        Results<UserVO> results = new Results<UserVO>(200, date,"SUCCESS", userVO);
        return results;
    }

}
