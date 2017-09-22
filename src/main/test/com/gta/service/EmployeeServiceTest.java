package com.gta.service;

import com.gta.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * EmployeeService接口测试类
 * Created by ningning.jiang on 2017/9/21.
 */
public class EmployeeServiceTest extends BaseTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void checkEmp() throws Exception {
        System.out.println(employeeService.checkEmp("bbbb"));
    }

    @Test
    public void getEmp(){
        System.out.println(employeeService.getEmp(1006).toString());
    }

}