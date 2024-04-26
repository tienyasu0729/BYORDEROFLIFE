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
        .input-error {
            color: red;
            display: none;
        }
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
                    <input type="text" id="create_id_loan_card" name="create_id_loan_card" size="45"
                           onblur="check_id_loan_card()"/>
                    <span class="input-error">ID này đã tồn tại</span>
                    <span class="input-error" id="ten_khong_duoc_rong">Mã mượn sách không được để rỗng</span>
                    <span class="input-error" id="ten_phai_bat_dau_bang_ms">Mã mượn sách không hợp lệ, phải bắt đầu bằng ms- rồi tới số</span>
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
                            <option value="${student.id_Student}"><c:out
                                    value="${student.name_Student}"></c:out></option>
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
                    <input type="date" id="create_date_return_book" name="create_date_return_book" size="45"
                           onblur="check_return_date()"/>
                    <span class="input-error">ID này đã tồn tại</span>
                    <span class="input-error" id="ngay_khong_duoc_rong">Mã mượn sách không được để rỗng</span>
                    <span class="input-error" id="kiem_tra_hop_le_cua_ngay_tra">Ngày trả phải lớn hơn ngày hiện tại</span>
                </td>
            </tr>
        </table>
        <button type="button" name="post_action" id="submit_form_borrow_book" onclick="submit_button()" value="submit_create_loan_card">Mượn sách</button>
        <form method="post" action="/library">
            <button type="submit" name="post_action" value="return_form_create_loan_card">Huỷ</button>
        </form>
    </form>

</div>

<script>
    let check_submit = false;

    // đoạn này dùng AJAX để truyền xuống servlet để kiểm tra id
    function check_id_loan_card() {
        var id_loan_card = document.getElementById("create_id_loan_card");
        let regex = /^ms-\d+$/;
        let check = true;
        // kiểm tra xem id_loan_card có rỗng không
        if (id_loan_card.value.trim === "") {
            let span_for_null = document.getElementById("ten_khong_duoc_rong");
            span_for_null.style.display = "block";
            check = false;
            check_submit = false;
        } else {
            let span_for_null = document.getElementById("ten_khong_duoc_rong");
            span_for_null.style.display = "none";
            check_submit = true;
            // kiểm tra xem id_loan_card có hợp lệ không
            if (!regex.test(id_loan_card.value)) {
                let span_for_form = document.getElementById("ten_phai_bat_dau_bang_ms");
                span_for_form.style.display = "block";
                check = false;
                check_submit = false;
            } else {
                let span_for_form = document.getElementById("ten_phai_bat_dau_bang_ms");
                span_for_form.style.display = "none";
                check_submit = true;
            }
        }

        if (check) {
            let xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    var result = this.responseText;
                    if (result === "true") {
                        id_loan_card.nextElementSibling.style.display = "block";
                        check_submit = false;
                    } else {
                        id_loan_card.nextElementSibling.style.display = "none";
                        check_submit = true;
                    }
                }
            };

            xhr.open("POST", "/library", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
            var data = "post_action=check_id_from_form_borrow_book&id_loan_card_need_to_check=" + encodeURIComponent(id_loan_card.value); // Tạo dữ liệu gửi đi
            xhr.send(data); // Gửi dữ liệu đi
        }
    }

    function check_return_date() {
        // Lấy giá trị ngày từ phần tử
        let day = document.getElementById("create_date_return_book").value;
        if (day.trim() === "") {
            let ngay_khong_duoc_rong = document.getElementById("ngay_khong_duoc_rong");
            ngay_khong_duoc_rong.style.display = "block";
            check_submit = false;
        } else {
            let ngay_khong_duoc_rong = document.getElementById("ngay_khong_duoc_rong");
            ngay_khong_duoc_rong.style.display = "none";
            check_submit = true;
            // Tạo đối tượng Date từ giá trị ngày
            let selectedDate = new Date(day);

// Lấy ngày hiện tại
            let currentDate = new Date();

// So sánh ngày được chọn với ngày hiện tại
            if (selectedDate <= currentDate) {
                let span_check_return_date = document.getElementById("kiem_tra_hop_le_cua_ngay_tra");
                span_check_return_date.style.display = "block";
                check_submit = false;
            }else {
                let span_check_return_date = document.getElementById("kiem_tra_hop_le_cua_ngay_tra");
                span_check_return_date.style.display = "none";
                check_submit = true;
            }

        }
    }

    function submit_button() {
        check_id_loan_card();
        check_return_date();
        let submit = document.getElementById("submit_form_borrow_book");
        if (check_submit){
            submit.type = "submit";
        }else {
            submit.type = "button";
        }
    }
</script>
</body>
</html>
