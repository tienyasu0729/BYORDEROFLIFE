<!DOCTYPE jsp>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/header1.jsp" %>
<body class="animsition">
	
	<!-- Header -->
	<header class="header-v4">
		<!-- Header desktop -->
		<div class="container-menu-desktop">
			<!-- Topbar -->
			<div class="top-bar">
				
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

					<!-- Icon header -->
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
					</div>
				</nav>
			</div>	
		</div>

		
	</header>



   <!-- Container -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
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
                    <a href="revenue.jsp" class="list-group-item list-group-item-action " >Dashboard</a>
                    <a href="productManage.jsp" class="list-group-item list-group-item-action">Manage product</a>
                    <a href="OrderManage.jsp" class="list-group-item list-group-item-action">Manage Order</a>
                    <a href="cusManage.jsp" class="list-group-item list-group-item-action">Manage customer</a>
                    <a href="#" class="list-group-item list-group-item-action">Manage voucher</a>
<!--                    <a href="#" class="list-group-item list-group-item-action active" style="background-color: black; color: white;" >Manage profile</a>-->
                </div>
            </div>
             <div class="col-9 ">
                   
                        <!-- Container <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50 "  style=" width:  100%">-->

                            <div class="m-l-25 m-r--38 m-lr-0-xl" style="margin-left:0px ">


                                <div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm" style= "border-top: 0.8px solid grey; margin-right: 50px ">
                                    <h4 class="mtext-109 cl2 p-b-30">
                                        Profile
                                    </h4>

                                    <div class="flex-w flex-l m-r-20 m-tb-5 w-100">
                                        <input class="w-100 stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5"
                                               type="text" placeholder="Name">
                                    </div>

                                    <div class="flex-w flex-l m-r-20 m-tb-5 w-100">
                                        <input class="w-100 stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5"
                                               type="text" placeholder="Gender">
                                    </div>

                                    <div class="flex-w flex-l m-r-20 m-tb-5 w-100">
                                        <input class="w-100 stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5"
                                               type="number" placeholder="Date of birth">
                                    </div>

                                    <div class="flex-w flex-l m-r-20 m-tb-5 w-100">
                                        <input class="w-100 stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5"
                                               type="text" placeholder="Phone Number">
                                    </div>

                                    <div class="flex-w flex-l m-r-20 m-tb-5 w-100">
                                        <input class="w-100 stext-104 cl2 plh4 size-117 bor13 p-lr-20 m-r-10 m-tb-5"
                                               type="text" value="name@gmail.com" readonly> 

                                    </div>
                                    <div class="container">
                                        <div class="row justify-content-center">
                                            <div class="col-12 d-flex justify-content-center">
                                                <a href="changePassword.jsp" class="m-2">
                                                    <div class="flex-c-m stext-101 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
                                                        Change password
                                                    </div>
                                                </a>
                                                <a href="Update-cus.jsp" class="m-2">
                                                    <div class="flex-c-m stext-101 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer">
                                                        Update information
                                                    </div>
                                                </a>
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
    <script src="js/highcharts.js"></script>in
 
	
</body>
</html>