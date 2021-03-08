

<%@ include file="header.jsp" %>



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
        <li><a href="howitworks.html"><fmt:message key="label.home"/></a></li>
        <li><a href="#"><fmt:message key="label.home2"/></a></li>
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

                                <div class="form-sh"> <a role="button" class="btn btn-lg" href="createProduct"><fmt:message key="button.createProduct"/></a> </div>
                                <div class="form-sh"> <a class="btn btn-lg" href="allUsers"><fmt:message key="button.manageUsers"/></a> </div>
                                <div class="form-sh"> <a class="btn btn-lg" href="ordersAdmin"><fmt:message key="button.orders"/></a> </div>


                        </c:if>
                        <c:if test="${sessionScope.user.isAdmin() == false}">
                            <div class="col-sm-3">
                                <div class="form-sh"> <a class="btn" href="cart"><fmt:message key="button.myCart"/></a> </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="form-sh"> <a class="btn" href="ordersUser"><fmt:message key="button.myOrders"/></a> </div>
                            </div>
                        </c:if>
                        <form action="changeLanguage" method="get">
                            <c:if test="${sessionScope.language == ru}">
                                <input type="hidden" name="language" value="en">
                            </c:if>
                            <c:if test="${sessionScope.language == en}">
                                <input type="hidden" name="language" value="ru">
                            </c:if>
                            <div class="form-sh">
                                <input type="submit" class="btn btn-primary btn-sm" value="Change language">
                            </div>
                        </form>


                    </div>
                </div>
                <div class="find-box">
                    <h1><fmt:message key="label.home"/></h1>
                    <h4><fmt:message key="label.home2"/></h4>

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

