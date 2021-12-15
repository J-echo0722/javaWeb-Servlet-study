package com.mj.servlet.helloServlet.demo01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : MaJ
 * @date : 2021/12/2
 * @description ：
 */
public class HelloServlet extends HttpServlet {
    // 由于 get 或 post 只是请求实现不同的方式，可以相互调用，业务逻辑都一样

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入了 doGet 方法");
        // 响应流
        PrintWriter writer = resp.getWriter();
        writer.print("hello, Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
