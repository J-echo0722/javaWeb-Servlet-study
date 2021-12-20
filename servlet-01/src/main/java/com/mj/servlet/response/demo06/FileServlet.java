package com.mj.servlet.response.demo06;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author : MaJ
 * @date : 2021/12/13
 * @description ：利用 Response 响应下载文件
 */
public class FileServlet extends HttpServlet {
    // 1. 获取要下载文件的路径
    // 2. 获取文件名
    // 3. 让浏览器支持要下载的东西
    // 4. 创建下载文件的输入流 FileInputStream
    // 5. 创建 buffer 缓冲区
    // 6. 获取 OutputStream 对象
    // 7. 将 FileOutputStream 读入到 buffer 缓冲区
    // 8. buffer 缓冲区内容返回给 OutputStream 返回给客户端
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/1.jpeg");
        System.out.println("下载的路径：" + realPath);
        String fileName = realPath.substring(realPath.lastIndexOf(File.separator + 1));
        resp.setHeader("Content-Disposition", "attachment;fileName = " + URLEncoder.encode(fileName, "UTF-8"));
        FileInputStream fis = new FileInputStream(realPath);

        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream os = resp.getOutputStream();
        while ((len = fis.read(buffer)) != -1) {
            os.flush();
            os.write(buffer, 0, len);
        }

        os.close();
        fis.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
