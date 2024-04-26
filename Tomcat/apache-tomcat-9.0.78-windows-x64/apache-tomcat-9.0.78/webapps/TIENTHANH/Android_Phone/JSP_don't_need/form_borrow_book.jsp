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
    link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
            integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-input {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .dropdown-list {
            position: absolute;
            z-index: 1;
            width: 100%;
            max-height: 200px;
            overflow-y: auto;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 4px;
            display: none; /* Ẩn danh sách ban đầu */
        }

        .dropdown-list-item {
            padding: 5px;
            cursor: pointer;
        }

        .dropdown-list-item:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<center>
    <h1>Mượn sách</h1>
</center>
<div align="center">
    <form method="post">
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
                    <input type="hidden" name="create_id_book" value="${create_name_book}">
                    <input type="text" name="create_name_book" size="45" value="${create_id_book}" readonly/>
                </td>
            </tr>
            <tr>
                <th>Tên học sinh:</th>
                <td>
                    <%--                    <input type="text" name="create_name_student" size="45">--%>

                    <div class="dropdown">
                        <input class="dropdown-input" type="text" placeholder="Tìm kiếm...">
                        <div class="dropdown-list">
                            <c:forEach items="${list_student_for_form_create_loan_card}" var="student">
                                <div class="dropdown-list-item">
                                        <%--                                        <ul>--%>
                                        <%--                                            <li value="${student.id_Student}">--%>
                                        <%--                                                <c:out value="${student.name_Student}"/>--%>
                                        <%--                                            </li>--%>
                                        <%--                                        </ul>--%>

                                            <div class="dropdown-list-item">
                                                <input type="hidden" name="student_id" value="${student.id_Student}">
                                                <span class="dropdown-item-text">${student.name_Student}</span>
                                            </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
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
                    <input type="date" name="create_date_return_book" size="45"/>
                </td>
            </tr>
        </table>
        <button type="submit" name="submit_create_loan_card">Mượn sách</button>
    </form>
    <button type="submit" name="return_form_create_loan_card">Huỷ</button>

</div>

<script>
    // $(document).ready(function () {
    //     var originalValue = $('.dropdown-input').val(); // Lưu giá trị gốc của ô input
    //
    //     $('.dropdown-input').on('keyup', function () {
    //         var value = $(this).val().toLowerCase();
    //         $('.dropdown-list-item').each(function () {
    //             var listItemText = $(this).text().toLowerCase();
    //             var showItem = listItemText.includes(value);
    //             $(this).toggle(showItem);
    //         });
    //
    //         // Hiển thị danh sách khi ô input không trống
    //         if (value !== '') {
    //             $('.dropdown-list').show();
    //         } else {
    //             $('.dropdown-list').hide();
    //         }
    //     });
    //
    //     $('.dropdown-input').on('click', function (e) {
    //         $('.dropdown-list').toggle();
    //         e.stopPropagation();
    //     });
    //
    //     $('.dropdown-list-item').on('click', function () {
    //         var selectedText = $(this).text();
    //         $('.dropdown-input').val(selectedText);
    //         $('.dropdown-list').hide();
    //     });
    //
    //     $(document).on('click', function (e) {
    //         if (!$(e.target).closest('.dropdown').length) {
    //             $('.dropdown-list').hide();
    //         }
    //     });
    // });

    $(document).ready(function() {
        var originalValue = $('.dropdown-input').val(); // Lưu giá trị gốc của ô input

        $('.dropdown-input').on('keyup', function() {
            var value = $(this).val().toLowerCase();
            $('.dropdown-list-item').each(function() {
                var listItemText = $(this).find('.dropdown-item-text').text().toLowerCase();
                var showItem = listItemText.includes(value);
                $(this).toggle(showItem);
            });

            // Hiển thị danh sách khi ô input không trống
            if (value !== '') {
                $('.dropdown-list').show();
            } else {
                $('.dropdown-list').hide();
            }
        });

        $('.dropdown-input').on('click', function(e) {
            $('.dropdown-list').toggle();
            e.stopPropagation();
        });

        $('.dropdown-list-item').on('click', function() {
            var selectedText = $(this).find('.dropdown-item-text').text();
            var selectedValue = $(this).find('input[name="student_id"]').val();
            $('.dropdown-input').val(selectedText);
            $('.dropdown-input').attr('data-selected-value', selectedValue);
            $('.dropdown-list').hide();
        });

        $(document).on('click', function(e) {
            if (!$(e.target).closest('.dropdown').length) {
                $('.dropdown-list').hide();
            }
        });
    });

</script>
</body>
</html>
