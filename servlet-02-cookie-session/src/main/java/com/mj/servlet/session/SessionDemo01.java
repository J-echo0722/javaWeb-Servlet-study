package com.mj.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author : MaJ
 * @date : 2021/12/15
 * @description ：session 测试
 */
public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=utf-8");

        // 获取 session
        HttpSession session = req.getSession();
        // 给 session 数据
        session.setAttribute("name", "maj");
        String sessionId = session.getId();
        System.out.println("sessionId: " + sessionId);

        if (session.isNew()) {
            resp.getWriter().write("session 创建成功，sessionId: " + sessionId);
        } else {
            resp.getWriter().write("session 已经在服务器中存在，sessionId: " + sessionId);
        }
        /*
            // 创建 session 的时候做了
            Cookie cookie = new Cookie("JSESSIONID", sessionId);
            resp.addCookie(cookie);
        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
