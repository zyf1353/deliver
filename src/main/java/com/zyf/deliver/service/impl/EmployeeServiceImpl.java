package com.zyf.deliver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyf.deliver.entity.Employee;
import com.zyf.deliver.mapper.EmployeeMapper;
import com.zyf.deliver.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
