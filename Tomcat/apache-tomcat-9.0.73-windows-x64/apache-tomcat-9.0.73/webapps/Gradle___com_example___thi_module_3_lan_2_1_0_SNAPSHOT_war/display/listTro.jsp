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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
            integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

<%--    đoạn link này để phân trang cho một trang wed--%>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
    <script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap.min.js"></script>

    <style>
        .form-add, .form-return, .form-late, .form-extend {
            display: inline-block;
        }

        .form-edit, .form-delete {
            display: inline-block;
        }

        .form-payment {
            display: inline;
        }

        .input-error {
            color: red;
            display: none;
        }

        /*.dataTables_wrapper .dataTables_paginate a.paginate_button {*/
        /*    margin: 0px;*/
        /*}*/

        /*#background {*/
        /*    background-image: url("https://flc-event.vn/wp-content/uploads/2020/02/backgound-about-1.jpg");*/
        /*    background-repeat: no-repeat;*/
        /*    background-size: cover;*/
        /*    position: fixed;*/
        /*    top: 0;*/
        /*    left: 0;*/
        /*    width: 100%;*/
        /*    height: 100%;*/
        /*    z-index: -1;*/
        /*}*/
    </style>
</head>
<body id="background">
<center>
    <h1>Danh sách phòng trọ</h1>

<%--    <form class="form-add">--%>
<%--        <button type="button" class="btn btn-success" data-bs-toggle="modal"--%>
<%--                data-bs-target="#exampleModal">Thêm Điện thoại cầm--%>
<%--        </button>--%>
<%--    </form>--%>

<%--    <form method="post" action="/tienthanh" class="form-return">--%>
<%--        <input type="hidden" name="action" value="reload">--%>
<%--        <button class="btn btn-success">Quay lại trang chính</button>--%>
<%--    </form>--%>

<%--    <form method="post" action="/tienthanh" class="form-late">--%>
<%--        <input type="hidden" name="action2" value="watch_late_list_android_phone">--%>
<%--        <button class="btn btn-success">Xem danh sách trễ hạn</button>--%>
<%--    </form>--%>

<%--    <form method="post" action="/tienthanh" class="form-extend">--%>
<%--        <input type="hidden" name="action2" value="watch_near_term_list_android_phone">--%>
<%--        <button class="btn btn-success">Xem danh sách gần tới hạn</button>--%>
<%--    </form>--%>


<%--    <div class="search">--%>
<%--        <form action="/tienthanh" method="post">--%>
<%--            <h2>Tìm kiếm theo mã số</h2>--%>
<%--            <input type="number" name="find_by_id" placeholder="Tìm kiếm theo mã số">--%>
<%--            <input type="hidden" value="list_find_android_phone_similar_by_id" name="action2">--%>
<%--            <button type="submit">Tìm kiếm</button>--%>
<%--        </form>--%>
<%--    </div>--%>

<%--    <div class="search">--%>
<%--        <form action="/tienthanh" method="post">--%>
<%--            <h2>Tìm kiếm theo tên</h2>--%>
<%--            <input type="text" name="find_by_name" placeholder="Tìm Điện Thoại theo tên">--%>
<%--            <input type="hidden" value="list_find_android_phone_similar_by_name" name="action2">--%>
<%--            <button type="submit">Tìm kiếm</button>--%>
<%--        </form>--%>
<%--    </div>--%>
</center>

<div align="center">
    <table id="myTable" class="table table-hover" STYLE="text-align: center">
        <h2>Danh sách phòng trọ</h2>
<%--        <caption><h2>Danh sách điện thoại cầm</h2></caption>--%>
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã phòng trọ</th>
            <th>Tên người thuê trọ</th>
            <th>Số điện thoại</th>
            <th>Ngày bắt đầu thuê</th>
            <th>Hình thức thanh toán</th>
            <th>Ghi chú</th>
            <th>Thanh Công cụ</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="1"/>
        <c:forEach items="${listTro}" var="l">
            <tr>
                <td><c:out value="${count}"/></td>
                <c:set var="count" value="${count + 1}"/>

                <td><c:out value="${l.getIdTro()}"/></td>
                <td><c:out value="${l.getName()}"/></td>
                <td><c:out value="${l.getPhoneNumber()}"/></td>
                <td><fmt:formatDate value="${l.getStartDate}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${l.getNameType()}"/></td>
                <td><c:out value="${l.getNote()}"/></td>
                <td>

                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>



<script>

    // đoạn jquery này để phân trang cho một trang wed
    $(document).ready( function () {
        $('#myTable').DataTable({
            "pageLength": 10, // này để điều số hàng mặc định sẽ hiển thị
            "lengthChange": false, // này để xoá ô cho người dùng lựa chọn số hàng hiển thị
        });
    } );

</script>
</body>

</html>
