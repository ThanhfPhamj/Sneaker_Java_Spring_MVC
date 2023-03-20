<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon"
	href="<c:url value="/assets/user/img/fav.png"/>">

<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>Sneaker Shop</title>
<!--
		CSS
		============================================= -->
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/linearicons.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/font-awesome.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/themify-icons.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/bootstrap.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/owl.carousel.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/nice-select.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/nouislider.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/ion.rangeSlider.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/ion.rangeSlider.skinFlat.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/user/css/magnific-popup.css"/>">
<link rel="stylesheet" href="<c:url value="/assets/user/css/main.css"/>">
</head>

<body>
	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
	<decorator:body />
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>
	<script
		src="<c:url value="/assets/user/js/vendor/jquery-2.2.4.min.js"/>"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/assets/user/js/vendor/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/jquery.ajaxchimp.min.js"/>"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/jquery.sticky.js"/>"></script>
	<script src="<c:url value="/assets/user/js/nouislider.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/countdown.js"/>"></script>
	<script
		src="<c:url value="/assets/user/js/jquery.magnific-popup.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/owl.carousel.min.js"/>"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="<c:url value="/assets/user/js/gmaps.min.js"/>"></script>
	<script src="<c:url value="/assets/user/js/main.js"/>"></script>
	
	<decorator:getProperty property="page.script"></decorator:getProperty>
</body>

</html>