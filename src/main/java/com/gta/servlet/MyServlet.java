package com.gta.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/13
 * Time: 11:11
 */
//此注解可以省去web.xml中servlet的配置， 但二者不可共存
@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("servlet初始化……");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("servlet doGet方法……");
        int a = 1 / 0;
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("servlet doPost方法……");
        System.out.println("请求参数：parm1=" + req.getParameter("parm1"));
        resp.sendRedirect(req.getContextPath() + "/myServlet1");
    }

    @Override
    public void destroy() {
        System.out.println("servlet destroy……");
    }

}
