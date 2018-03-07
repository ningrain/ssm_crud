package com.gta.util;

import com.gta.BaseTest;
import com.gta.service.impl.EmployeeServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SpringUtil 测试类
 * Created by ningning.jiang on 2017/12/5.
 */
public class SpringUtilTest extends BaseTest {

    @Autowired
    private SpringContextUtil springUtil;

    @Test
    public void getApplicationContext() {
    }

    @Test
    public void getBeanByName() {
        System.out.println("Bean --> employeeServiceImpl:" + SpringContextUtil.getBean("employeeServiceImpl"));
    }

    @Test
    public void getBeanByClass() {
        System.out.println("Bean --> employeeServiceImpl:" + SpringContextUtil.getBean(EmployeeServiceImpl.class));
    }

}