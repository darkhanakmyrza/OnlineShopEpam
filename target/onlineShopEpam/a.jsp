<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String name =(String) session.getAttribute("name");
    %>
    <p><%= name %></p>
    <p><c:out value="${name}" /></p>
    <p><c:out value="${age}" /></p>
    <p>Name: ${name}</p>
    <p>Age: ${age}</p>
</body>
</html>
