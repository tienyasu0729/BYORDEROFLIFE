<%-- 
    Document   : login
    Created on : Mar 10, 2024, 11:58:43 PM
    Author     : ASUS
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="include/header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>   
    <section>       
        <div class="container">
            <div class="row flex-lg-row-reverse align-items-center g-5 mt-2 py-5">
                <div class="col-lg-10 col-xl-9 mx-auto">
                    <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden center">
                        <div class="card-img-left-login d-none d-md-flex">
                        </div>
                                    
                        <div class="card-body p-2 p-sm-3">
                            <h5 class="card-title text-center mb-2 fw-light h2 fw-bold">Login</h5>
                            ${MSG}
                            
                            <form  action="loginServlet"  method="post">
                                
                                <label for="userRadio">User:</label>
                                        <input type="radio" id="userRadio" name="role" value="user">
                                        <br>
                                        <label for="shipperRadio">Shipper:</label>
                                        <input type="radio" id="shipperRadio" name="role" value="shipper">
                                        <br>
                                        <div class="form-floating mb-3">
                                            <input type="text" name="number" class="form-control" id="floatingInputUsername" placeholder="myusername" required
                                                   autofocus>
                                            <label for="floatingInputUsername">Phone Number</label>
                                        </div>

                                        <div class="form-floating mb-3">
                                            <input type="password" name="pass" class="form-control" id="floatingPassword" placeholder="Password">
                                            <label for="floatingPassword">Password</label>
                                        </div>

                                        <div class="d-grid mb-2">
                                            <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit">Login</button>
                                        </div>

                                        <a class="d-block text-center mt-2 small" href="signUp.jsp">Don't have an account? Sign Up</a>
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
