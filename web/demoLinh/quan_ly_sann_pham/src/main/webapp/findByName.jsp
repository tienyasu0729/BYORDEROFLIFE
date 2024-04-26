<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 05/04/2023
  Time: 4:55 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5" class="table table-hover">
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
        <c:forEach items="${listFindByName}" var="product">
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
                    <form action="/list" method="post">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="idEdit" value="${product.id}">
                        <button type="submit" class="btn btn-success"
                                onclick="return confirm('Bạn chắc chắn có muốn sửa không ?')">Edit
                        </button>
                    </form>

                    <form action="/list" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${product.id}">
                        <button type="submit" class="btn btn-danger"
                                onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Delete
                        </button>
                    </form>
                        <%--                    <form action="/list" method="post">--%>
                        <%--                        <input type="hidden" name="action" value="delete">--%>
                        <%--                        <input type="hidden" name="id" value="${product.id}">--%>
                        <%--                        <button type="submit" onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Delete</button>--%>
                        <%--                    </form>--%>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
