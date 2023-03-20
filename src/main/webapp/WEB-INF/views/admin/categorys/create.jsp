<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<h1>Add New Employee</h1>
	<form:form method="post" action="themloaisanpham"
		modelAttribute="categorys">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input type="text" placeholder="Vui lòng nhập tên loại"
						path="name" /></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><form:input type="text" placeholder="Vui lòng nhập nội dung"
						path="description"  /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
