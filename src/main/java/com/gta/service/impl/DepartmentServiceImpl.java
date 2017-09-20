package com.gta.service.impl;

import com.gta.bean.Department;
import com.gta.dao.DepartmentMapper;
import com.gta.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Desc: DepartmentService实现类
 * User: jiangningning
 * Date: 2017/9/20
 * Time: 16:58
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAllDeps() {
        return departmentMapper.selectByExample(null);
    }
}
