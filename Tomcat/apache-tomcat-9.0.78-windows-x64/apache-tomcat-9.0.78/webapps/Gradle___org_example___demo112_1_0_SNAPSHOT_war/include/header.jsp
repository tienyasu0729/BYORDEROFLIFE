<%-- 
    Document   : head
    Created on : Mar 4, 2024, 9:56:20 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="UTF-8"><style data-styles="">ion-icon{visibility:hidden}.hydrated{visibility:inherit}</style>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Giao Hàng Tiện Lợi</title>

        <link rel="stylesheet" type="text/css" href="Style/vendor.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="Style/style.css">

    </head>
    <body>   
        <section id="navigation-bar" class="navigation position-fixed">
            <nav id="navbar-example2" class="navbar navbar-expand-lg">

                <div class="navigation container-fluid d-flex flex-wrap align-items-center my-2 pe-4 ps-5 ">

                    <div class="col-md-3 brand-logo">
                        <a href="index.jsp" class="d-inline-flex link-body-emphasis text-decoration-none">
                            <img class="col-md-6" src="images/logoPage.png" alt=""  width="100" height="93">
                            <img class="col-md-6" src="images/LogoTitel.png" alt="alt" width="100" height="93" />
                        </a>
                    </div>

                    <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar2" aria-labelledby="offcanvasNavbar2Label">

                       

                        <div class="offcanvas-body">
                            <ul class="navbar-nav align-items-center flex-grow-1 Menuheader">

                                <li class="nav-list mx-3">
                                    <a href="index.jsp" class="nav-link px-2">
                                        <h5> Home </h5>
                                    </a>
                                </li>

                                <li class="nav-list mx-3">
                                    <a href="index.jsp#services" class="nav-link px-2">
                                        <h5> dịch vụ </h5>
                                    </a>
                                </li>
                                <li class="nav-list mx-3">
                                    <a href="index.jsp#articles" class="nav-link px-2">
                                        <h5> Blog </h5>
                                    </a>
                                </li>
                                <li class="nav-list mx-3">
                                    <a href="index.jsp#contact" class="nav-link px-2">
                                        <h5> Contact </h5>
                                    </a>
                                </li>
                            </ul>

                            <div class="account d-flex align-items-center mt-5 mt-lg-0 justify-content-center justify-content-lg-end">
                                <a href="loginServlet" class="nav-link me-5 login">
                                    <h5>Login</h5>
                                </a>

                                <button type="button" onclick="window.location.href ='signUpServlet'" class="btn btn-primary first-button signup px-4 py-3" data-bs-toggle="modal">Sign up</button>

                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </section>
    
</html>
