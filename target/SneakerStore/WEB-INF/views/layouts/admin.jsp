<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="assets/admin/css/css/sb-admin-2.min.css"/>"
	rel="stylesheet" />
<link
	href="<c:url value="assets/admin/vendor/fontawesome-free/css/all.min.css"/>"
	rel="stylesheet" />
</head>
<body>
	<%@include file="/WEB-INF/views/layouts/admin/header.jsp"%>

	<div id="wrapper">
		<%@include file="/WEB-INF/views/layouts/admin/slidebar.jsp"%>
		<decorator:body />
	</div>

	<%@include file="/WEB-INF/views/layouts/admin/footer.jsp"%>

	<script src="<c:url value="assets/admin/vendor/jquery/jquery.min.js"/>"></script>
	<script
		src="<c:url value="assets/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
	<!-- Core plugin JavaScript-->
	<script
		src="<c:url value="assets/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value="assets/admin/js/sb-admin-2.js"/>"></script>
	<!-- Page level plugins -->
	<script
		src="<c:url value="assets/admin/vendor/chart.js/Chart.min.js"/>"></script>

	<!-- Page level custom scripts -->
	<script src="<c:url value="assets/admin/js/chart-area-demo.js"/>"></script>

	<script src="<c:url value="assets/admin/js/chart-pie-demo.js"/>"></script>

</body>
</html>