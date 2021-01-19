<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.01.2021
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>product_detail</title>
</head>
<body>
    <div>
        <h2><c:out value="${product.getName()}" /></h2>
        <p><c:out value="${product.getDescription()}" /></p>
        <img src="<c:out value="${product.getImage_url()}" />">
        <p>price: <c:out value="${product.getPrice()}" /></p>
    </div>
</body>
</html>
