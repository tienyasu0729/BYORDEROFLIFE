<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 17/05/2023
  Time: 12:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <h1>Mượn sách</h1>
</center>
<div align="center">
    <form method="post" action="/library">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Mượn sách</h2>
            </caption>
            <tr>
                <th>Mã mượn sách:</th>
                <td>
                    <input type="text" name="create_id_loan_card" size="45" required="required"/>
                </td>
            </tr>
            <tr>
                <th>Tên sách:</th>
                <td>
                    <input type="hidden" name="create_id_book" value="${create_id_book}">
                    <input type="text" size="45" value="${create_name_book}" readonly/>
                </td>
            </tr>
            <tr>
                <th>Tên học sinh:</th>
                <td>
                    <select name="create_name_student" required="required">
                        <c:forEach items="${list_student_for_form_create_loan_card}" var="student">
                            <option value="${student.id_Student}"><c:out value="${student.name_Student}"></c:out></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Ngày mượn sách:</th>
                <td>
                    <input type="date" name="create_date_borrow_book" size="45" value="${create_date_borrow_book}"
                           readonly/>
                </td>
            </tr>
            <tr>
                <th>Ngày trả sách:</th>
                <td>
                    <input type="date" name="create_date_return_book" size="45" required="required" />
                </td>
            </tr>
        </table>
        <button type="submit" name="post_action" value="submit_create_loan_card">Mượn sách</button>
        <form method="post" action="/library">
            <input type="hidden" name="post_action" value="return_form_create_loan_card">
            <button type="submit" name="return_form_create_loan_card">Huỷ</button>
        </form>
    </form>

</div>

<script>

</script>
</body>
</html>
