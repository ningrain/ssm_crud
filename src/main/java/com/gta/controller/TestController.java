package com.gta.controller;

import com.gta.bean.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc:
 * User: jiangningning
 * Date: 2018/1/11
 * Time: 9:57
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/ajax", method = RequestMethod.GET)
    public String ajaxTest(HttpServletRequest request, HttpServletResponse response){
        String callback = request.getParameter("callback"); // "callback" 对应ajax请求中的jsonp属性值
        String object = new Course("1", "aaa").toString();//toString()方法需要将数据拼接成json格式
        System.out.println(object);
        String s = new String(new char[]{'a', 'a'}, 3, 3);
        return callback+"(" + object + ")"; //返回数据格式
    }

    @ResponseBody
    @RequestMapping(value = "/ajax1", method = RequestMethod.POST)
    public Course ajaxTest1(HttpServletRequest request, HttpServletResponse response){
        //支持所有域名请求
        response.addHeader("Access-Control-Allow-Origin", "*");
        //支持GET、POST方法
        response.addHeader("Access-Control-Allow-Method", "POST,GET");
        return new Course("1", "aaa");
    }

    @ResponseBody
    @RequestMapping("/helloAjax1")
    public Course helloAjax1(){
        return new Course("1", "aaa");
    }

    @ResponseBody
    @RequestMapping("/helloAjax2")
    public String helloAjax2(){
        return "Hello Ajax2.";
    }

    @ResponseBody
    @RequestMapping("/helloAjax3")
    public String helloAjax3(){
        return "Hello Ajax3.";
    }

}
