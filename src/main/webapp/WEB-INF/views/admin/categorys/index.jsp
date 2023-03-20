<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<table class="table table-hover">
		<tr>
			<td align="left" style="height: 150px">
				<h2>Loai San Pham</h2>  <a
				href="<c:url value="/admin/themloaisanpham" />"
				class="btn btn-outline-primary">Create</a>
			</td>
		</tr>

		<tr style="height: 50px;">
			<th>Loại sản phẩm</th>
			<th>Mô tả</th>

		</tr>
		<c:forEach var="item" items="${categorys}">
			<tr>
				<td>${item.name}</td>
				<td>${item.description}</td>

				<td><a href="<c:url value="/admin/sualoaisanpham/${item.id}" />"
					class="btn btn-outline-primary">Edit</a> 
					 <a href="<c:url value="/admin/xoaloaisanpham/${item.id}" />"
					class="btn btn-outline-danger">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
	<br />
</body>
