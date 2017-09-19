package com.gta.mapper;

import com.gta.bean.Department;
import com.gta.dao.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Desc: MapperTest mappper测试类
 * User: jiangningning
 * Date: 2017/9/19
 * Time: 9:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void test1(){
        System.out.println(departmentMapper);
    }

    @Test
    public void test2(){
        departmentMapper.insertSelective(new Department(null, "开发部"));
        departmentMapper.insertSelective(new Department(null, "测试部"));
    }

    @Test
    public void test3(){
        System.out.println(departmentMapper.selectByPrimaryKey(1));
    }

}
