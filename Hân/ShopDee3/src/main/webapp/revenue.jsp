<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/header1.jsp" %>
    <body class="animsition" style="background-color: grey">

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

                            <a href="cus_info.jsp" class="flex-c-m trans-04 p-lr-25">
                                My Account
                            </a>

                            <a href="login.jsp" class="flex-c-m trans-04 p-lr-25">login</a>


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

                                <li class="active-menu">
                                    <a href="about.jsp">About</a>
                                </li>

                                <li>
                                    <a href="contact.jsp">Contact</a>
                                </li>
                            </ul>
                        </div>	

<!--                         Icon header 
                        <div class="wrap-icon-header flex-w flex-r-m">
                            <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
                                <i class="zmdi zmdi-search"></i>
                            </div>

                            <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="2">
                                <i class="zmdi zmdi-shopping-cart"></i>
                            </div>

                            <a href="#" class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti" data-notify="0">
                                <i class="zmdi zmdi-favorite-outline"></i>
                            </a>
                        </div>-->
                    </nav>
                </div>	
            </div>

<!--             Header Mobile 
            <div class="wrap-header-mobile">
                 Logo moblie 		
                <div class="logo-mobile">
                    <a href="index.jsp"><img src="images/icons/logo-01.png" alt="IMG-LOGO"></a>
                </div>

                 Icon header 
                <div class="wrap-icon-header flex-w flex-r-m m-r-15">
                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
                        <i class="zmdi zmdi-search"></i>
                    </div>

                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart" data-notify="2">
                        <i class="zmdi zmdi-shopping-cart"></i>
                    </div>

                    <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti" data-notify="0">
                        <i class="zmdi zmdi-favorite-outline"></i>
                    </a>
                </div>

                 Button show menu 
                <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </div>
            </div>



             Modal Search 
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
            </div>-->
        </header>


        <!-- Container -->
        <div class="container-fluid mt-4">
            <div class="row">
                <div class="col-md-3" style="background-color: grey">

                    <div class="card">
                        <div class="card-body text-center">
                            <a href="admin_info.jsp">
                                <img src="https://via.placeholder.com/150" class="rounded-circle img-fluid zoomable" alt="User Image">
                            </a>
                            <h5 class="mt-2">ShopDee</h5>
                            <p class="text-muted">Online</p>
                        </div>
                    </div>
                    <!-- Menu container -->
                    <div class="list-group mt-3">
                        <a href="#" class="list-group-item list-group-item-action active" style="background-color: black; color: white;" >Dashboard</a>
                        <a href="productManage.jsp" class="list-group-item list-group-item-action">Manage product</a>
                        <a href="OrderManage.jsp" class="list-group-item list-group-item-action">Manage Order</a>
                        <a href="cusManage.jsp" class="list-group-item list-group-item-action">Manage customer</a>
                        <a href="VoucherManage.jsp" class="list-group-item list-group-item-action">Manage voucher</a>
                       
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-3">
                            <div class="card text-dark mb-3 " style="border-radius: 20px; box-shadow: 0 0 10px 5px rgba(0, 0, 0, 0.2);">
                                <div class="card-body ">
                                    <h5 class="card-title">Total revenue</h5>
                                    <p class="card-text">9.000.000.000</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="card  text-dark mb-3 " style="border-radius: 20px; box-shadow: 0 0 10px 5px rgba(0, 0, 0, 0.2);">
                                <div class="card-body">
                                    <h5 class="card-title">Total order</h5>
                                    <p class="card-text">127</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="card text-dark mb-3  " style="border-radius: 20px; box-shadow: 0 0 10px 5px rgba(0, 0, 0, 0.2);">
                                <div class="card-body">
                                    <h5 class="card-title">Total sell product</h5>
                                    <p class="card-text">2000</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="card text-dark mb-3 " style="border-radius: 20px; box-shadow: 0 0 10px 5px rgba(0, 0, 0, 0.2);">
                                <div class="card-body">
                                    <h5 class="card-title">Total product canceled</h5>
                                    <p class="card-text">100</p>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class=" row ">
                        <div class="card mb-3 col-8">
                            <div class="card-body">
                                <h5 class="card-title "></h5>
                                <div id="revenue-chart" style="height: 300px;"></div>
                            </div>
                        </div>

                        <div class="card mb-3 col-4">
                            <div class="card-body">
                                <h5 class="card-title "></h5>
                                <div id="order-status-chart" style="height: 300px;"></div>
                            </div>
                        </div>
                    </div>
