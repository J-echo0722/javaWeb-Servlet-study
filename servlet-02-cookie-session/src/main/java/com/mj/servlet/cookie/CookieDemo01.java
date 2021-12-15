package com.mj.servlet.cookie;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author : MaJ
 * @date : 2021/12/14
 * @description ：cookie 测试，保存上一次访问的时间
 */
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Content-type", "text/html;charset=utf-8");

        Writer writer = resp.getWriter();

        // 获取 cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            AtomicLong lastLoginTime = new AtomicLong(0L);
            Arrays.stream(cookies)
                    .filter(cookie -> "lastLoginTime".equals(cookie.getName()))
                    .findFirst()
                    .map(Cookie::getValue)
                    .ifPresent(cookieValue -> lastLoginTime.set(Long.parseLong(cookieValue)));

            if (lastLoginTime.get() != 0L) {
                Date date = new Date(lastLoginTime.get());
                writer.write("上一次访问的时间是：" + date.toLocaleString());
            } else {
                writer.write("这是你第一次访问");
            }

        } else {
            writer.write("这是你第一次访问");
        }

        // 服务端响应一个 cookie
        Cookie cookie = new Cookie("lastLoginTime", String.valueOf(System.currentTimeMillis()));
        // 有效期，单位秒
        cookie.setMaxAge(24 * 60 * 60);

        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
