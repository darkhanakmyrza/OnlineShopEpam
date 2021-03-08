
<%@ include file="header.jsp" %>

<%--<div class="row clearfix center-block">--%>
<%--    <c:forEach var = "product" items="${products }">--%>
<%--        <div class="col-lg-3 col-sm-6 col-md-3">--%>
<%--            <a href="product?id=${product.getId() }">--%>
<%--                <div class="box-img">--%>
<%--                    <h4>${product.getName()}</h4>--%>
<%--                    <img src="${product.getImage_url()}" alt="" />--%>
<%--                </div>--%>
<%--            </a>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--</div>--%>
<%--<div>--%>
<%--    <p>Current status</p>--%>
<%--    <p>${currentStatus.getStatusName()}</p>--%>
<%--</div>--%>
<%--<div>--%>
<%--<c:if test="${sessionScope.user.isAdmin() == true}">--%>
<%--    <form action="changeStatus" method="post">--%>
<%--        <p><select name="statusId">--%>
<%--        <c:forEach var = "status" items="${statuses }">--%>
<%--            <option  value="<c:out value="${status.getId()}"/>" /><c:out value="${status.getStatusName()}" /></option>--%>
<%--        </c:forEach>--%>
<%--        </select>--%>
<%--            <input type="submit" value="Change status"></p>--%>
<%--        <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />--%>
<%--    </form>--%>

<%--    <form action="DeleteOrderAdminService" method="post">--%>
<%--        <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />--%>
<%--        <button class="btn btn-danger btn-lg">Delete Order</button>--%>
<%--    </form>--%>

<%--</c:if>--%>
<%--<c:if test="${sessionScope.user.isAdmin() == false}">--%>



<%--    <c:if test="${currentStatus.getId()==5 or currentStatus.getId()==1 or currentStatus.getId()==3}" >--%>
<%--        <p>d</p>--%>
<%--        <form action="changeStatus" method="post">--%>
<%--            <input type="hidden" name="statusId" value="2" />--%>
<%--            <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />--%>
<%--            <button class="btn btn-danger btn-lg">Cancel order</button>--%>
<%--        </form>--%>
<%--    </c:if>--%>

<%--    <c:if test="${currentStatus.getId()== 4}" >--%>

<%--        <form action="changeStatus" method="post">--%>
<%--            <input type="hidden" name="statusId" value="3" />--%>
<%--            <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />--%>
<%--            <button class="btn btn-danger btn-lg">Order arrived</button>--%>
<%--        </form>--%>
<%--    </c:if>--%>

<%--</c:if>--%>
<%--</div>--%>

<%--<%@ include file="footer.jsp" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<!-- Basic -->--%>

<%--<head>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>

<%--    <!-- Mobile Metas -->--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>

<%--    <!-- Site Metas -->--%>
<%--    <title>ThewayShop - Ecommerce Bootstrap 4 HTML Template</title>--%>
<%--    <meta name="keywords" content="">--%>
<%--    <meta name="description" content="">--%>
<%--    <meta name="author" content="">--%>

<%--    <!-- Site Icons -->--%>
<%--    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">--%>
<%--    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">--%>

<%--    <!-- Bootstrap CSS -->--%>
<%--    <link rel="stylesheet" href="css/bootstrap.min.css">--%>
<%--    <!-- Site CSS -->--%>
<%--    <link rel="stylesheet" href="css/style.css">--%>
<%--    <!-- Responsive CSS -->--%>
<%--    <link rel="stylesheet" href="css/responsive.css">--%>
<%--    <!-- Custom CSS -->--%>
<%--    <link rel="stylesheet" href="css/custom.css">--%>

<%--    <!--[if lt IE 9]>--%>
<%--    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
<%--    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>--%>
<%--    <![endif]-->--%>

<%--</head>--%>

<%--<body>--%>



<!-- End All Title Box -->

<!-- Start Cart  -->
<div class="cart-box-main">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="table-main table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Images</th>
                            <th>Product Name</th>
                            <th>Price</th>


                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var = "product" items="${products }">
                        <tr>
                            <td class="thumbnail-img">
                                <a href="product?id=${product.getId() }">
                                    <img class="img-fluid" src="${product.getImage_url()}" alt="" />
                                </a>
                            </td>
                            <td class="name-pr">
                                <a href="product?id=${product.getId() }">
                                    ${product.getName()}
                                </a>
                            </td>
                            <td class="price-pr">
                                <p>$ ${product.getPrice()}</p>
                            </td>


                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div style="text-align: center;">
            <h3>Current status - <strong>${currentStatus.getStatusName()}</strong>   </h3>

        </div>


<%--        <div class="row my-5">--%>

<%--            <div class="col-lg-5 col-sm-3">--%>
<%--                <div class="update-box">--%>
<%--                    <input value="Cancel" type="submit">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-5 col-sm-3">--%>
<%--                <div class="update-box">--%>
<%--                    <input value="Arrived" type="submit">--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
        <c:if test="${sessionScope.user.isAdmin() == true}">
            <div style="margin-top: 100px;margin-bottom: 100px; text-align: center;">
            <form action="changeStatus" method="post">
                <p><select name="statusId">
                    <c:forEach var = "status" items="${statuses }">
                        <option  value="<c:out value="${status.getId()}"/>" /><c:out value="${status.getStatusName()}" /></option>
                    </c:forEach>
                </select>
                    <input type="submit" value="Change status"></p>
                <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />
            </form>

            <form action="DeleteOrderAdminService" method="post">
                <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />
                <button class="btn btn-danger btn-lg">Delete Order</button>
            </form>

        </div>
        </c:if>
        <c:if test="${sessionScope.user.isAdmin() == false}">
            <div style="margin-top: 100px;margin-bottom: 100px; text-align: center;">


            <c:if test="${currentStatus.getId()==5 or currentStatus.getId()==1 or currentStatus.getId()==4}" >

                <form action="changeStatus" method="post">
                    <input type="hidden" name="statusId" value="2" />
                    <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />
                    <button class="btn btn-danger btn-lg">Cancel order</button>
                </form>

            </c:if>

            <c:if test="${currentStatus.getId()== 4}" >

                <form action="changeStatus" method="post">
                    <input type="hidden" name="statusId" value="3" />
                    <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />
                    <button class="btn btn-info btn-lg">Order arrived</button>
                </form>

            </c:if>
            </div>
        </c:if>

    </div>
</div>
<!-- End Cart -->

</body>

</html>