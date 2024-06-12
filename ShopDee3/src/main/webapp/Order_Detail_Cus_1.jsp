<!DOCTYPE jsp>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <title>Contact</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.png" />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/linearicons-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
</head>

<body class="animsition">

    <!-- Header -->
    <header class="header-v4">
        <!-- Header desktop -->
        <div class="container-menu-desktop">
            <!-- Topbar -->
            <div class="top-bar">
                <div class="content-topbar flex-sb-m h-full container">
                    <div class="left-top-bar">
                        Free shipping for standard order over $100
                    </div>

                    <div class="right-top-bar flex-w h-full">
                        <a href="#" class="flex-c-m trans-04 p-lr-25">
                            Help & FAQs
                        </a>

                        <a href="Profile-Customer.jsp" class="flex-c-m trans-04 p-lr-25">
                            My Account
                        </a>

                        <a href="#" class="flex-c-m trans-04 p-lr-25">
                            EN
                        </a>

                        <a href="#" class="flex-c-m trans-04 p-lr-25">
                            USD
                        </a>
                    </div>
                </div>
            </div>

            <div class="wrap-menu-desktop how-shadow1">
                <nav class="limiter-menu-desktop container">

                    <!-- Logo desktop -->
                    <a href="#" class="logo">
                        <img src="images/icons/logo-01.png" alt="IMG-LOGO">
                    </a>

                    <!-- Menu desktop -->
                    <div class="menu-desktop">
                        <ul class="main-menu">
                            <li>
                                <a href="index.jsp">Home</a>
                                <ul class="sub-menu">
                                    <li><a href="index.jsp">Homepage 1</a></li>
                                    <li><a href="home-02.jsp">Homepage 2</a></li>
                                    <li><a href="home-03.jsp">Homepage 3</a></li>
                                </ul>
                            </li>

                            <li>
                                <a href="product.jsp">Shop</a>
                            </li>

                            <li class="label1" data-label1="hot">
                                <a href="shoping-cart.jsp">Features</a>
                            </li>

                            <li>
                                <a href="blog.jsp">Blog</a>
                            </li>

                            <li>
                                <a href="about.jsp">About</a>
                            </li>

                            <li class="active-menu">
                                <a href="contact.jsp">Contact</a>
                            </li>
                        </ul>
                    </div>

                    <!-- Icon header -->
                    <div class="wrap-icon-header flex-w flex-r-m">
                        <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
                            <i class="zmdi zmdi-search"></i>
                        </div>

                        <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart"
                            data-notify="2">
                            <i class="zmdi zmdi-shopping-cart"></i>
                        </div>

                        <a href="#" class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti"
                            data-notify="0">
                            <i class="zmdi zmdi-favorite-outline"></i>
                        </a>
                    </div>
                </nav>
            </div>
        </div>

        <!-- Header Mobile -->
        <div class="wrap-header-mobile">
            <!-- Logo moblie -->
            <div class="logo-mobile">
                <a href="index.jsp"><img src="images/icons/logo-01.png" alt="IMG-LOGO"></a>
            </div>

            <!-- Icon header -->
            <div class="wrap-icon-header flex-w flex-r-m m-r-15">
                <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
                    <i class="zmdi zmdi-search"></i>
                </div>

                <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart"
                    data-notify="2">
                    <i class="zmdi zmdi-shopping-cart"></i>
                </div>

                <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti"
                    data-notify="0">
                    <i class="zmdi zmdi-favorite-outline"></i>
                </a>
            </div>

            <!-- Button show menu -->
            <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
                <span class="hamburger-box">
                    <span class="hamburger-inner"></span>
                </span>
            </div>
        </div>


        <!-- Menu Mobile -->
        <div class="menu-mobile">
            <ul class="topbar-mobile">
                <li>
                    <div class="left-top-bar">
                        Free shipping for standard order over $100
                    </div>
                </li>

                <li>
                    <div class="right-top-bar flex-w h-full">
                        <a href="#" class="flex-c-m p-lr-10 trans-04">
                            Help & FAQs
                        </a>

                        <a href="#" class="flex-c-m p-lr-10 trans-04">
                            My Account
                        </a>

                        <a href="#" class="flex-c-m p-lr-10 trans-04">
                            EN
                        </a>

                        <a href="#" class="flex-c-m p-lr-10 trans-04">
                            USD
                        </a>
                    </div>
                </li>
            </ul>

            <ul class="main-menu-m">
                <li>
                    <a href="index.jsp">Home</a>
                    <ul class="sub-menu-m">
                        <li><a href="index.jsp">Homepage 1</a></li>
                        <li><a href="home-02.jsp">Homepage 2</a></li>
                        <li><a href="home-03.jsp">Homepage 3</a></li>
                    </ul>
                    <span class="arrow-main-menu-m">
                        <i class="fa fa-angle-right" aria-hidden="true"></i>
                    </span>
                </li>

                <li>
                    <a href="product.jsp">Shop</a>
                </li>

                <li>
                    <a href="shoping-cart.jsp" class="label1 rs1" data-label1="hot">Features</a>
                </li>

                <li>
                    <a href="blog.jsp">Blog</a>
                </li>

                <li>
                    <a href="about.jsp">About</a>
                </li>

                <li>
                    <a href="contact.jsp">Contact</a>
                </li>
            </ul>
        </div>

        <!-- Modal Search -->
        <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
            <div class="container-search-header">
                <button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
                    <img src="images/icons/icon-close2.png" alt="CLOSE">
                </button>

                <form class="wrap-search-header flex-w p-l-15">
                    <button class="flex-c-m trans-04">
                        <i class="zmdi zmdi-search"></i>
                    </button>
                    <input class="plh3" type="text" name="search" placeholder="Search...">
                </form>
            </div>
        </div>
    </header>
    <div class="container-fluid mt-3 ">
     <div style="width: 70%; margin-left: auto; margin-right: auto;">
            <div style="width: 83.333333%; margin-left: auto; margin-right: auto;">
                <table
                    style="background-color: #ffffff; border: 1px solid #ddd; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 100%;">
                    <tbody>
                        <tr>
                            <td rowspan="3" style="text-align: center; padding: 20px;">
                                <img src="images/product-01.jpg" alt="Product Image"
                                    style="width: 150px; height: auto; border: 1px solid #ddd; border-radius: 8px;">
                            </td>
                            <td colspan="2" style="text-align: left; padding: 20px; font-weight: bold;">Product 1</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Prize:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;">6.290.000VND</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Sale off:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px; color: green;">-2.300.000VND
                            </td>
                        </tr>
                         <tr>
                            <td rowspan="3" style="text-align: center; padding: 20px;">
                                <img src="images/product-02.jpg" alt="Product Image"
                                    style="width: 150px; height: auto; border: 1px solid #ddd; border-radius: 8px;">
                            </td>
                            <td colspan="2" style="text-align: left; padding: 20px; font-weight: bold;">Product 2</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Prize:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;">6.290.000VND</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Sale off:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px; color: green;">-2.300.000VND
                            </td>
                        </tr>
                        <tr style="background-color: #f2f2f2;">
                            <th scope="row" colspan="3"
                                style="color: #333; text-align: right; padding: 20px; padding-right: 20px;">Total bill
                                3.990.000VND</th>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Bill code:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;" colspan="2">#123456789
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Date order:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;" colspan="2">22/05/2024
                                14:30</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Payment method:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;" colspan="2">Payment when get order</td>
                        </tr>
                        <tr>
                            <td colspan="3" style="text-align: left; padding: 20px;">Shop phone: <a
                                    href="tel:+1234567890" style="color: #007bff;">(+123) 456-7890</a></td>
                        </tr>
                    </tbody>
                </table>
                <div class="container" style="margin-top: 20px;">
                    <div class="row justify-content-center">
                        <div class="col-12 d-flex justify-content-center">
