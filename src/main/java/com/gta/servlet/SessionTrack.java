package com.gta.servlet;

import com.gta.util.SecContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Desc:
 * User: jiangningning
 * Date: 2017/12/14
 * Time: 16:54
 */
@WebServlet("/sessionTrack")
public class SessionTrack extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        long creationTime = session.getCreationTime();
        System.out.println("session创建日期：" + new Date(creationTime));

        long lastAccessedTime = session.getLastAccessedTime();
        System.out.println("session最后访问时间：" + new Date(lastAccessedTime));

        System.out.println("sessionId=" + session.getId());
        SecContext.getInstance().addSession(session.getId(), session);
        System.out.println(SecContext.getSessionMap());

    }
}
