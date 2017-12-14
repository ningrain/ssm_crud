package com.gta.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Desc: MyServlet1
 * User: jiangningning
 * Date: 2017/12/13
 * Time: 11:11
 */
//此注解可以省去web.xml中servlet的配置， 但二者不可共存
@WebServlet("/myServlet1")
public class MyServlet1 extends HttpServlet {

    @Override
    public void init() {
        System.out.println("servlet1初始化……");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("servlet1 doGet方法……");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.write("<h5>你好</h5>");
        pw.write("<h4>你好</h4>");
        pw.write("<h3>你好</h3>");
        pw.write("<h2>你好</h2>");
        pw.write("<h1>你好</h1>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("servlet1 doPost方法……");
    }

    @Override
    public void destroy() {
        System.out.println("servlet1 destroy……");
    }

}
