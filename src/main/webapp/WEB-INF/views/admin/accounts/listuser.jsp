<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<table class="table table-hover">
		<tr>
			<td align="left" style="height: 150px">
				<h2>Tài khoản khách hàng</h2><a
				href="<c:url value="/themloaisanpham" />"
				class="btn btn-outline-primary"></a>
			</td>
		</tr>

		<tr style="height: 50px;">
			<th>Tên đăng nhập</th>
			<th>Mật khẩu</th>
			<th>Tên hiển thị</th>
			<th>Địa chỉ</th>

		</tr>
		<c:forEach var="item" items="${accounts}">
			<tr>
				<td>${item.user}</td>
				<td>${item.password}</td>
				<td>${item.display_name}</td>
				<td>${item.address}</td>
<%-- 
				<td><a href="<c:url value="/sualoaisanpham/${item.id}" />"
					class="btn btn-outline-primary">Edit</a> <a href="#"
					class="btn btn-info">Upload Img</a> <a href="<c:url value="/xoaloaisanpham/${item.id}" />"
					class="btn btn-outline-danger">Delete</a></td>  --%>
			</tr>
		</c:forEach>

	</table>
	<br />
</body>
