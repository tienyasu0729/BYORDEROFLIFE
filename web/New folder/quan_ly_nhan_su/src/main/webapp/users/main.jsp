<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 29/03/2023
  Time: 6:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>MENU QUẢN LÝ NHÂN SỰ</h1>
    <form method="get" action="/EmployeeServlet">
<%--        <a href="/EmployeeServlet" >--%>
            <input type="submit" name="action" value="List">
<%--        </a>--%>
        <br>
<%--        <a href="/users/addEmployee.jsp">--%>
            <input type="submit" name="action" value="Add">
<%--        </a>--%>
    </form>
<%--<form method="post" action="/EmployeeServlet">--%>
<%--    <input type="submit" name="destination" value="Danh sách nhân viên1">--%>
<%--</form>--%>
<%--<form method="post" action="/users/addEmployee.jsp">--%>
<%--    <input type="submit" name="destination" value="Danh sách nhân viên2">--%>
<%--</form>--%>
</body>
</html>
