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
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
            integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<center>
    <h1>Danh sách sách</h1>
</center>
<form action="/library" method="post">
    <button type="submit" name="post_action" value="list_borrow_book">Danh sách mượn</button>
</form>
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
<%--                    do đề chưa đầy đủ nên làm theo kiểu của em--%>

                    <c:choose>
                        <c:when test="${book.quantity_book == 0}">
                            <button type="button" class="btn btn-success" onclick="alert('Hết sách để mượn')">Mượn sách</button>
                        </c:when>
                        <c:otherwise>
                            <form action="/library" method="post">
                                <input type="hidden" name="id_book_borrow" value="${book.id_book}">
                                <input type="hidden" name="name_borrow_book" value="${book.name_book}">
                                <input type="hidden" name="post_action" value="button_borrow_book">
                                <button type="submit" class="btn btn-success">Mượn sách</button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script>
    // function button_borrow_book(id_book,name_book,quantity_book){
    //     alert(quantity_book)
    //     if (quantity_book === 0){
    //         alert("Đã hết sách để cho mượn.");
    //     }else {
    //         let xhr = new XMLHttpRequest();
    //         xhr.onreadystatechange = function () {
    //             if (this.readyState == 4 && this.status == 200) {
    //                 var result = this.responseText;
    //                 alert(result);
    //             }
    //         };
    //         xhr.open("POST", "/library_Servlet", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    //         xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    //         var data = "post_action=button_borrow_book"+ "&id_book_borrow=" + encodeURIComponent(id_book)+ "&name_borrow_book=" + encodeURIComponent(name_book); // Tạo dữ liệu gửi đi
    //         xhr.send(data); // Gửi dữ liệu đi
    //     }
    // }


</script>
</body>
</html>
