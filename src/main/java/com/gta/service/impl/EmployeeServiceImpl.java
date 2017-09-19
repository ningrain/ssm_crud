package com.gta.service.impl;

import com.gta.bean.Employee;
import com.gta.dao.EmployeeMapper;
import com.gta.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: EmployeeService实现类
 * User: jiangningning
 * Date: 2017/9/19
 * Time: 13:58
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmpls() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
