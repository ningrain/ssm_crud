package com.gta.service.impl;

import com.gta.annotation.DataSourceAnnotation;
import com.gta.bean.Employee;
import com.gta.bean.EmployeeExample;
import com.gta.dao.EmployeeMapper;
import com.gta.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        //int a = 1 / 0;
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.setOrderByClause("emp_id");
        return employeeMapper.selectByExampleWithDept(employeeExample);
    }

    public int saveEmp(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    public long checkEmp(String name) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpNameEqualTo(name);
        return employeeMapper.countByExample(employeeExample);
    }

    public Employee getEmp(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    //@Annotation1
    @DataSourceAnnotation
    public Employee getEmpWithDept(Integer id) {
        return employeeMapper.selectByPrimaryKeyWithDept(id);
    }

    public int updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public int delEmpByBatch(List<Integer> ids) {
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andEmpIdIn(ids);
        return employeeMapper.deleteByExample(employeeExample);
    }

    @RequiresRoles({"admin"})
    public void testMethod() {
        System.out.println("testMethod, time: " + new Date());
        Session session = SecurityUtils.getSubject().getSession();
        Object val = session.getAttribute("key");
        System.out.println("Service SessionVal: " + val);
    }
}
