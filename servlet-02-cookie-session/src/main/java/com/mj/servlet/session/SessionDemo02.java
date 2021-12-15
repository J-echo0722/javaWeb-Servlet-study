package com.mj.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author : MaJ
 * @date : 2021/12/15
 * @description ：session 测试
 */
public class SessionDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=utf-8");

        // 获取 session
        HttpSession session = req.getSession();
        // 获取 session 数据
        String name = (String) session.getAttribute("name");
        resp.getWriter().write("name: " + name);

        // session 删除
        session.removeAttribute("name");
        // 手动 session 失效
        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
