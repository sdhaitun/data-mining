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
    <title>欢迎进入</title>
  <script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>


</head>
<body>
  登录成功
  <div class="container">

    <!-- Main hero unit for a primary marketing message or call to action-->
    <div class="hero-unit" style="height:379px;">
      <table align="center" style="width:500px;text-align:center;" class="table-striped table-bordered">
        <tr style="color:red"><th>用户名</th><th>操作</th></tr>
        <s:iterator value="users" var="user" status="userStatus">
          <tr style="background:<s:if test="#userStatus.odd == true">#DFF0D8</s:if><s:else>#D9EDF7</s:else>;">
            <td><s:property value="#user.username"/></td>
            <td>
              <a href="user!edit.action?id=<s:property value="#user.id"/>">编辑</a>
              <a href="user!delete.action?id=<s:property value="#user.id"/>" class="delete">删除</a>
            </td>
          </tr>
        </s:iterator>
      </table>

    </div>

 <!-- <script>
    $(document).ready(function(){
      $.ajax({
        type: "GET",
        url: "/json-listUsers.action",
        data: {
          title: 'test'
        },
        dataType: "json",
        success: function (result) {
          var users = result.users;
          for (var index in users) {
            var user = users[index];
            document.write(user.username + "<br>");
          }
        }
      });
    });

  </script>-->
  </div>
</body>
</html>
