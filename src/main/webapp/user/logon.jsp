<%--
  Created by IntelliJ IDEA.
  User: Stan
  Date: 2015/8/29
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
  <form action="/login!logon.action" method="post">
    用户名：<input type="text" name="user.username"/><br> </br>
    密　码：<input type="text" name="user.password"/><br> </br>
    <input type="submit" value="登录"/>
  </form>
</body>
</html>
