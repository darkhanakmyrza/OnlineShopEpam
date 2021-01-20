<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create a product</title>
</head>
<body>
<form action="updateProduct" method="post">

    <label for="name"><b>name</b></label>
    <input type="text" value="<c:out value="${product.getName()}" />"placeholder="Enter name" name="name" id="name" required>

    <label for="description"><b>description</b></label>
    <input type="text" value="<c:out value="${product.getDescription()}" />" placeholder="Enter description" name="description" id="description" required>

    <label ><b>price</b></label>
    <input type="number" value="<c:out value="${product.getPrice()}" />" placeholder="Enter price" name="price" id="price" required>

    <label ><b>image url</b></label>
    <input type="text" value="<c:out value="${product.getImage_url()}" />" placeholder="Enter image" name="image_url" id="image_url" required>

    <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
    <button type="submit" class="createProduct">updaate Product</button>
</form>
</body>
</html>
