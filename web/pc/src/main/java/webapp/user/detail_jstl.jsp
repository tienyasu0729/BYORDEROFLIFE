<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
<table>
  <tr>
    <td>ID</td>
    <td><c:out value="${student.id}" /></td>
  </tr>
  <tr>
    <td>Họ tên</td>
    <td>${student.name}</td>
  </tr>
  <tr>
    <td>Giới tính</td>
    <td>
      <c:if test="${student.sex == 1}">Nam</c:if>
      <c:if test="${student.sex == 0}">Nữ</c:if>
    </td>
  </tr>
  <tr>
    <td>Địa chỉ</td>
    <%--<td>${student.address}</td>--%>
    <td><c:out value="${student.address}" /></td>
  </tr>
  <tr>
    <td>Điểm</td>
    <td>${student.mark}</td>
  </tr>
  <tr>
    <td>Xếp loại</td>
    <td>
      <c:choose>
        <c:when test="${student.mark >= 9}">Xuất sắc</c:when>
        <c:when test="${student.mark >= 8}">Giỏi</c:when>
        <c:when test="${student.mark >= 6.5}">Khá</c:when>
        <c:when test="${student.mark >= 5}">Trung bình</c:when>
        <c:otherwise>Yêú</c:otherwise>
      </c:choose>
    </td>
  </tr>
</table>
</body>
</html>
