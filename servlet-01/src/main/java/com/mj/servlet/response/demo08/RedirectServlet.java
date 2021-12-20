package com.mj.servlet.response.demo08;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : MaJ
 * @date : 2021/12/13
 * @description ：重定向
 */
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 实际对应
         * resp.setHeader("Location", "/img");
         * resp.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);   // 302
         */
        resp.sendRedirect("/img");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
