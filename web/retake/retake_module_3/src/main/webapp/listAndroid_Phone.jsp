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

        .input-error {
            color: red;
            display: none;
        }

    </style>
</head>
<body id="background">
<center>
    <h1>Cầm đồ Tiến Thanh</h1>


    <form class="form-add">
        <button type="button" class="btn btn-success" data-bs-toggle="modal"
                data-bs-target="#exampleModal">Thêm Điện thoại cầm
        </button>
    </form>

    <form method="post" action="/tienthanh" class="form-return">
        <input type="hidden" name="action" value="reload">
        <button class="btn btn-success">Quay lại trang chính</button>
    </form>

    <form method="post" action="/tienthanh" class="form-late">
        <input type="hidden" name="action2" value="watch_late_list_android_phone">
        <button class="btn btn-success">Xem danh sách trễ hạn</button>
    </form>

    <form method="post" action="/tienthanh" class="form-extend">
        <input type="hidden" name="action2" value="watch_near_term_list_android_phone">
        <button class="btn btn-success">Xem danh sách gần tới hạn</button>
    </form>


    <div class="search">
        <form action="/tienthanh" method="post">
            <h2>Tìm kiếm theo mã số</h2>
            <input type="number" name="find_by_id" placeholder="Tìm kiếm theo mã số">
            <input type="hidden" value="list_find_android_phone_similar_by_id" name="action2">
            <button type="submit">Tìm kiếm</button>
        </form>
    </div>

    <div class="search">
        <form action="/tienthanh" method="post">
            <h2>Tìm kiếm theo tên</h2>
            <input type="text" name="find_by_name" placeholder="Tìm Điện Thoại theo tên">
            <input type="hidden" value="list_find_android_phone_similar_by_name" name="action2">
            <button type="submit">Tìm kiếm</button>
        </form>
    </div>
</center>

<div align="center">
    <table id="myTable" class="table table-hover" STYLE="text-align: center">
        <h2>Danh sách điện thoại cầm</h2>
<%--        <caption><h2>Danh sách điện thoại cầm</h2></caption>--%>
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã Số Phiếu</th>
            <th>Họ và tên</th>
            <th>Loại máy</th>
            <th>Tên máy</th>
            <th>Số tiền cầm</th>
            <th>Ngày cầm</th>
            <th>Số điện thoại</th>
            <th>Tình trạng</th>
            <th>Mật khẩu</th>
            <th>Ghi chú</th>
            <th>Thanh Công cụ</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="1"/>
        <c:forEach items="${list}" var="l">
            <tr>
                <td><c:out value="${count}"/></td>
                <c:set var="count" value="${count + 1}"/>

                <td><c:out value="${android_phone.id}"/></td>
                <td><c:out value="${android_phone.name_owner}"/></td>
                <td><c:out value="${android_phone.name_phone}"/></td>
                <td><c:out value="${android_phone.id_of_phone}"/></td>
                <td><fmt:formatNumber value="${android_phone.price}" pattern="###,###,###,###"/></td>
                <td><fmt:formatDate value="${android_phone.start_Date}" pattern="dd/MM/yyyy"/></td>
                <td><c:out value="${android_phone.phone_number_owner}"/></td>
                <td><c:out value="${android_phone.status}"/></td>
                <td><c:out value="${android_phone.password}"/></td>
                <td><c:out value="${android_phone.note}"/></td>
                <td>

                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

