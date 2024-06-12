<!DOCTYPE jsp>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="include/header1.jsp" %>
	
	<!-- Header -->
	<header class="header-v4">
		<!-- Header desktop -->
		<div class="container-menu-desktop" style="background-color: grey">
			<!-- Topbar -->
<!--			<div class="top-bar">-->
			
<!--			</div>
-->			</div>

			<div class="wrap-menu-desktop how-shadow1" >
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

					 Icon header 
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
					</div><!--
-->				</nav>
			</div>	
		
	</header>

	

   <!-- Container -->
  
        <div class=" container-fluid row" style="background-color: grey; width: auto">
            <div class="col-lg-3">
                <div class="card">
                        <div class="card-body text-center">
                            <a href="admin_info.jsp">
                                <img src="https://via.placeholder.com/150" class="rounded-circle img-fluid zoomable" alt="User Image">
                            </a>
                            <h5 class="mt-2">ShopDee</h5>
                            <p class="text-muted">Online</p>
                        </div>
                    </div>
                <div class="list-group ">
                    <a href="revenue.jsp" class="list-group-item list-group-item-action ">Dashboard</a>
                    <a href="#" class="list-group-item list-group-item-action bg-dark active">Manage product</a>
                    <a href="OrderManage.jsp" class="list-group-item list-group-item-action">Manage Order</a>
                    <a href="cusManage.jsp" class="list-group-item list-group-item-action">Manage customer</a>
                    <a href="VoucherManage.jsp" class="list-group-item list-group-item-action">Manage voucher</a>
                    
                </div>
            </div>
            <div class=" col-lg-9">
                
                    <h1 class="mt-3 " style="color: white">Product Manager</h1>
                    
                    <div class="row">
                        <a href="addProduct.jsp" class="flex-c-m stext-101 cl0 size-103 bg1 bor1 hov-btn2 p-lr-15 trans-04" style="margin: 10px 0px 10px 10px" data-bs-toggle="modal" data-bs-target="#productModal">Add Product</a></div>
                    <div class="mb-3 mt-3" >
						<form class="d-flex">
							<input class="form-control me-2" style="border-radius: 30px" type="search" placeholder="Input name of product to search" aria-label="Search">
							<select class="form-select me-2" style="border-radius: 20px">
								<option selected>Category</option>
								<option value="1">Men</option>
								<option value="2">Women</option>
                                                                <option value="3">Asseceries</option>
							</select>
							<select class="form-select me-2" style="border-radius: 20px">
								<option selected>Arrange</option>
								<option value="1">Best saler </option>
								<option value="2">Few sales</option>
                                                                <option value="3">Least left</option>
                                                                <option value="4">abc</option>
							</select>
                                                        
							<button class="btn btn-dark" style="border-radius: 20px" type="submit">Search</button>
						</form>
					</div>
			<div class="card">
                        <div class="card-header">Product List</div>
                        <div class="card-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Stock</th>
                                        <th scope="col">quantity sold</th>
                                        <th scope="col">Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- Sample Data -->
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>Men's T-Shirt</td>
                                        <td>Clothing</td>
                                        <td>$20</td>
                                        <td>100</td>
                                        <td>10</td>
                                        <td>
                                            <a href="editProduct.jsp" class="btn btn-sm btn-dark " data-bs-toggle="modal" data-bs-target="#productModal">Edit</a>
                                            <button class="btn btn-sm btn-danger">Delete</button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>Women's Jeans</td>
                                        <td>Clothing</td>
                                        <td>$40</td>
                                        <td>50</td>
                                        <td>14</td>
                                        <td>
                                            <a href="editProduct.jsp" class="btn btn-sm btn-dark " data-bs-toggle="modal" data-bs-target="#productModal">Edit</a>
                                            <button class="btn btn-sm btn-danger">Delete</button>
                                        </td>
                                    </tr>
                                    <!-- Add more products here -->
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="footer text-right ">
                        <a href="#" style="color:#6c7ae0 "> view more</a>
                    </div>
               
            </div>
        </div>
    

	
	
		

	<!-- Footer -->
	<footer class="bg3 p-t-75 p-b-32 mt-3">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						Categories
					</h4>

					<ul>
						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Women
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Men
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Shoes
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Watches
							</a>
						</li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						Help
					</h4>

					<ul>
						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Track Order
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Returns 
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								Shipping
							</a>
						</li>

						<li class="p-b-10">
							<a href="#" class="stext-107 cl7 hov-cl1 trans-04">
								FAQs
							</a>
						</li>
					</ul>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						GET IN TOUCH
					</h4>

					<p class="stext-107 cl7 size-201">
						Any questions? Let us know in store at 8th floor, 379 Hudson St, New York, NY 10018 or call us on (+1) 96 716 6879
					</p>

					<div class="p-t-27">
						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-facebook"></i>
						</a>

						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-instagram"></i>
						</a>

						<a href="#" class="fs-18 cl7 hov-cl1 trans-04 m-r-16">
							<i class="fa fa-pinterest-p"></i>
						</a>
					</div>
				</div>

				<div class="col-sm-6 col-lg-3 p-b-50">
					<h4 class="stext-301 cl0 p-b-30">
						Newsletter
					</h4>

					<form>
						<div class="wrap-input1 w-full p-b-4">
							<input class="input1 bg-none plh1 stext-107 cl7" type="text" name="email" placeholder="email@example.com">
							<div class="focus-input1 trans-04"></div>
						</div>

						<div class="p-t-18">
							<button class="flex-c-m stext-101 cl0 size-103 bg1 bor1 hov-btn2 p-lr-15 trans-04">
								Subscribe
							</button>
						</div>
					</form>
				</div>
			</div>

			<div class="p-t-40">
				<div class="flex-c-m flex-w p-b-18">
					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-01.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-02.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-03.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-04.png" alt="ICON-PAY">
					</a>

					<a href="#" class="m-all-1">
						<img src="images/icons/icon-pay-05.png" alt="ICON-PAY">
					</a>
				</div>

				<p class="stext-107 cl6 txt-center">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> &amp; distributed by <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->

				</p>
			</div>
		</div>
	</footer>


	<!-- Back to top -->
	<div class="btn-back-to-top" id="myBtn">
		<span class="symbol-btn-back-to-top">
			<i class="zmdi zmdi-chevron-up"></i>
		</span>
	</div>

    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="vendor/bootstrap/js/popper.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/highcharts.js"></script>
  
	
</body>
</html>