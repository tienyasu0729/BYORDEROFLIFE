<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 16/05/2023
  Time: 12:34 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<center>
    <h1>Danh sách sách</h1>
</center>

<div align="center">
    <table class="table table-hover" STYLE="text-align: center">
<%--        <h2>Danh sách sách</h2>--%>
        <caption><h2>Danh sách sách</h2></caption>
        <tr>
            <th>Mã sách</th>
            <th>Tên sách</th>
            <th>Tác giả</th>
            <th>Số lượng</th>
            <th>Mô tả</th>
            <th>Thanh công cụ</th>
        </tr>
        <c:forEach items="${list_book}" var="book">
            <tr>
                <td><c:out value="${book.id_book}"/></td>
                <td><c:out value="${book.name_book}"/></td>
                <td><c:out value="${book.author_book}"/></td>
                <td><fmt:formatNumber value="${book.quantity_book}" pattern="###,###,###,###"/></td>
                <td><c:out value="${book.describe_book}"/></td>
                <td>
                    <button type="button" class="btn btn-danger">Mượn sách
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
