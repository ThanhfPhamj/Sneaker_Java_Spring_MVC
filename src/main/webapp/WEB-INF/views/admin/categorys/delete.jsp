<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="card shadow flex-md-fill">
		<div class="card-body">
			<h4>Xóa</h4>
			<h4 class="card-title">Thông tin địa điểm</h4>
			<hr />
			<c:forEach var="item" items="${categorys}">
				<div class="row ">
					<label class="col-sm-2 col-form-label font-weight-bold">Tên loại</label>
					<div class="col-sm-6 col-form-label">${item.name}</div>
				</div>
				<div class="row ">
					<label class="col-sm-2 col-form-label font-weight-bold">Mô tả</label>
					<div class="col-sm-6 col-form-label">${item.description}</div>
				</div>
				<br>
				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						 <input
							type="submit" value="Xóa"
							class="btn btn-sm btn-primary font-weight-bold w-25" />
						<!-- @Html.ActionLink("Trở về", "Index", null, htmlAttributes: new {
						@class = "btn btn-sm btn-secondary font-weight-bold w-25" }) } -->
					</div>
				</div>

			</c:forEach>
		</div>
	</div>
</body>