<%--form để thêm mới điện thoại cầm--%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm điện thoại cầm mới</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" value="save_create_android_phone" id="action2">
                    <div class="mb-3">
                        <label for="id_android_phone" class="col-form-label">Mã số:</label>
                        <input type="number" name="id" class="form-control" id="id_android_phone" onblur="idError()" oninput="removeLeadingZeros(this)">
                        <span class="input-error" id="check_if_id_null">Vui lòng nhập mã số</span>
                        <span class="input-error" id="check_if_id_exist">mã số đã tồn tại</span>
                    </div>
                    <div class="mb-3">
                        <label for="name_android_phone" class="col-form-label">Họ và tên:</label>
                        <input type="text" name="name_owner" class="form-control" id="name_android_phone"
                               onblur="nameError()">
                        <span class="input-error" id="check_if_name_null">Vui lòng nhập Họ và tên</span>
                    </div>
                    <div class="mb-3">
                        <label for="mySelect" class="col-form-label">Loại máy:</label>
                        <%--                        <input type="number" name="id" class="form-control" id="type_android_phone">--%>
                        <select name="name_phone" id="mySelect" onblur="typeError()">
                            <option id="hiddenSelect" value="" hidden selected disabled>phone</option>
                            <optgroup label="Các hãng điện thoại">
                                <option value="samsung">SAMSUNG</option>
                                <option value="oppo">OPPO</option>
                                <option value="realme">REALME</option>
                                <option value="vivo">VIVO</option>
                                <option value="xiaomi">XIAOMI</option>
                                <option value="one_plus">ONE PLUS</option>
                            </optgroup>
                            <optgroup label="Hãng điện thoại khác">
                                <option value="khac">Khác</option>
                            </optgroup>
                        </select>
                        <span class="input-error" id="check_if_type_null">Vui lòng chọn loại máy</span>
                        <div id="otherBrand" style="display:none;">
                            <input type="text" class="form-control" id="otherBrandInput" onblur="gg()"
                                   placeholder="Nhập tên hãng điện thoại khác...">
                            <%--                            <span class="input-error">Vui lòng nhập tên hãng điện thoại</span>--%>
                        </div>
                        <div class="mb-3">
                            <label for="id_of_phone" class="col-form-label">Tên của điện thoại: </label>
                            <input type="text" name="id_of_phone" class="form-control" id="id_of_phone"
                                   onblur="idPhoneError()">
                            <span class="input-error" id="check_if_id_of_phone_null">Vui lòng tên của điện thoại.</span>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="price_android_phone" class="col-form-label">PRICE:</label>
                        <input type="text" name="price" class="form-control" id="price_android_phone"
                               oninput="formatNumberInput(this)" onblur="priceError()">
                        <span class="input-error" id="check_if_price_null">Vui lòng nhập số tiền cầm</span>
                    </div>
                    <div class="mb-3">
                        <label for="start_date_android_phone" class="col-form-label">Ngày cầm:</label>
                        <input type="date" name="start_Date" class="form-control" id="start_date_android_phone"
                               onblur="startDateError()">
                        <%--                        <fmt:formatDate value="${android_phone.start_Date}" pattern="dd/MM/yyyy"/>--%>
                        <span class="input-error" id="check_if_start_date_null">Vui lòng nhập ngày cầm</span>
                    </div>
                    <div class="mb-3">
                        <label for="phone_number_owner" class="col-form-label">Số điện thoại của người cầm: </label>
                        <input type="number" name="phone_number_owner" class="form-control" id="phone_number_owner">
<%--                        <span class="input-error" id="check_phone_number_owner_null">Vui lòng số điện thoại.</span>--%>
                    </div>
                    <div class="mb-3">
                        <label for="status_android_phone" class="col-form-label">Tình trạng:</label>
                        <input type="text" name="status" class="form-control" id="status_android_phone"
                               placeholder="Bình thường">
                        <%--                        <span class="input-error">Vui lòng mô tả tình trạng của máy</span>--%>
                    </div>
                    <div class="mb-3">
                        <label for="password_android_phone" class="col-form-label">Mật khẩu:</label>
                        <input type="text" name="password" class="form-control" id="password_android_phone"
                               placeholder="Không có">
                        <%--                        <span class="input-error">Vui lòng nhập mật khẩu</span>--%>
                    </div>
                    <div class="mb-3">
                        <label for="note_android_phone" class="col-form-label">Ghi chú:</label>
                        <input type="text" name="note" class="form-control" id="note_android_phone"
                               placeholder="Không có">
                        <%--                        <span class="input-error">Vui lòng nhập ghi chú</span>--%>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" id="saveButton" onclick="submit_add()">Save</button>
            </div>
        </div>
    </div>
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
