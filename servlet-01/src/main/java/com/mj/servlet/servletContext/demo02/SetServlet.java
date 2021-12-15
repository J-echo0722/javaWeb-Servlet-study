package com.mj.servlet.servletContext.demo02;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : MaJ
 * @date : 2021/12/3
 * @description ：ServletContext 共享数据 ———— 存数据
 */
public class SetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // this.getInitParameter()          初始化配置
        // this.getServletConfig()         Servlet 配置
        // this.getServletContext()        Servlet 上下文
        ServletContext context = this.getServletContext();

        // 将一个数据保存在 ServletContext 中
        String userName = "MaJun";
        context.setAttribute("userName", userName);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
