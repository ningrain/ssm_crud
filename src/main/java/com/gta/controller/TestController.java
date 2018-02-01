package com.gta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/ajax")
    public String ajaxTest(HttpServletRequest request, HttpServletResponse response){
        String callback = request.getParameter("callback");
        String contentType = request.getContentType();
        //response.addHeader("Access-Control-Allow-Origin", "*");
        //response.addHeader("Access-Control-Allow-Method", "POST,GET");
        return callback+"('hello world')";
    }

}
