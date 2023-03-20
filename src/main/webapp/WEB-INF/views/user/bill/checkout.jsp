<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<body>
 <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>Checkout</h1>
                    <nav class="d-flex align-items-center">
                        <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                        <a href="single-product.html">Checkout</a>
                    </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->
    
      <!--================Checkout Area =================-->
       
    <section class="checkout_area section_gap">
        <div class="container">
            <div class="billing_details">
            <form:form action="checkout" method="post" modelAttribute="bills"> 
                <div class="row">
                    <div class="col-lg-8">
                        <h3>Billing Details</h3>
                        
                            <div class="col-md-12 form-group">
                                <form:input type="text" class="form-control"  placeholder="Name" path="display_name"/>
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <form:input type="text" class="form-control" path="phone" placeholder="Phone number"/>
                            </div>
                            <div class="col-md-6 form-group p_star">
                                <form:input type="text" class="form-control" path="user" placeholder="Email Address"/>
                       
                            </div>  
                              <div class="col-md-12 form-group">
                                <form:input type="text" class="form-control" path="address" placeholder="Địa chỉ"/>                        
                            </div>   
                             <div class="col-md-12 form-group">
                                <form:textarea type="text" class="form-control" path="note" placeholder="Ghi chú"/>
                             
                            </div>                             
                       
                    </div>
                    <div class="col-lg-4">
                        <div class="order_box">
                            <h2>Your Order</h2>
                            <ul class="list list_2">                         
                               <li><a href="#">TotalPriceCart <span>${TotalPriceCart}</span></a></li>
                                <li><a href="#">TotalQuantyCart <span>${TotalQuantyCart}</span></a></li>
                            </ul>
                           
                            <button class="primary-btn" type="submit">Check Out</button>
                        </div>
                    </div>
                    
                </div>
                </form:form>
            </div>
        </div>
    </section>
     
    <!--================End Checkout Area =================-->
</body>
