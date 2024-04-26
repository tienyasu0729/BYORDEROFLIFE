<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 27-Mar-23
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        .form-edit, .form-delete {
            display: inline-block;
        }

        .form-edit button, .form-delete button {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<center>
    <h1>Quản lý nhân viên</h1>
    <h2>
<%--        <a href="/list?action=create">Thêm mới sản phẩm mới</a>--%>
<%--        <br>--%>
<%--        <a href="/list">Tải lại</a>--%>
        <form method="post" action="/list">
            <input type="hidden" name="action" value="create">
            <button class="btn btn-success">Thêm mới sản phẩm mới</button>
        </form>
    </h2>
    <div class="search">
        <form action="/list" method="post">
            <h2>Tìm kiếm sản phẩm</h2>
            <input type="text" name="findName" placeholder="Tìm theo tên">
            <input type="submit" value="search" name="action2">
        </form>
    </div>
</center>
<div align="center">
    <table class="table table-hover">
        <h2>List of Users</h2>
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>màu sắc</th>
            <th>Mô tả</th>
            <th>Danh mục</th>

        </tr>
        <c:forEach items="${listProduct}" var="product">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><fmt:formatNumber value="${product.price}" pattern="###,###,###,###"/></td>
                <td><c:out value="${product.quantity}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.idCategory}"/></td>
                <td>
<%--                    <a href="/list?action=edit&idEdit=${product.id}">Edit</a>--%>
<%--                    <a href="/list?action=delete&id=${product.id}" onclick="confirm('bạn chắc chưa')">Delete</a>--%>

                    <form action="/list" method="post" class="form-edit">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="idEdit" value="${product.id}">
                    <button type="submit" class="btn btn-success" onclick="return confirm('Bạn chắc chắn có muốn sửa không ?')">Edit</button>
                    </form>

                    <form action="/list" method="post" class="form-delete">
                        <input type="hidden" name="action2" value="delete">
                        <input type="hidden" name="id" value="${product.id}">
                        <button type="submit" class="btn btn-danger" onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Delete</button>
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
