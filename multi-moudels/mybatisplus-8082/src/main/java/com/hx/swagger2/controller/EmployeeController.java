package com.hx.swagger2.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hx.swagger2.dao.Results;
import com.hx.swagger2.entity.Dept;
import com.hx.swagger2.entity.Employee;
import com.hx.swagger2.mapper.EmployeeMapper;
import com.hx.swagger2.service.EmployeeService;
import com.hx.swagger2.toos.AuditLog;
import com.hx.swagger2.toos.BusinessType;
import com.hx.swagger2.toos.PageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import javax.validation.Valid;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Employee")
@Api(tags = "Employee增删改查接口")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private Employee employee;
    @ApiOperation(value = "查询",notes = "查询描述信息")
    @GetMapping("/all")
    public Results<List> queryUserList(){
            List<Employee> deptList= employeeService.list();
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            Results<List> results = new Results<List>(200, new Date(),"list SUCCESS",deptList);
            return results;
    }

    @ApiOperation(value = "新增",notes = "新增描述信息")
    @PostMapping
    public Results<Employee> add(@RequestBody
                      @Valid Employee employee){
        employee.setOperator(null);
        employeeService.save(employee);
        System.out.println(employee);
        Results<Employee> results = new Results<Employee>(200, new Date(),"save SUCCESS",employee);
        return results;
    }

    @ApiOperation(value = "修改",notes = "修改描述信息")
//    @AuditLog(title = "用户",desc = "修改用户",businessType = BusinessType.UPDATE)
    @PutMapping
    public Results<Employee> edit(@RequestBody
                                 @Valid Employee employee){
        employeeService.updateById(employee);
        Results<Employee> results = new Results<Employee>(200, new Date(),"save SUCCESS",employee);
        return results;
    }

    @ApiOperation(value = "单个删除",notes = "单个删除描述信息")
//    @AuditLog(title = "用户",desc = "用户",businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public Results<Long>  delete(@PathVariable Long id) {
        employeeService.removeById(id);
        Results<Long> results = new Results<Long>(200, new Date(),"delete SUCCESS",id);
        return results;
    }

    @ApiOperation(value = "单个查询",notes = "单个查询描述信息")
    @AuditLog(title = "用户",desc = "用户",businessType = BusinessType.DELETE)
    @GetMapping("/{id1}")
    public Results<Employee>  getEmployee(@PathVariable Long id1) {
        Employee employee=employeeService.getById(id1);
        Results<Employee> results = new Results<Employee>(200, new Date(),"delete SUCCESS",employee);
        System.out.println(employee.getGrade().getDescp());
        return results;
    }

    @ApiOperation(value = "分页获取",notes = "分页获取描述信息")
    @AuditLog(title = "用户",desc = "用户",businessType = BusinessType.DELETE)
    @GetMapping("/pagelist")
    public Results<Page>  pagelist(Employee employee,@Valid PageParam pageParam) {
        Wrapper wrapper=Wrappers.query(employee);
        Page<Employee> page=employeeService.page(new Page<>(pageParam.getPageNo(),pageParam.getLimit()),wrapper);
        Results<Page> results = new Results<Page>(200, new Date(),"delete SUCCESS",page);
        return results;
    }


}
