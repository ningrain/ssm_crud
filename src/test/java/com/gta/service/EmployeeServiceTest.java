package com.gta.service;

import com.gta.BaseTest;
import com.gta.bean.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * EmployeeService接口测试类
 * Created by ningning.jiang on 2017/9/21.
 */
public class EmployeeServiceTest extends BaseTest {



    @Autowired
    private EmployeeService employeeService;

    @Test
    public void checkEmp() {
        System.out.println(employeeService.checkEmp("7c2ca56"));
    }

    @Test
    public void getEmp(){
        //EmployeeService employeeService1  = SpringContextUtil.getBean("employeeServiceImpl");
        System.out.println(employeeService.getEmp(107));
    }

    @Test
    public void getAllEmpls(){
        List<Employee> emps = employeeService.getAllEmpls();
        for (Employee emp : emps) {
            System.out.println(emp.toString());
        }
    }
}