package com.gta.service;

import com.gta.bean.Employee;

import java.util.List;

/**
 * Employee接口
 * Created by ningning.jiang on 2017/9/19.
 */
public interface EmployeeService {
    List<Employee> getAllEmpls();

    int saveEmp(Employee employee);

    long checkEmp(String name);

    Employee getEmp(Integer id);

    int updateEmployee(Employee employee);

    int delEmpByBatch(List<Integer> ids);
}
