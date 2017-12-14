package com.gta.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/14
 * Time: 16:15
 */
public class ErrorHandler extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("ErrorHandler doGet方法……");

        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        if (statusCode != null && statusCode == 404){
            pw.write("<h1>访问出现异常,请检查您的路径</h1>");
        }else {
            pw.write("<h1>服务器内部出错：" + throwable.getMessage() + "</h1>");
            throwable.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }

}
