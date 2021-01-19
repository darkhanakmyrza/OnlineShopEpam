<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18.01.2021
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <p>Hello <c:out value="${sessionScope.user.getFirstName()}" /> </p>
    <div>
    <c:forEach var = "product" items="${products}">
    <div class="row clearfix">
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
</body>
</html>
