<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
</head>
<body>
<body>
<h1>cart </h1>
<div>
    <c:forEach var = "product" items="${productIdsInCart}">
    <div class="row clearfix">
        <div class="col-lg-3 col-sm-6 col-md-3">
            <a href="product?id=${product.getId() }">
                <div class="box-img">
                    <h4>${product.getName()}</h4>
                    <img src="${product.getImage_url()}" alt="" />
                </div>
            </a>
        </div>
        <form action="deleteProductFromCart" method="post">
            <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
            <button class="">Delete From Cart</button>
        </form>
        </c:forEach>
    </div>
</body>
</body>
</html>
