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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css"/>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
    <script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap.min.js"></script>

    <style>

    </style>
</head>
<body id="background">
<center>
    <h1>Quản lý người dùng</h1>
    <form action="/tienthanh" method="post">
        <button type="button" class="btn btn-success" data-bs-toggle="modal"
                data-bs-target="#exampleModal">Thêm người dùng
        </button>
    </form>
    <form action="/tienthanh" method="post">
        <button type="button" class="btn btn-success" data-bs-toggle="modal"
                data-bs-target="#example">Chỉnh sửa
        </button>
    </form>

    <div align="center">
        <table id="myTable" class="table table-hover" STYLE="text-align: center">
            <h2>Quản lý người dùng</h2>
            <%--        <caption><h2>Danh sách điện thoại cầm</h2></caption>--%>
            <thead>
            <tr>
                <th>id</th>
                <th>full name</th>
                <th>code</th>
                <th>Ngày sinh</th>
                <th>thời gian khởi tạo</th>
                <th>Quyền</th>
                <th>công cụ</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listMidd}" var="l">
                <tr>
                    <td><c:out value="${l.user.getIdUser()}"/></td>
                    <td><c:out value="${l.user.getFullName()}"/></td>
                    <td><c:out value="${l.user.getCode()}"/></td>
                    <td><fmt:formatDate value="${l.user.getBirthdate()}" pattern="dd/MM/yyyy"/></td>
                    <td><c:out value="${l.user.getTimeBuild()}"/></td>
                    <td><c:out value="${l.role.getRoleName()}"/></td>

                    <td>

                    </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
    </div>

    <div class="modal fade" id="example" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel2">chỉnh sửa thông tin người dùng</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/tienthanh" method="post">

<%--                        <div class="mb-3">--%>
<%--                            <label for="idUserEdit" class="col-form-label">Mã số:</label>--%>
<%--                            <input type="number" name="idUser" class="form-control" id="idUserEdit">--%>
<%--                        </div>--%>
                        <div class="mb-3">
                            <label for="fullNameEdit" class="col-form-label">Họ và tên:</label>
                            <input type="text" name="fullName" class="form-control" id="fullNameEdit">
                        </div>
                        <div class="mb-3">
                            <label for="codeEdit" class="col-form-label">Code:</label>
                            <input type="text" name="code" class="form-control" id="codeEdit">
                        </div>
                        <div class="mb-3">
                            <label for="birthdateEdit" class="col-form-label">Ngày cầm:</label>
                            <input type="date" name="birthdate" class="form-control" id="birthdateEdit">
                        </div>
                        <div class="mb-3">
                            <label for="birthdateEdit" class="col-form-label">Ngày cầm:</label>

                            <select name="idRoleEdit">
                                <c:forEach items="${listRole}" var="l">
                                    <option value="${l.getIdRole()}"><c:out value="${l.getRoleName()}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="action2" value="editUserAndRole">Save</button>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <%--form để thêm mới điện thoại cầm--%>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm người dùng</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="/tienthanh" method="post">
                        <div class="mb-3">
                            <label for="idUser" class="col-form-label">Mã số:</label>
                            <input type="number" name="idUser" class="form-control" id="idUser">
                        </div>
                        <div class="mb-3">
                            <label for="fullName" class="col-form-label">Họ và tên:</label>
                            <input type="text" name="fullName" class="form-control" id="fullName">
                        </div>
                        <div class="mb-3">
                            <label for="code" class="col-form-label">Code:</label>
                            <input type="text" name="code" class="form-control" id="code">
                        </div>
                        <div class="mb-3">
                            <label for="birthdate" class="col-form-label">Ngày cầm:</label>
                            <input type="date" name="birthdate" class="form-control" id="birthdate">
                        </div>
                        <div class="mb-3">
                            <label for="birthdate" class="col-form-label">Ngày cầm:</label>

                            <select name="idRole">
                                <c:forEach items="${listRole}" var="l">
                                    <option value="${l.getIdRole()}"><c:out value="${l.getRoleName()}"></c:out></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="action2" value="addUserAndRole">Save</button>
                        </div>
                    </form>
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
