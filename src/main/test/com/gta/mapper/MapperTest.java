package com.gta.mapper;

import com.gta.bean.Department;
import com.gta.bean.Employee;
import com.gta.dao.DepartmentMapper;
import com.gta.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * Desc: MapperTest mappper测试类
 * User: jiangningning
 * Date: 2017/9/19
 * Time: 9:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private SqlSession sqlSession;

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

    @Test
    public void test4(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0,5) + i;
            employeeMapper.insert(new Employee(null, uid, "M", uid + "@gtafe.com", 1));
        }
        System.out.println("批量插入完成");
    }

    @Test
    public void test5(){
        String aa = "1,2,3,4,";
        String[] split = aa.split(",");
        System.out.println(Arrays.toString(split));
    }

    @Test
    public void test6(){
        System.out.println(departmentMapper.selectByExample(null));
    }

}
