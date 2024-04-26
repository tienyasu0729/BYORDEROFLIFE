<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/03/2023
  Time: 6:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DANH SÁCH KHÁCH HÀNG</title>
</head>
<body>
<h1>DANH SÁCH KHÁCH HÀNG</h1>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa chỉ</th>
        <th>Hình ảnh</th>
    </tr>
    <c:forEach items="${customers}" var="c">
        <tr>
            <td>${c.name}</td>
            <td>${c.birth}</td>
            <td>${c.address}</td>
            <td><img src="${c.img}" alt=""></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