<!--                            <a href="shoping-cart.jsp" class="m-2">
                                <div class="flex-c-m stext-101 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
                                    
                                </div>
                            </a>-->
                            <a href="update_Feedback.jsp" class="m-2">
                                <div class="flex-c-m stext-101 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
                                    Feedback
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   

<!--    <div class="col-6"
        style="padding-top: 75px; padding-bottom: 85px; background-color: #f9f9f9; display: flex; justify-content: center; align-items: center; height: 100%; border: 2px solid #ccc; border-radius: 10px;">
        <div style="width: 70%; margin-left: auto; margin-right: auto;">
            <div style="width: 83.333333%; margin-left: auto; margin-right: auto;">
                <table
                    style="background-color: #ffffff; border: 1px solid #ddd; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 100%;">
                    <tbody>
                        <tr>
                            <td rowspan="3" style="text-align: center; padding: 20px;">
                                <img src="https://via.placeholder.com/150" alt="Product Image"
                                    style="width: 150px; height: auto; border: 1px solid #ddd; border-radius: 8px;">
                            </td>
                            <td colspan="2" style="text-align: left; padding: 20px; font-weight: bold;">Product 2</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Giá g?c:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;">5.550.000?</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Sale off:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px; color: green;">-500.000?
                            </td>
                        </tr>
                        <tr style="background-color: #f2f2f2;">
                            <th scope="row" colspan="3"
                                style="color: #333; text-align: right; padding: 20px; padding-right: 20px;">Thành ti?n
                                5.050.000?</th>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Mã ??n hàng:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;" colspan="2">#123456789
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Th?i gian ??t hàng:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;" colspan="2">22/05/2024
                                14:30</td>
                        </tr>
                        <tr>
                            <td style="text-align: left; padding: 20px;">Ph??ng th?c thanh toán:</td>
                            <td style="text-align: right; padding: 20px; padding-right: 20px;" colspan="2">Thanh toán
                                khi nh?n hàng</td>
                        </tr>
                        <tr>
                            <td colspan="3" style="text-align: left; padding: 20px;">Liên h? shop: <a
                                    href="tel:+1234567890" style="color: #007bff;">(+123) 456-7890</a></td>
                        </tr>
                    </tbody>
                </table>
                <div class="container" style="margin-top: 20px;">
                    <div class="row justify-content-center">
                        <div class="col-12 d-flex justify-content-center">
                            <a href="product.jsp" class="m-2">
                                <div class="flex-c-m stext-101 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
                                    Buy again
                                </div>
                            </a>
                            <a href="Update-Feedback.jsp" class="m-2">
                                <div class="flex-c-m stext-101 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
                                    Product Feedback
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>-->
        </div>


    <%@include file="include/footer.jsp" %>
    <!-- Back to top -->
    <div class="btn-back-to-top" id="myBtn">
        <span class="symbol-btn-back-to-top">
            <i class="zmdi zmdi-chevron-up"></i>
        </span>
    </div>

    <!--===============================================================================================-->
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/animsition/js/animsition.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/bootstrap/js/popper.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/select2/select2.min.js"></script>
    <script>
        $(".js-select2").each(function () {
            $(this).select2({
                minimumResultsForSearch: 20,
                dropdownParent: $(this).next('.dropDownSelect2')
            });
        })
    </script>
    <!--===============================================================================================-->
    <script src="vendor/daterangepicker/moment.min.js"></script>
    <script src="vendor/daterangepicker/daterangepicker.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/slick/slick.min.js"></script>
    <script src="js/slick-custom.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/parallax100/parallax100.js"></script>
    <script>
        $('.parallax100').parallax100();
    </script>
    <!--===============================================================================================-->
    <script src="vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
    <script>
        $('.gallery-lb').each(function () { // the containers for all your galleries
            $(this).magnificPopup({
                delegate: 'a', // the selector for gallery item
                type: 'image',
                gallery: {
                    enabled: true
                },
                mainClass: 'mfp-fade'
            });
        });
    </script>
    <!--===============================================================================================-->
    <script src="vendor/isotope/isotope.pkgd.min.js"></script>
    <!--===============================================================================================-->
    <script src="vendor/sweetalert/sweetalert.min.js"></script>
    <script>
        $('.js-addwish-b2').on('click', function (e) {
            e.preventDefault();
        });

        $('.js-addwish-b2').each(function () {
            var nameProduct = $(this).parent().parent().find('.js-name-b2').jsp();
            $(this).on('click', function () {
                swal(nameProduct, "is added to wishlist !", "success");

                $(this).addClass('js-addedwish-b2');
                $(this).off('click');
            });
        });

        $('.js-addwish-detail').each(function () {
            var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').jsp();

            $(this).on('click', function () {
                swal(nameProduct, "is added to wishlist !", "success");

                $(this).addClass('js-addedwish-detail');
                $(this).off('click');
            });
        });

        /*---------------------------------------------*/

        $('.js-addcart-detail').each(function () {
            var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').jsp();
            $(this).on('click', function () {
                swal(nameProduct, "is added to cart !", "success");
            });
        });

    </script>
    <!--===============================================================================================-->
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script>
        $('.js-pscroll').each(function () {
            $(this).css('position', 'relative');
            $(this).css('overflow', 'hidden');
            var ps = new PerfectScrollbar(this, {
                wheelSpeed: 1,
                scrollingThreshold: 1000,
                wheelPropagation: false,
            });

            $(window).on('resize', function () {
                ps.update();
            })
        });
    </script>
    <!--===============================================================================================-->
    <script src="js/main.js"></script>

</body>

</html>