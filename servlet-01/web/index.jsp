<%--
  Created by IntelliJ IDEA.
  User: Shanzhen
  Date: 2021/12/2
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World!</title>
</head>
<body>
    <h1>Hello World!</h1>
    <p>今天的日期是：<%=new java.util.Date().toLocaleString()%></p>

    <%-- 这里提交的路径，需要找到项目到路径--%>
    <%-- ${pageContext.request.getContextPath()} 代表当前项目 --%>
    <div style="text-align: center">
        <form action="${pageContext.request.getContextPath()}/login" method="get">
            <label>
                用户名：<input type="text" name="username"><br>
                密码：<input type="password" name="password"><br>
                <input type="checkbox" name="hobby" value="唱歌">唱歌<br>
                <input type="checkbox" name="hobby" value="跳舞">跳舞<br>
                <input type="checkbox" name="hobby" value="打球">打球<br>
                <input type="checkbox" name="hobby" value="电影">电影<br>®
            </label>
            <input type="submit">
        </form>
    </div>
</body>

</html>
