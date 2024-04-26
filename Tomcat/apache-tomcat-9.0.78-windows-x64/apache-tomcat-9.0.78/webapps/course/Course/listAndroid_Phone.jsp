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
    </style>
</head>
<body id="background">
<center>
    <h1>Course</h1>
    <form class="form-add">
        <button type="button" class="btn btn-success" data-bs-toggle="modal"
                data-bs-target="#exampleModal">Thêm Điện thoại cầm
        </button>
    </form>

    <form method="post" action="/course" class="form-return">
        <input type="hidden" name="action" value="reload">
        <button class="btn btn-success">Quay lại trang chính</button>
    </form>

</center>

<div align="center">
    <table id="myTable" class="table table-hover" STYLE="text-align: center">
        <h2>Course list</h2>
<%--        <caption><h2>Danh sách điện thoại cầm</h2></caption>--%>
        <thead>
        <tr>
            <th>STT</th>
            <th>Course ID</th>
            <th>Subject</th>
            <th>Lecturer Name</th>
            <th>Credits</th>
        </tr>
        </thead>
        <tbody>
        <c:set var="count" value="1"/>
        <c:forEach items="${listCourse}" var="course">
            <tr>
                <td><c:out value="${count}"/></td>
                <c:set var="count" value="${count + 1}"/>

                <td><c:out value="${course.courseID}"/></td>
                <td><c:out value="${course.Subject}"/></td>
                <td><c:out value="${course.LecturerName}"/></td>
                <td><c:out value="${course.Credits}"/></td>
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
                <h1 class="modal-title fs-5" id="exampleModalLabel">Thêm khoá học mới</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <input type="hidden" value="save_create_android_phone" id="action2">
                    <div class="mb-3">
                        <label for="courseID" class="col-form-label">Mã khoá học:</label>
                        <input type="text" name="courseID" class="form-control" id="courseID">
                    </div>
                    <div class="mb-3">
                        <label for="subject" class="col-form-label">Tên khoá học</label>
                        <input type="text" name="subject" class="form-control" id="subject">
                    </div>
                    <div class="mb-3">
                        <label for="lecturerName" class="col-form-label">Tên giảng viên</label>
                        <input type="text" name="lecturerName" class="form-control" id="lecturerName">
                    </div>
                    <div class="mb-3">
                        <label for="credits" class="col-form-label">Tín chỉ:</label>
                        <input type="number" name="credits" class="form-control" id="credits">
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary" id="saveButton">Save</button>
            </div>
        </div>
    </div>
</div>

<script>

    // đoạn jquery này để phân trang cho một trang wed
    $(document).ready(function() {
        $('#myTable').DataTable({
            "pageLength": 15,
            "lengthChange": false,

        });
    });
</script>
</body>

</html>
