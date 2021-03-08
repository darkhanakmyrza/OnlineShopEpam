<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>product_detail</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <div>--%>
<%--        <c:if test="${sessionScope.user.isAdmin() == true}">--%>

<%--            <form action="updateProduct" method="post">--%>

<%--                <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />--%>
<%--                <button class="">update a product</button>--%>
<%--            </form>--%>
<%--            <form action="deleteProduct" method="post">--%>

<%--                <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />--%>
<%--                <button class="">Delete product</button>--%>
<%--            </form>--%>
<%--        </c:if>--%>
<%--        <h2><c:out value="${product.getName()}" /></h2>--%>
<%--        <p><c:out value="${product.getDescription()}" /></p>--%>
<%--        <img src="<c:out value="${product.getImage_url()}" />">--%>
<%--        <p>price: <c:out value="${product.getPrice()}" /></p>--%>
<%--        <form action="addProductToCart" method="post">--%>
<%--            <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />--%>
<%--            <button class="">Add to cart</button>--%>

<%--        </form>--%>
<%--    </div>--%>
<%--</body>--%>
<%--</html>--%>

<%@ include file="header.jsp" %>


<div class="product-page-main">
    <div class="container">

        <div class="row">
            <div class="col-md-12">
                <div class="prod-page-title">
                    <h2><c:out value="${product.getName()}" /></h2>

                </div>
            </div>
        </div>
        <div class="row">

            <div class="col-md-7 col-sm-8">
                <div class="md-prod-page">
                    <div class="md-prod-page-in">
                        <div class="page-preview">
                            <div class="preview">
                                <div class="preview-pic tab-content">
                                    <div class="tab-pane active" id="pic-1"><img src="<c:out value="${product.getImage_url()}" />" width="50px" height="100px" alt="#" /></div>

                                </div>

                            </div>
                        </div>

                    </div>
                    <div class="description-box">
                        <div class="dex-a">
                            <h4><fmt:message key="label.descriptionProduct"/></h4>
                            <p><c:out value="${product.getDescription()}" />
                            </p>
                        </div>

                    </div>
                </div>

            </div>
            <div class="col-md-3 col-sm-12">
                <div class="price-box-right">
                    <c:if test="${sessionScope.user.isAdmin() == true}">
<%--                        <a class="btn btn-primary btn-lg" href="updateProduct.do?id=<c:out value="${product.getId()}" />">update product</a>--%>
<%--                        <br>--%>
                        <form action="updateProduct" method="post">

                            <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
                            <button class="btn btn-danger btn-lg"><fmt:message key="button.updateProduct"/></button>
                        </form>
                        <br>
<%--                        <form method="POST" action="deleteProduct.do">--%>
<%--                            <input type="hidden" name="id" value="<c:out value="${product.getId()}"/>" />--%>
<%--                            <button class="btn btn-danger btn-lg">Delete product</button>--%>
<%--                        </form>--%>
                        <form action="deleteProduct" method="post">

                            <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
                            <button class="btn btn-danger btn-lg"><fmt:message key="button.deleteProduct"/></button>
                        </form>
                    </c:if>
                    <br>
                    <h4><fmt:message key="label.price"/></h4>
                    <h3>$<c:out value="${product.getPrice()}" /> </h3>

<%--                    <form method="post" action="addCartAction.do">--%>
<%--                        <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />--%>
<%--                        <button class="">Add to cart</button>--%>
<%--                    </form>--%>
                    <c:if test="${sessionScope.user.isAdmin() == false}">
                        <form action="addProductToCart" method="post">
                            <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
                            <button class=""><fmt:message key="button.addToCart"/></button>

                        </form>
                    </c:if>
                </div>
            </div>
        </div>

    </div>
</div>

