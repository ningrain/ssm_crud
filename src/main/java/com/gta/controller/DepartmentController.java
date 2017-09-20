package com.gta.controller;

import com.gta.bean.Department;
import com.gta.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Desc: 部门控制类
 * User: jiangningning
 * Date: 2017/9/20
 * Time: 16:55
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping("/getAllDeps")
    public List<Department> getAllDeps(){
        return departmentService.getAllDeps();
    }

}
