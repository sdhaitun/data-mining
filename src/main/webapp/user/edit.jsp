<%--
  Created by IntelliJ IDEA.
  User: Stan
  Date: 2015/8/30
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>edit user</title>
</head>
<body>
  <!--<form action="user!save.action" method="post">
    <input type="hidden" name="user.id" value="${user.id}"/>
    <input type="text" name="user.username" value="${user.username}"/>
    <input type="text" name="user.password" value="${user.password}"/>
    <input type="submit" value="确定"/>
  </form>-->

         
  <form action="user!save.action" method="post">
    <input type="hidden" name="user.id" value="${user.id}"/>
    用户名：<s:textfield name="user.username"/> <br>
    密　码：<s:textfield name="user.password" /> <br>

    <input type="submit" value="确定"/>
  </form>
</body>
</html>
