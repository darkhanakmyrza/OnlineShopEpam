<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var = "user" items="${users}">
<div class="row clearfix">
    <div class="col-lg-3 col-sm-6 col-md-3">

            <div class="box-img">
                <h4>${user.getFirstName()}</h4>
                <p>${user.getLastName()}</p>
                <p>${user.getEmail()}</p>
                <c:if test="${user.isActive() == true}">
                    <form action="deactivateUser" method="post">
                        <input type="hidden" name="userId" value="<c:out value="${user.getId()}"/>" />
                        <button>deactivate this user</button>
                    </form>
                </c:if>
                <c:if test="${user.isActive() == false}">
                    <form action="activateUser" method="post">
                        <input type="hidden" name="userId" value="<c:out value="${user.getId()}"/>" />
                        <button>activate this user</button>

                    </form>
                </c:if>

            </div>

    </div>

</div>
    </c:forEach>
</body>
</html>
