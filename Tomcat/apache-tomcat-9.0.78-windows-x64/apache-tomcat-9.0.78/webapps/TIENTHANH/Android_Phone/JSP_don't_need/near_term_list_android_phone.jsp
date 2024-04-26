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
  <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style>
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
<body>
<center>
  <h1>Danh sách gần tới hạn</h1>

  <%--    <form method="post" action="/tienthanh">--%>
  <%--        <input type="hidden" name="action" value="create">--%>
  <%--        <button type="submit" class="btn btn-success">Thêm Điện thoại cầm</button>--%>
  <%--    </form>--%>

  <form>
    <button type="button" class="btn btn-success" data-bs-toggle="modal"
            data-bs-target="#exampleModal" data-bs-whatever="@mdo">Thêm Điện thoại cầm
    </button>
  </form>

  <form method="post" action="/tienthanh">
    <input type="hidden" name="action" value="reload">
    <button class="btn btn-success">Quay lại trang chính</button>
  </form>

  <form method="post" action="/tienthanh">
    <input type="hidden" name="action2" value="watch_late_list_android_phone">
    <button class="btn btn-success">Xem danh sách trễ hạn</button>
  </form>

  <form method="post" action="/tienthanh">
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
  <table class="table table-hover" STYLE="text-align: center">
    <h2>Danh sách điện thoại cầm</h2>
    <caption><h2>Danh sách điện thoại cầm</h2></caption>
    <tr>
      <th>STT</th>
      <th>Mã Số</th>
      <th>Họ và tên</th>
      <th>Loại máy</th>
      <th>Số tiền cầm</th>
      <th>Ngày cầm</th>
      <th>Tình trạng</th>
      <th>Mật khẩu</th>
      <th>Ghi chú</th>
      <th>Thanh Công cụ</th>
    </tr>
    <c:set var="count" value="1"/>
    <c:forEach items="${listAndroid_Phone}" var="android_phone">
      <tr>
        <td><c:out value="${count}"/></td>
        <c:set var="count" value="${count + 1}"/>

        <td><c:out value="${android_phone.id}"/></td>
        <td><c:out value="${android_phone.name_owner}"/></td>
        <td><c:out value="${android_phone.name_phone}"/></td>
        <td><fmt:formatNumber value="${android_phone.price}" pattern="###,###,###,###"/></td>
        <td><fmt:formatDate value="${android_phone.start_Date}" pattern="dd/MM/yyyy"/></td>
        <td><c:out value="${android_phone.status}"/></td>
        <td><c:out value="${android_phone.password}"/></td>
        <td><c:out value="${android_phone.note}"/></td>
        <td>
            <%--thanh công cụ--%>
            <%--                    <form action="/tienthanh" method="post" class="form-edit">--%>
            <%--                        <input type="hidden" name="action" value="edit_Android_phone">--%>
            <%--                        <input type="hidden" name="id_need_to_edit" value="${android_phone.id}">--%>
            <%--                        <button type="submit" class="btn btn-success" >Chỉnh sửa</button>--%>
            <%--                    </form>--%>
          <button type="button" class="btn btn-success" data-bs-toggle="modal"
                  data-bs-target="#exampleModal" data-bs-whatever="@mdo" onclick="edit_form('${android_phone.id}','${android_phone.name_owner}','${android_phone.name_phone}','${android_phone.price}','${android_phone.start_Date}','${android_phone.status}','${android_phone.password}','${android_phone.note}')">Chỉnh sửa
          </button>

            <%--                    <form action="/tienthanh" method="post" class="form-delete">--%>
            <%--                        <input type="hidden" name="action2" value="delete_android_phone_by_id">--%>
            <%--                        <input type="hidden" name="id_need_to_delete" value="${android_phone.id}">--%>
          <button type="button" class="btn btn-danger"
                  onclick="delete_the_product('${android_phone.id}', this)">Xoá
          </button>
            <%--                    </form>--%>

          <button type="button" class="btn btn-warning"
                  onclick="calculate('${android_phone.id}','${android_phone.start_Date}', '${android_phone.price}')">
            Gia hạn
          </button>

          <button type="button" class="btn btn-info"
                  onclick="take_the_product('${android_phone.id}','${android_phone.start_Date}', '${android_phone.price}',this)">
            lấy máy
          </button>
        </td>
      </tr>
    </c:forEach>
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
            <input type="number" name="id" class="form-control" id="id_android_phone" onblur="idError()">
            <span class="input-error">Vui lòng nhập mã số</span>
          </div>
          <div class="mb-3">
            <label for="name_android_phone" class="col-form-label">Họ và tên:</label>
            <input type="text" name="name_owner" class="form-control" id="name_android_phone"
                   onblur="nameError()">
            <span class="input-error">Vui lòng nhập Họ và tên</span>
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
            <span class="input-error">Vui lòng chọn loại máy</span>
            <div id="otherBrand" style="display:none;">
              <input type="text" class="form-control" id="otherBrandInput" onblur="gg()"
                     placeholder="Nhập tên hãng điện thoại khác...">
              <%--                            <span class="input-error">Vui lòng nhập tên hãng điện thoại</span>--%>
            </div>

          </div>
          <div class="mb-3">
            <label for="price_android_phone" class="col-form-label">PRICE:</label>
            <input type="text" name="price" class="form-control" id="price_android_phone"
                   oninput="formatNumberInput(this)" onblur="priceError()">
            <span class="input-error">Vui lòng nhập số tiền cầm</span>
          </div>
          <div class="mb-3">
            <label for="start_date_android_phone" class="col-form-label">Ngày cầm:</label>
            <input type="date" name="start_Date" class="form-control" id="start_date_android_phone"
                   onblur="startDateError()">
            <%--                        <fmt:formatDate value="${android_phone.start_Date}" pattern="dd/MM/yyyy"/>--%>
            <span class="input-error">Vui lòng nhập ngày cầm</span>
          </div>
          <div class="mb-3">
            <label for="status_android_phone" class="col-form-label">Tình trạng:</label>
            <input type="text" name="status" class="form-control" id="status_android_phone"
                   placeholder="Bình thường">
            <span class="input-error">Vui lòng mô tả tình trạng của máy</span>
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
  function edit_form(idAfter,nameAfter,typeAfter,priceAfter,startDateAfter,statusAfter,passwordAfter,noteAfter){
    var inputId = document.getElementById("id_android_phone");
    var labelId = document.querySelector("label[for='id_android_phone']");
    document.getElementById("exampleModalLabel").innerHTML = "Chỉnh sửa thông tin";
    labelId.style.display = "none";
    inputId.value = idAfter;
    inputId.style.display = "none";
    inputId.type = "hidden";

    var action2 = document.getElementById("action2");
    var nameBefore = document.getElementById("name_android_phone");
    var typeBefore = document.getElementById("mySelect");
    var priceBefore = document.getElementById("price_android_phone");

    var startDateBefore = document.getElementById("start_date_android_phone");
    var dateString = startDateAfter;
    var dateParts = dateString.split(" ");
    var monthNames = {
      Jan: "01",
      Feb: "02",
      Mar: "03",
      Apr: "04",
      May: "05",
      Jun: "06",
      Jul: "07",
      Aug: "08",
      Sep: "09",
      Oct: "10",
      Nov: "11",
      Dec: "12"
    };
    var yyyy = dateParts[5];
    var MM = monthNames[dateParts[1]];
    var dd = dateParts[2];
    var formattedDate = yyyy + "-" + MM + "-" + dd;

    var statusBefore = document.getElementById("status_android_phone");
    var passwordBefore = document.getElementById("password_android_phone");
    var noteBefore = document.getElementById("note_android_phone");

    nameBefore.value = nameAfter;

    for (var i = 0; i < typeBefore.options.length; i++) {
      if (typeBefore.options[i].value === typeAfter) {
        typeBefore.options[i].selected = true;
        break;
      }
    }

    var select = document.getElementById("mySelect");
    var newOptionValue = typeAfter;
    var newOptionText = typeAfter;
    var newOption = document.createElement("option");
    newOption.value = newOptionValue;
    newOption.textContent = newOptionText;
    // newOption.style.display = "none"
    newOption.setAttribute('data-added-by-js', 'true');
    select.add(newOption);
    var optgroup = document.createElement('optgroup');
    optgroup.label = 'Loại điện thoại đã chọn';
    optgroup.id = 'myOptgroup';
    optgroup.appendChild(newOption);
    select.appendChild(optgroup);


    // nếu có giá trị khác thì vẫn chưa thể hiển th ra được
    typeBefore.options[typeBefore.options.length - 1].selected = true;

    priceBefore.value = priceAfter;
    startDateBefore.value = formattedDate;
    statusBefore.value = statusAfter;
    passwordBefore.value = passwordAfter;
    noteBefore.value = noteAfter;
    action2.value = "save_edit_android_phone";
  }

  $('#exampleModal').on('hidden.bs.modal', function () {
    var select = document.getElementById("mySelect");
    var options = select.options;
    for (var i = options.length - 1; i >= 0; i--) {
      if (options[i].getAttribute('data-added-by-js') === 'true') {
        select.remove(i);
        var optgroupToRemove = document.getElementById('myOptgroup');
        select.removeChild(optgroupToRemove);
        var action2 = document.getElementById("action2");
        action2.value = "save_create_android_phone";
      }
    }
  });

  //  script này để ngăn người dùng nhấn chuột phải rồi nhấn kiểm tra để xem được code html
  document.addEventListener("contextmenu", function (e) {
    e.preventDefault();
  }, false);

  // function kkk(){
  //     $(function() {
  //         $("#start_date_android_phone").datepicker({
  //             dateFormat: "dd/mm/yy"
  //         });
  //     });
  // }


  var select = document.getElementById("mySelect");
  var otherBrandDiv = document.getElementById("otherBrand");
  var otherBrandInput = document.getElementById("otherBrandInput");

  select.addEventListener("change", function () {
    if (select.value === "khac") {
      otherBrandDiv.style.display = "block";
    } else {
      otherBrandDiv.style.display = "none";
    }
  });

  // Lấy giá trị của lựa chọn đầu tiên
  // vị trí số 0 đã là tiêu đề rồi
  var firstOptionValue = select.options[0].value;

  // Thay đổi giá trị của lựa chọn khác thành giá trị của lựa chọn đầu tiên
  function gg() {
    var otherBrandValue = otherBrandInput.value;
    var otherBrandOption = select.querySelector('option[value="khac"]');
    otherBrandOption.value = otherBrandValue || firstOptionValue;
  }

  function delete_the_product(id, btn) {
    let check = confirm("bạn có muốn xoá người này không");
    if (check === true) {
      let xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          // bảng này để xoá một hàng trong bảng ( chỉ xoá hàng trong jsp mà không động tới servlet)
          var row = btn.parentNode.parentNode;
          row.parentNode.removeChild(row);
          // đoạn này để thay đổi cột STT sau khi xoá một hàng trong bảng
          var tableRows = document.getElementsByTagName('tr');
          for (var i = 1; i < tableRows.length; i++) {
            tableRows[i].getElementsByTagName('td')[0].innerHTML = i;
          }
          // đoạn này để in ra thông báo thành công sau khi xoá thành công trong servlet
          var result = this.responseText;
          alert(result);
        }
      };
      xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
      var data = "action2=delete_android_phone_by_id" + "&id_need_to_delete=" + encodeURIComponent(id); // Tạo dữ liệu gửi đi
      xhr.send(data); // Gửi dữ liệu đi
    } else {
      alert("- Xoá không thành công");
    }

  }

  function take_the_product(id, startDate, price, btn) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        var result = this.responseText;
        alert(result);
        let check = confirm("Khách đã chắc chắn lấy máy không");
        if (check === true) {
          delete_after_take_the_product(id, startDate);
          var row = btn.parentNode.parentNode;
          row.parentNode.removeChild(row);

          // đoạn này để thay đổi cột STT sau khi xoá một hàng trong bảng
          var tableRows = document.getElementsByTagName('tr');
          for (var i = 1; i < tableRows.length; i++) {
            tableRows[i].getElementsByTagName('td')[0].innerHTML = i;
          }
        }
      }
    };
    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=take_the_product_out" + "&start_date_interest_payment=" + encodeURIComponent(startDate) + "&price_interest_payment=" + encodeURIComponent(price); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
  }

  function calculate(id, startDate, price) {
    let days;
    do {
      days = +prompt("Nhập số ngày cầm tính lãi");
    } while (isNaN(days));
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        var result = this.responseText;
        alert(result);
        let check = confirm("bạn có muốn gia hạn không");
        if (check === true) {
          extend_start_date(id, startDate, days);
        }
      }
    };

    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=interestPayment" + "&start_date_interest_payment=" + encodeURIComponent(startDate) + "&price_interest_payment=" + encodeURIComponent(price) + "&days_interest_payment=" + encodeURIComponent(days); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
  }

  function extend_start_date(id, startDate, days) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        var result = this.responseText;
        alert(result);

      }
    };

    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=extend_interest_payment&id_extend_interest_payment=" + encodeURIComponent(id) + "&start_date_interest_payment=" + encodeURIComponent(startDate) + "&days_interest_payment=" + encodeURIComponent(days); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
  }

  function delete_after_take_the_product(id, startDate) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        var result = this.responseText;
        alert("Lấy máy thành công");
      }
    };

    xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); // Thêm header để chỉ định loại dữ liệu gửi đi
    var data = "action2=delete_android_phone_by_id&id_need_to_delete=" + encodeURIComponent(id) + "&start_date_interest_payment=" + encodeURIComponent(startDate); // Tạo dữ liệu gửi đi
    xhr.send(data); // Gửi dữ liệu đi
  }

  function idError() {
    var id = document.getElementById("id_android_phone");
    if (id.value.trim() !== "") {
      id.nextElementSibling.style.display = "none";
    }
  }

  function nameError() {
    var name = document.getElementById("name_android_phone");
    if (name.value.trim() !== "") {
      name.nextElementSibling.style.display = "none";
    }
  }

  function priceError() {
    var price = document.getElementById("price_android_phone");
    if (price.value.trim() !== "") {
      price.nextElementSibling.style.display = "none";
    }
  }

  function formatNumberInput(input) {
    // Lấy giá trị nhập vào từ input
    let value = input.value;
    // Kiểm tra nếu giá trị nhập vào là số 0 đầu tiên thì không cho phép nhập

    if (value === '0') {
      input.value = '';
      return;
    }
    // Xóa bỏ các ký tự không phải là số từ giá trị nhập vào
    value = value.replace(/[^\d]/g, '');
    // Chuyển giá trị thành chuỗi và đảm bảo rằng nó không bị rỗng
    let stringValue = value.toString();
    // Chia chuỗi thành các phần cách hàng ngàn
    let parts = stringValue.split('');
    let formattedValue = '';
    for (let i = 0; i < parts.length; i++) {
      if (i > 0 && i % 3 == 0) {
        formattedValue = ',' + formattedValue;
      }
      formattedValue = parts[parts.length - i - 1] + formattedValue;
    }
    // Gán lại giá trị định dạng cho input
    input.value = formattedValue;
  }

  function startDateError() {
    var startDate = document.getElementById("start_date_android_phone");
    if (startDate.value.trim() !== "x") {
      startDate.nextElementSibling.style.display = "none";
    }
  }

  function typeError() {
    var type = document.getElementById("mySelect");
    if (type.value.trim() !== "") {
      type.nextElementSibling.style.display = "none";
    }
  }

  function submit_add() {
    var action2 = document.getElementById("action2");

    // Lấy các giá trị được nhập vào từ các phần tử HTML
    var id = document.getElementById("id_android_phone");
    var name = document.getElementById("name_android_phone");
    var type = document.getElementById("mySelect");
    var price = document.getElementById("price_android_phone");
    var startDate = document.getElementById("start_date_android_phone");
    var status = document.getElementById("status_android_phone");
    var password = document.getElementById("password_android_phone");
    var note = document.getElementById("note_android_phone");
    var check = true;

    // alert(id + " + " + name + " + " + price);

    if (id.value.trim() === "") {
      id.nextElementSibling.style.display = "block";
      check = false;
    }

    if (name.value.trim() === "") {
      name.nextElementSibling.style.display = "block";
      check = false;
    }

    if (type.value.trim() === "") {
      type.nextElementSibling.style.display = "block";
      check = false;
    }

    if (price.value.trim() === "") {
      price.nextElementSibling.style.display = "block";
      check = false;
    }

    if (startDate.value.trim() === "") {
      startDate.nextElementSibling.style.display = "block";
      check = false;
    }
    // alert(id.value + " / " + name.value + " / " + startDate.value);

    // var idError = document.querySelector("#id_android_phone + .input-error");
    // if (id === "") {
    //     idError.style.display = "block";
    //     check = false;
    // }else {
    //     idError.style.display = "none";
    // }
    //
    // var nameError = document.querySelector("#name_android_phone + .input-error");
    // if (name === "") {
    //     nameError.style.display = "block";
    //     check = false;
    // }else {
    //     nameError.style.display = "none";
    // }
    //
    // var priceError = document.querySelector("#price_android_phone + .input-error");
    // if (price === "") {
    //     priceError.style.display = "block";
    //     check = false;
    // }else {
    //     priceError.style.display = "none";
    // }
    //
    // var startDateError = document.querySelector("#start_date_android_phone + .input-error");
    // if (startDate === "") {
    //     startDateError.style.display = "block";
    //     check = false;
    // }else {
    //     startDateError.style.display = "none";
    // }
    //
    // var statusError = document.querySelector("#status_android_phone + .input-error");
    // if (status === "") {
    //     statusError.style.display = "block";
    //     check = false;
    // }else {
    //     statusError.style.display = "none";
    // }

    // Nếu tất cả các ô input đã được nhập, thực hiện lưu dữ liệu
    if (check) {
      let xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          var result = this.responseText;
          if (action2.value === "save_create_android_phone"){
            alert("Thêm máy mới thành công");
          }
          if (action2.value === "save_edit_android_phone"){
            alert("Chỉnh sửa thành công");
          }

          // Xoá dữ liệu nhập vào sau khi gửi thành công
          id.value = "";
          name.value = "";
          // type.value = "";
          price.value = "";
          startDate.value = "";
          status.value = "";
          password.value = "";
          note.value = "";

        }
      };

      xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      var href = "action2=" + encodeURIComponent(action2.value) +"&id=" + encodeURIComponent(id.value) + "&name_owner=" + encodeURIComponent(name.value) + "&name_phone=" + encodeURIComponent(type.value) + "&price=" + encodeURIComponent(price.value) + "&status=" + encodeURIComponent(status.value) + "&password=" + encodeURIComponent(password.value) + "&note=" + encodeURIComponent(note.value) + "&start_Date=" + encodeURIComponent(startDate.value); // Tạo dữ liệu gửi đi
      xhr.send(href);
    }


    // Tạo đối tượng chứa dữ liệu để gửi đến máy chủ
    // let data = {
    //     action2: "save_create_android_phone",
    //     id: id,
    //     name_owner: name,
    //     name_phone: type,
    //     price: price,
    //     start_Date: startDate,
    //     status: status,
    //     password: password,
    //     note: note
    // };

    // Gửi dữ liệu đến máy chủ bằng Ajax
    // let xhr = new XMLHttpRequest();
    // xhr.onreadystatechange = function () {
    //     if (this.readyState == 4 && this.status == 200) {
    //         var result = this.responseText;
    //         alert("Thêm máy mới thành công");
    //     }
    // };
    //
    // xhr.open("POST", "/tienthanh", true); // Thay đổi phương thức gửi dữ liệu từ GET sang POST
    // xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    // var re = "action2=save_create_android_phone&id=" + encodeURIComponent(id) + "&name_owner=" + encodeURIComponent(name) + "&name_phone=" + encodeURIComponent(type) + "&price=" + encodeURIComponent(price) + "&status=" + encodeURIComponent(status) + "&password=" + encodeURIComponent(password) + "&note=" + encodeURIComponent(note) + "&start_Date=" + encodeURIComponent(startDate); // Tạo dữ liệu gửi đi
    // xhr.send(re);
    // xhr.send(data);

  }
</script>
</body>

</html>
