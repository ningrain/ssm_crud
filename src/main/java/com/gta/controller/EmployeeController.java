package com.gta.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gta.bean.Employee;
import com.gta.service.EmployeeService;
import com.gta.singleton.Weather;
import com.gta.util.Message;
import com.gta.websocket.WebSocketTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Employee控制类
 * User: jiangningning
 * Date: 2017/9/19
 * Time: 13:57
 */
@Controller
@SuppressWarnings("unchecked")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/emps")
    @ResponseBody
    public Message getEmpPages(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber){
        PageHelper.startPage(pageNumber, 10);
        List<Employee> emps = employeeService.getAllEmpls();
        PageInfo pageInfo = new PageInfo(emps, 5);
        WebSocketTest webSocketTest = new WebSocketTest();
        webSocketTest.onMessage("websocket test");
        Weather weather = Weather.getInstance();
        return Message.success().builder("pageInfo", pageInfo).builder("weather", weather);
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

    @ResponseBody
    //  "/emp" - POST -> 保存员工
    //  "/emp/{id}" - GET -> 获取单个员工
    //  "/emp" - DELETE -> 删除员工
    //  "/emp" - PUT -> 修改员工
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public Message saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Message.success();
    }

    @ResponseBody
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public Message getEmp(@PathVariable("id") Integer id){
        //Employee employee = employeeService.getEmp(id);
        Employee employee = employeeService.getEmpWithDept(id);
        return Message.success().builder("emp", employee);
    }

    @ResponseBody
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public Message updateEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return Message.success();
    }

    @ResponseBody
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public Message delEmp(@PathVariable("ids") String ids){
        List<Integer> idList = new ArrayList<>();
        String[] strs = ids.split(",");
        for (String str : strs) {
            idList.add(Integer.valueOf(str));
        }
        employeeService.delEmpByBatch(idList);
        return Message.success();
    }

    @ResponseBody
    @RequestMapping(value = "/checkEmp", method = RequestMethod.POST)
    public Message checkEmp(String empName){
        long count = employeeService.checkEmp(empName);
        if (count == 0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }

}
