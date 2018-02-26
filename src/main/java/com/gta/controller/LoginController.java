package com.gta.controller;

import com.gta.service.EmployeeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/2/26
 * Time: 9:12
 */
@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        // 获取当前的Subject对象
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            // 把用户名、密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                // 执行登录
                currentUser.login(token);
            // AuthenticationException 所有认证时异常的父类
            } catch (AuthenticationException e) {
                System.out.println("登录失败：" + e.getMessage());
            }
        }
        return "list";
    }

    @RequestMapping("/testShiroAnnotation")
    public String testShiroAnnotation(HttpSession session){
        session.setAttribute("key", "value123456");
        try {
            employeeService.testMethod();
        } catch (UnauthorizedException e) {
            throw new UnauthorizedException("未经授权，禁止访问");
        }
        return "list";
    }

    @RequestMapping("/user")
    public String toUserPage(){
        return "user";
    }

    @RequestMapping("/admin")
    public String toAdminPage(){
        return "admin";
    }

    @RequestMapping("/unauthorized")
    public String toUnauthorizedPage(){
        return "unauthorized";
    }

    public static void main(String[] args) {
        String hashAlgorithmName = "MD5";
        Object credentials = "123456";
        Object salt = null;
        int hashIterations = 1024;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(simpleHash);
    }

}