<!--                    <div class="voucher-banner">
                        <a href="add_voucher.jsp">
                            <img src="images/voucher.png" class="container " style="width: 100%; height: 200px" alt="voucher">
                        </a>
                    </div>-->
                    <div class="row mt-3" style="background-color: grey"> 
                        <div class="card mb-3 col-lg-7  ">
                            <div class="card-body ">
                                <h5 class="card-title">New order list</h5>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Info</th>
                                            <th>Money</th>
                                            <th>Account</th>
                                            <th>Status</th>
                                            <th>Time</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>11</td>
                                            <td>Name: Đức Anh</td>
                                            <td>12,945.000 đ</td>
                                            <td>Khách</td>
                                            <td>Tiếp nhận</td>
                                            <td>2024-05-31 17:14:55</td>
                                        </tr>
                                        <tr>
                                            <td>12</td>
                                            <td>Name: Ngọc Hân</td>
                                            <td>905.000 đ</td>
                                            <td>Khách</td>
                                            <td>Tiếp nhận</td>
                                            <td>2024-05-24 17:14:55</td>
                                        </tr>

                                        <!-- Thêm các hàng khác ở đây -->
                                    </tbody>
                                </table>
                                <a href="OrderManage.jsp" class=" float-right" style="top: 10px; right: 10px; color: #6c7ae0">View detail</a>
                            </div>

                        </div>


                        <div class="card mb-3 col-lg-5" >
                            <div class="card-body">
                                <h5 class="card-title">Top sản phẩm bán chạy</h5>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p>Đồng hồ nam thể thao</p>
                                        <p>4 Lượt mua</p>
                                    </div>
                                    <div class="col-md-6 text-right">
                                        <p>12,000.000 đ</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>





        <!-- Footer -->
 <%@include file="include/footer.jsp" %>

        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <!-- <script src="js/highcharts.js"></script> -->
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script>
                            // Script để vẽ biểu đồ doanh thu và thống kê trạng thái đơn hàng
                            Highcharts.chart('revenue-chart', {
                                title: {
                                    text: 'Biểu đồ doanh thu các ngày trong tháng'
                                },
                                xAxis: {
                                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
                                },
                                series: [{
                                        name: 'Tokyo',
                                        data: [5, 7, 10, 14, 18, 20, 22, 23, 19, 15, 10, 6]
                                    }, {
                                        name: 'London',
                                        data: [3, 5, 8, 12, 16, 18, 20, 20, 17, 12, 7, 4]
                                    }]
                            });

                            Highcharts.chart('order-status-chart', {
                                chart: {
                                    plotBackgroundColor: null,
                                    plotBorderWidth: null,
                                    plotShadow: false,
                                    type: 'pie'
                                },
                                title: {
                                    text: 'Thống kê trạng thái đơn hàng'
                                },
                                plotOptions: {
                                    pie: {
                                        allowPointSelect: true,
                                        cursor: 'pointer',
                                        dataLabels: {
                                            enabled: true
                                        }
                                    }
                                },
                                series: [{
                                        name: 'Orders',
                                        colorByPoint: true,
                                        data: [{
                                                name: 'Hoàn tất',
                                                y: 60
                                            }, {
                                                name: 'Đang vận chuyển',
                                                y: 30
                                            }, {
                                                name: 'Hủy bỏ',
                                                y: 10
                                            }]
                                    }]
                            });
        </script>

    </body>
</html>