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
<h1>Tên sách</h1>
<form action="/library" method="post">
  <input type="text" name="name_book_to_find_list_borrow_book">
  <button type="submit" name="post_action" value="find_list_borrow_book_by_name_book">Tìm Kiếm</button>
</form>
<h1>Tên hs</h1>
<form action="/library" method="post">
  <input type="text" name="name_student_to_find_list_borrow_book">
  <button type="submit" name="post_action" value="find_list_borrow_book_by_name_student">Tìm Kiếm</button>
</form>
<div align="center">
  <table class="table table-hover" STYLE="text-align: center">
    <%--        <h2>Danh sách sách</h2>--%>
    <caption><h2>Danh sách sách</h2></caption>
    <tr>
      <th>Mã mượn sách</th>
      <th>Tên sách</th>
      <th>Tác giả</th>
      <th>Tên học sinh</th>
      <th>Lớp</th>
      <th>Ngày mượn</th>
      <th>Ngày trả</th>
      <th>Thanh công cụ</th>
    </tr>
    <c:forEach items="${list_borrow_books}" var="listBorrowBook">
      <tr>
        <td><c:out value="${listBorrowBook.getBook_loan_card().getId_loan_card()}"/></td>
        <td><c:out value="${listBorrowBook.getBook().getName_book()}"/></td>
        <td><c:out value="${listBorrowBook.getBook().getAuthor_book()}"/></td>
        <td><c:out value="${listBorrowBook.getStudent().getName_Student()}"/></td>
        <td><c:out value="${listBorrowBook.getStudent().getId_Student()}"/></td>
        <td><fmt:formatDate value="${listBorrowBook.getBook_loan_card().getBorrowed_date()}" pattern="dd/MM/yyyy"/></td>
        <td><fmt:formatDate value="${listBorrowBook.getBook_loan_card().getReturn_date()}" pattern="dd/MM/yyyy"/></td>
        <td>
          <button type="button">Trả sách</button>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<script>

</script>
</body>
</html>
