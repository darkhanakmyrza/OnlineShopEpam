<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.01.2021
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Home page</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <c:if test="${sessionScope.user.isAdmin() == true}">--%>
<%--        <a href="createProduct">create a product </a>--%>
<%--    </c:if>--%>
<%--    <a href="cart">Go to my cart  </a>--%>
<%--    <p>Hello <c:out value="${sessionScope.user.getFirstName()}" /> </p>--%>
<%--    <div>--%>
<%--    <c:forEach var = "product" items="${products}">--%>
<%--    <div class="row clearfix">--%>
<%--        <div class="col-lg-3 col-sm-6 col-md-3">--%>
<%--            <a href="product?id=${product.getId() }">--%>
<%--                <div class="box-img">--%>
<%--                    <h4>${product.getName()}</h4>--%>
<%--                    <img src="${product.getImage_url()}" alt="" />--%>
<%--                </div>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--</body>--%>
<%--</html>--%>

<%@ include file="header.jsp" %>


<%--<p>Hello <c:out value="${sessionScope.user.getFirstName()}" /> </p>--%>
<div class="modal fade lug" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Change</h4>
            </div>

        </div>
    </div>
</div>
<div id="sidebar" class="top-nav">
    <ul id="sidebar-nav" class="sidebar-nav">
        <li><a href="#">Help</a></li>
        <li><a href="howitworks.html">How it works</a></li>
        <li><a href="#">chamb for Business</a></li>
    </ul>
</div>
<div class="page-content-product">
    <div class="main-product">
        <div class="container">

            <div class="row clearfix">
                <div class="container">
                    <div class="find-box">
                        <div class="col-sm-3">
                            <div class="form-sh"></div>
                        </div>
                        <c:if test="${sessionScope.user.isAdmin() == true}">
                            <div class="col-sm-3">
                                <div class="form-sh"> <a class="btn" href="createProduct">Create product</a> </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-sh"> <a class="btn" href="allUsers">Manage users</a> </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-sh"> <a class="btn" href="orderAdmin">Orders</a> </div>
                            </div>
                        </c:if>
                        <c:if test="${sessionScope.user.isAdmin() == false}">
                            <div class="col-sm-3">
                                <div class="form-sh"> <a class="btn" href="cart">My cart</a> </div>
                            </div>
                        </c:if>


                    </div>
                </div>
                <div class="find-box">
                    <h1>Find your next product.</h1>
                    <h4>It has never been easier.</h4>

                </div>
            </div>

            <div class="row clearfix">
                <c:forEach var = "product" items="${products }">
                <div class="col-lg-3 col-sm-6 col-md-3">
                    <a href="product?id=${product.getId() }">
                        <div class="box-img">
                            <h4>${product.getName()}</h4>
                            <img src="${product.getImage_url()}" alt="" />
                        </div>
                    </a>
                </div>
                </c:forEach>
            </div>

        </div>
    </div>
</div>

