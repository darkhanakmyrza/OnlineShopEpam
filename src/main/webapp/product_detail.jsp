<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product_detail</title>
</head>
<body>
    <div>
        <c:if test="${sessionScope.user.isAdmin() == true}">

            <form action="updateProduct" method="post">

                <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
                <button class="">update a product</button>
            </form>
            <form action="deleteProduct" method="post">

                <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
                <button class="">Delete product</button>
            </form>
        </c:if>
        <h2><c:out value="${product.getName()}" /></h2>
        <p><c:out value="${product.getDescription()}" /></p>
        <img src="<c:out value="${product.getImage_url()}" />">
        <p>price: <c:out value="${product.getPrice()}" /></p>
        <form action="addProductToCart" method="post">
            <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
            <button class="">Add to cart</button>

        </form>
    </div>
</body>
</html>
