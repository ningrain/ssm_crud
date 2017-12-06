package com.gta.util;

import com.gta.BaseTest;
import com.gta.service.impl.EmployeeServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * SpringUtil 测试类
 * Created by ningning.jiang on 2017/12/5.
 */
public class SpringUtilTest extends BaseTest {

    @Autowired
    private SpringUtil springUtil;

    @Test
    public void getApplicationContext() throws Exception {
    }

    @Test
    public void getBeanByName() throws Exception {
        System.out.println("Bean --> employeeServiceImpl:" + SpringUtil.getBean("employeeServiceImpl"));
    }

    @Test
    public void getBeanByClass() throws Exception {
        System.out.println("Bean --> employeeServiceImpl:" + SpringUtil.getBean(EmployeeServiceImpl.class));
    }

}