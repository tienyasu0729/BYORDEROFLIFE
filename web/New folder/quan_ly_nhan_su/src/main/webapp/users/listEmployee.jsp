<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 3/8/2023
  Time: 9:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>Ma_nhan_vien</th>
            <th>Ho_va_ten</th>
            <th>Ngay_sinh</th>
            <th>Dia_chi</th>
            <th>Ngay_bat_dau</th>
            <th>Ngay_ket_Thuc</th>
            <th>Luong</th>
            <th>Ma_cong_viec</th>
        </tr>
        <c:forEach var="e" items="${employeeList}">
            <tr>
                <td><c:out value="${e.employeeId}"/></td>
                <td><c:out value="${e.employeeName}"/></td>
                <td><c:out value="${e.birthday}"/></td>
                <td><c:out value="${e.address}"/></td>
                <td><c:out value="${e.startDate}"/></td>
                <td><c:out value="${e.endDate}"/></td>
                <td><c:out value="${e.salary}"/></td>
                <td><c:out value="${e.jobId}"/></td>
<%--                <td>--%>
<%--                    <a href="">Edit</a>--%>
<%--                    <a href="">Delete</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>