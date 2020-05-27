package com.hx.swagger2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hx.swagger2.entity.Employee;
import com.hx.swagger2.mapper.EmployeeMapper;
import com.hx.swagger2.service.EmployeeService;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImlp extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
