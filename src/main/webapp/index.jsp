<%--
  Created by IntelliJ IDEA.
  User: bottle
  Date: 2022/4/14
  Time: 23:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>功能入口</title>
    <base href="<%=basePath%>"/>
</head>
<body>
<table>
    <tr>
        <td><a href="addUser.jsp">注册用户</a></td>
    </tr>
    <tr>
        <td><a href="listUser.jsp">浏览用户</a></td>
    </tr>
</table>
</body>
</html>
