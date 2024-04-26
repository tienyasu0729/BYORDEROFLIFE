<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Student list</title>
</head>
<body>
  <h1>Student list</h1>
  <table>
    <tr>
      <th>ID</th>
      <th>Họ tên</th>
      <th>Giới tính</th>
      <th>Địa chỉ</th>
      <th>Điểm</th>
    </tr>
    <c:forEach items="${students}" var="s">
      <tr>
        <td>${s.id}</td>
        <td>${s.name}</td>
        <td>
          <c:if test="${s.sex == 1}">Nam</c:if>
          <c:if test="${s.sex == 0}">Nữ</c:if>
        </td>
        <td>${s.address}</td>
        <td>${s.mark}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
