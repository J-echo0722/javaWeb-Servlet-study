## web.xml 基础模板
```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">

</project>
```


## demo01
```
HelloServlet 熟悉过程原理
1. 自写 HelloServlet 类，继承 HttpServlet，声明是一个 Servlet 程序，重写 doGet 和 doPost 方法
2. web.xml 中注册 HelloServlet，并且配置服务器访问路径 和 HelloServlet 的映射关系
   (用户请求访问的是 web 服务器，web 服务器需根据用户访问路径来调用具体的 Servlet 程序，故需将访问路径和Servlet处理程序做映射) 
3. 配置 tomcat，用来接受 web 请求，返回响应，注意 artifacts 需由具体项目 modules 生成。
4. 启动测试（浏览器输入第2步中配置的路径）
```

## demo02
```
利用 ServletContext 的特性，实现共享数据
特性：web 容器启动的时候，会为每一个 web 应用程序生成一个对应的 Servlet 对象：ServletContext，它代表了该 web 应用
1. SetServlet 往 ServletContext 中存入数据，利用 setAttribute 方法
2. GetServlet 从 ServletContext 中取出数据，利用 getAttribute 方法
注意：
- web.xml 中注册 SetServlet 和 GetServlet，并配置映射关系
- 启动测试时，先访问 SetServlet 的访问路径，再访问 GetServlet 访问路径
```

## demo03
```
利用 ServletContext 的特性，获取 web 应用的初始化参数
web.xml 中，可利用 <context-param> 标签设置一些 web 应用初始化参数，注册 Servlet 实现类后，通过 ServletContext 取出
```

## demo04
```
利用 ServletContext 的特性，进行请求转发
请求转发：不改变用户端访问路径，页面变了
eg. A请求B，B发现没有A请求的东西，去C拿，由B返回给A
利用 getRequestDispatcher 获取要转发的路径，生成 RequestDispatcher 对象，再利用刚刚生成的对象的forward 方法实现请求转发
```

## demo05
```
利用 ServletContext 的特性，读取资源文件 db.properties（实际读取的是编译后的类路径下的资源文件）
```