package com.hx.swagger2.controller;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.hx.swagger2.dao.Results;
import com.hx.swagger2.dao.UserVO;
import com.hx.swagger2.mapper.DeptMapper;
import com.hx.swagger2.entity.Dept;
import com.hx.swagger2.toos.AuditLog;
import com.hx.swagger2.toos.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/Dept")
@Api(tags = "Dept增删改查接口")
public class DeptController {
    @Autowired
    private DeptMapper deptMapper;
    private Dept dept;
    @ApiOperation("查询")
    @GetMapping("/all")
    public Results<List> queryUserList(){
            List<Dept> deptList=deptMapper.selectList(null);
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            Results<List> results = new Results<List>(200, new Date(),"SUCCESS",deptList);
            return results;
    }

    @ApiOperation(value = "新增",notes="新增用户的接口描述")
    @AuditLog(title = "desc用户",desc = "desc增加用户",businessType = BusinessType.INSERT)
    @PostMapping
    public Results<Dept> add(@RequestBody
                      @Valid Dept dept){
        deptMapper.insert(dept);
        Results<Dept> results = new Results<Dept>(200, new Date(),"SUCCESS",dept);
        return results;
    }

}
