package com.mj.servlet.response.demo09;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : MaJ
 * @date : 2021/12/13 
 * @description ：
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理请求
        // 单个参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " : " + password);

        // 多个参数
        String[] hobbies = req.getParameterValues("hobby");
        if (hobbies != null) {
            for (String hobby : hobbies) {
                System.out.println(hobby);
            }
        }

        req.getRequestDispatcher("/success.jsp").forward(req, resp);
        // resp.sendRedirect(req.getContextPath() + "/success.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
