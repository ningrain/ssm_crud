package com.gta.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gta.bean.Employee;
import com.gta.service.EmployeeService;
import com.gta.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Desc: Employee控制类
 * User: jiangningning
 * Date: 2017/9/19
 * Time: 13:57
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/emps")
    @ResponseBody
    public Message getEmpPages(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber){
        PageHelper.startPage(pageNumber, 5);
        List<Employee> emps = employeeService.getAllEmpls();
        PageInfo pageInfo = new PageInfo(emps, 5);
        return Message.success().builder("pageInfo", pageInfo);
    }

    //@RequestMapping("/emps")
    public String getAllEmps(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                             Model model){

        PageHelper.startPage(pageNumber, 5);
        List<Employee> emps = employeeService.getAllEmpls();

        PageInfo pageInfo = new PageInfo(emps, 5);

        model.addAttribute("pageInfo", pageInfo);

        return "list";
    }

}
