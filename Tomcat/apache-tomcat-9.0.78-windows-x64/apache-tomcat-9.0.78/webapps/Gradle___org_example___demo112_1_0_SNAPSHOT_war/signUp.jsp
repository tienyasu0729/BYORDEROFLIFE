<%-- 
    Document   : login
    Created on : Mar 10, 2024, 1:40:38 AM
    Author     : ASUS
--%>

<%@include file="include/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   
    <section>    
        <div class="container">
            <div class="row flex-lg-row-reverse align-items-center g-5 mt-2 py-5">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden center">
                        <div class="card-img-left-signup d-none d-md-flex">
                        </div>

                        <div class="card-body p-2 p-sm-3">
                            <h5 class="card-title text-center mb-2 fw-light h2 fw-bold">Đăng Ký</h5>
                            <br />
                            <form>
                                  <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="fistName" name="user" placeholder="Username" required
                                           autofocus>
                                    <label for="username">Fist Name</label>
                                </div>
                                
                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="lastName" name="user" placeholder="Username" required
                                           autofocus>
                                    <label for="username">Last Name</label>
                                </div>

                                <div class="form-floating mb-3">
                                    <input type="text" class="form-control" id="Phonenumber" name="phonenumber" placeholder="Số điện thoại">
                                    <label for="Phonenumber">Số điện thoại</label>
                                </div>
                                
                                <div class="form-floating mb-3">
                                    <input type="email" id="email" name="email" class="form-control" name="email" placeholder="email" required>
                                    <label for="email" class="label">Email:</label>
                                    <small class="form-text hint-text">Vui lòng nhập địa chỉ email hợp lệ (ví dụ: example@gmail.com).</small>
                                </div>


                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
                                    <label for="floatingPassword">Mật khẩu</label>
                                </div>

                                <div class="form-floating mb-3">
                                    <input type="password" class="form-control" id="floatingPasswordConfirm" name="passwordConfirm" placeholder="Xác nhận mật khẩu">
                                    <label for="floatingPasswordConfirm">Xác nhận mật khẩu</label>
                                </div>
                                
                                
                                
                                <div class="form-floating mb-3">                                   
                                    <input type="date" class="form-control" id="dob" name="dob" placeholder="Ngày Sinh" required>
                                    <label for="dob" class="form-label">Ngày Sinh:</label>
                                </div>

                                <div class="d-grid mb-2">
                                    <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit">Đăng kí</button>
                                </div>

                                <a class="d-block text-center mt-2 small" href="login.jsp">Bạn chưa có tài khoản? Đăng Nhập</a>
                                <br />
                                <hr class="my-2">
                                <br />
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script src="js/font-awesome-free-5.14.0.js"></script>        
    </section>
</html>
<%@ include file="/include/footer.jsp" %>