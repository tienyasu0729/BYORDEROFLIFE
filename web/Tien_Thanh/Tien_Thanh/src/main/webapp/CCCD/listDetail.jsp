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
  <title>Tiệm cầm đồ Tiến Thanh</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <style>
    .form-edit, .form-delete{
      display: inline-block;
    }
    .address{
      width: 150px;
    }
  </style>
</head>
<body>
<center>
  <h1>Cầm đồ Tiến Thanh</h1>
  <h2>
    <form method="post" action="/tienthanh">
      <input type="hidden" name="action" value="create">
      <button class="btn btn-success">Thêm thông tin cccd</button>
    </form>
  </h2>

  <div class="search">
    <form action="/tienthanh" method="post">
      <h2>Tìm kiếm CCCD theo mã số</h2>
      <input type="text" name="findByCccd" placeholder="Tìm kiếm theo mã số CCCD">
<%--      <div class="form-floating mb-3" style="width: 200px">--%>
<%--        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">--%>
<%--        <label for="floatingInput">Email address</label>--%>
<%--      </div>--%>
      <input type="hidden" value="search" name="action2">
      <button type="submit" >Tìm kiếm</button>
    </form>
  </div>

  <div class="search">
    <form action="/tienthanh" method="post">
      <h2>Tìm kiếm CCCD theo tên</h2>
      <input type="text" name="findByName" placeholder="Tìm CCCD theo tên">
      <input type="hidden" value="search" name="action2">
      <button type="submit">Tìm kiếm</button>
    </form>
  </div>
</center>
<div align="center">
  <table class="table table-hover" STYLE="text-align: center">
    <h2>Danh sách CCCD cầm</h2>
    <caption><h2>Danh sách CCCD cầm</h2></caption>
    <tr>
      <th>STT</th>
      <th>CCCD</th>
      <th>Họ và tên</th>
      <th>Ngày sinh</th>
      <th>Giới tính</th>
      <th>Quê quán</th>
      <th>Số điện thoại</th>
      <th>Số lần cầm</th>
      <th>Lịch sử cầm</th>
    </tr>
    <% int count = 1; %>
    <c:forEach items="${listDetail}" var="android_phone">
      <tr>
        <td><%=count%></td>
        <% count++; %>

        <td><c:out value="${android_phone.idDetail}"/></td>
        <td><c:out value="${android_phone.nameDetail}"/></td>
        <td><fmt:formatDate value="${android_phone.birthday}" pattern="dd/MM/yyyy"/></td>
        <td><c:out value="${android_phone.gender}"/></td>
        <td class="address"><a><c:out value="${android_phone.address}"/></a></td>
        <td><c:out value="${android_phone.phoneNumber}"/></td>
        <td><c:out value="${android_phone.times}"/></td>
        <td><c:out value="${android_phone.history}"/></td>

        <td>
          <form action="/tienthanh" method="post" class="form-edit">
            <input type="hidden" name="action" value="edit">
            <input type="hidden" name="idEdit" value="${android_phone.idDetail}">
            <button type="submit" class="btn btn-success">Chỉnh sửa</button>
          </form>

          <form action="/tienthanh" method="post" class="form-delete">
            <input type="hidden" name="action2" value="delete">
            <input type="hidden" name="id" value="${android_phone.idDetail}">
            <button type="submit" class="btn btn-danger"
                    onclick="return confirm('Bạn có chắc chắn muốn xoá không?')">Xoá
            </button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
<script> //  script này để ngăn người dùng nhấn chuột phải rồi nhấn kiểm tra để xem được code html
document.addEventListener("contextmenu", function(e){
  e.preventDefault();
}, false);
</script>

<%--<script>--%>
<%--    function changeButtonText(button) {--%>
<%--        if (button.value == 0) {--%>
<%--            button.innerHTML = 'Xem chi tiết';--%>
<%--        } else {--%>
<%--            button.innerHTML = 'Không có chi tiết';--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>

</html>
