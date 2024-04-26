<%@ page import="com.example.demojstl.modal.Student" %><%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 3/8/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail student</title>
</head>
<body>
    <h1>Detail student</h1>
    <% Student student = (Student) request.getAttribute("student"); %>
    <table>
        <tr>
            <td>ID</td>
            <td><%=student.getId()%></td>
        </tr>
        <tr>
            <td>Họ tên</td>
            <td><%=student.getName()%></td>
        </tr>
        <tr>
            <td>Giới tính</td>
            <td><%
                if (student.getSex() == 1) {
                    %>Nam<%
                } else {
                    %>Nữ <%
                }
            %></td>
        </tr>
        <tr>
            <td>Địa chỉ</td>
            <td><%=student.getAddress()%></td>
        </tr>
        <tr>
            <td>Điểm</td>
            <td><%=student.getMark()%></td>
        </tr>
    </table>
</body>
</html>
