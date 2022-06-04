<%--
  Created by IntelliJ IDEA.
  User: bottle
  Date: 2022/4/14
  Time: 23:46
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
    <title>注册用户</title>
    <base href="<%=basePath%>" />
</head>
<body>
    <div align="center">
        <form action="/ssm_war/user/loginUser.do" method="post">
            <table>
                <tr>
                    <td>姓名：</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="text" name="password"></td>
                </tr>
                <tr>
                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                    <td><input type="submit" value="注册"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
