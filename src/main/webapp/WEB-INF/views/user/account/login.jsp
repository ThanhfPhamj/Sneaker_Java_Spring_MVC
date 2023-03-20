<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<body>
	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Login/Register</h1>
					<nav class="d-flex align-items-center">
						<a href="/SneakerShop/">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">Login/Register</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Login Box Area =================-->
	<section class="login_box_area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="login_box_img">
						<img class="img-fluid"
							src="<c:url value="/assets/user/img/login.jpg"/>" alt="">
						<div class="hover">
							<h4>New to our website?</h4>
							<p>There are advances being made in science and technology
								everyday, and a good example of this is the</p>
							<a class="primary-btn" href="<c:url value = "/dangky"/>">Create an
								Account</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner">
						<h3>Log in to enter</h3>
						
						<form:form action="dangnhap" method="post" modelAttribute="user"
							ovalidate="novalidate" id="contactForm" class="row login_form">
							<div class="col-md-12 form-group">
								<form:input type="email" class="form-control" path="user"
									placeholder="Username" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Username'" />
							</div>
							<div class="col-md-12 form-group">
								<form:input type="password" class="form-control" path="password"
									placeholder="Password" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Password'" />
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">Log
									In</button>
								<a href="#">Forgot Password?</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->
</body>
