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
  <style>

  </style>
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
          <form action="/library" method="post">
            <input type="hidden" name="id_book_loan_card_need_return" value="${listBorrowBook.getBook_loan_card().getId_loan_card()}">
            <button type="button" id="return_button" name="post_action" value="return_book_borrow" onclick="check_return_button('${listBorrowBook.getStudent().getName_Student()}', '${listBorrowBook.getBook().getName_book()}')">Trả sách</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>

<script>
  function check_return_button(name_student, name_book) {
    let tra_sach = document.getElementById("return_button");
    let check = confirm("Học viên " + name_student + " thực hiện trả sách " + name_book);
    if (check) {
      tra_sach.type = "submit";
    } else {
      tra_sach.type = "button";
    }
  }
</script>
</body>
</html>
