<%--
  Created by IntelliJ IDEA.
  User: bottle
  Date: 2022/4/16
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>查询</title>
    <base href="<%=basePath%>"/>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btnLoader").click(function () {
                $.ajax({
                    url: "user/queryUser.do",
                    type: "get",
                    dataType: "json",
                    success: function (data) {
                        $("#info").html("");
                        $.each(data, function (i, n) {
                            $("#info").append("<tr>")
                                .append("<td>" + n.id + "</td>")
                                .append("<td>" + n.name + "</td>")
                                .append("</tr>")
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
<div align="center">
    <table>
        <tr>
            <td>学号</td>
            <td>姓名</td>
        </tr>
    </table>
    <table id="info">

    </table>
    <input type="button" id="btnLoader" value="查询数据">
</div>
</body>
</html>
