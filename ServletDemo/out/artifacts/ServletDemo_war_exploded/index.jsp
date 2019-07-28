<%--
  Created by IntelliJ IDEA.
  User: wangg
  Date: 2019/6/29
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>第一个servlet小例子</h1>
  <hr/>
  <a href="servlet/HelloServlet">Get方式请求HelloServlet</a>
  <form action="servlet/HelloServlet" method="post">
    <input type="submit" value="POST提交">
  </form>
  </body>
</html>
