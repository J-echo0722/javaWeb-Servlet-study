package com.mj.servlet.servletContext.demo04;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : MaJ
 * @date : 2021/12/3
 * @description ：转发
 */
public class Dispatcher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        System.out.println("进入了 Servlet demo04");
        // 参数为转发的请求路径
        RequestDispatcher requestDispatcher = context.getRequestDispatcher("/url");
        // 调用 forward 实现请求转发
        requestDispatcher.forward(req, resp);

        // context.getRequestDispatcher("/url").forward(req,resp);      // 合起来写
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
