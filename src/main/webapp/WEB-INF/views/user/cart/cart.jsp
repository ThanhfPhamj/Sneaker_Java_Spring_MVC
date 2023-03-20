<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/views/layouts/user/taglib.jsp" %>   
<body>
 <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>Shopping Cart</h1>
                    <nav class="d-flex align-items-center">
                        <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="category.html">Giỏ hàng</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->

    	<!--================Cart Area =================-->
    <section class="cart_area">
        <div class="container">
            <div class="cart_inner">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Sản Phẩm</th>
                                <th scope="col">Giá</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">Tổng</th>
                            </tr>
                        </thead>
                        <tbody>
                      
                        <c:forEach var="item" items="${ Cart }">
                        <tr>
                                <td>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="<c:url value="/assets/user/img/${ item.value.product.img }"/>">
                                        </div>
                                        <div class="media-body">
                                            <p>${ item.value.product.name }</p>
                                        </div>
                                    </div>
                                </td>
                                <td>
                                    <h5><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.product.price }" /> ₫</h5>
                                </td>
                                <td>
                                    <div class="product_count">
                                        <input class = "input-text qty" type="number" min="0" max="1000" placeholder="1" id="quanty-cart-${ item.key }"  type="text" value="${ item.value.quanty }">
                                        <button onclick="var result = document.getElementById('quanty-cart-${ item.key }'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;"
                                            class="increase items-count" type="button"><i class="lnr lnr-chevron-up"></i></button>
                                        <button onclick="var result = document.getElementById('quanty-cart-${ item.key }'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
                                            class="reduced items-count" type="button"><i class="lnr lnr-chevron-down"></i></button>
                                    </div>
                                </td>
                                <td>
                                    <h5><fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.totalPrice }" /> ₫</h5>
                                </td>
                                <td><button data-id ="${ item.key }" class="btn btn-mini btn-danger edit-cart" type="button"> Cập nhật
								</button></td>
								<td><a href="<c:url value="/DeleteCart/${ item.key }"/>" class="btn btn-mini btn-danger " type="button"> Xóa
								</a></td>

							</tr>
                        </c:forEach>                  
                            <tr>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>
                                    <h5>Tổng tiền</h5>
                                </td>
                                <td>
                                    <h5><fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart }" /> ₫</h5>
                                </td>
                            </tr>    
                            <tr class="out_button_area">
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>
                                    <div class="checkout_btn_inner d-flex align-items-center">
                                        <a class="gray_btn" href="#">Tiếp tục mua sắm</a>
                                        <a class="primary-btn" href="<c:url value="/checkout"/>">Thanh toán</a>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
      </section>
    <!--================End Cart Area =================-->
   <content tag = "script">
    <script>
    $(".edit-cart").on("click", function(){
    	var id = $(this).data("id");
    	var quanty = $("#quanty-cart-"+id).val();
    	window.location = "EditCart/"+id+"/"+quanty;
    	
    });
    </script>
    </content>
</body>
