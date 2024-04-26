<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 6/7/2023
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang danh sách</h1>
<a href="/student/add">Thêm mới</a>

<table>
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <td>Detail</td>
        <td>Delete</td>
    </tr>
  <c:forEach varStatus="status" var="student" items="${studentList}">
      <tr>
          <td>${status.count}</td>
          <td>${student.id}</td>
          <td>${student.name}</td>
          <td><a href="/student/detail?id=${student.id}">Detail</a></td>
          <td><a href="/student/delete/${student.id}/${student.name}">Delete</a></td>
      </tr>
  </c:forEach>
</table>

</body>
</html>
