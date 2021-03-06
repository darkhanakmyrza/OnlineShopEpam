
<%@ include file="header.jsp" %>

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
<div>
    <p>Current status</p>
    <p>${currentStatus.getStatusName()}</p>
</div>
<div>
<c:if test="${sessionScope.user.isAdmin() == true}">
    <form action="changeStatus" method="post">
        <p><select name="statusId">
        <c:forEach var = "status" items="${statuses }">
            <option  value="<c:out value="${status.getId()}"/>" /><c:out value="${status.getStatusName()}" /></option>
        </c:forEach>
        </select>
            <input type="submit" value="Change status"></p>
        <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>" />
    </form>
</c:if>
<c:if test="${sessionScope.user.isAdmin() == false}">



    <c:if test="${currentStatus.getId()==5 or currentStatus.getId()==1 or currentStatus.getId()==3}" >
        <p>d</p>
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
            <button class="btn btn-danger btn-lg">Order arrived</button>
        </form>
    </c:if>

</c:if>
</div>

<%@ include file="footer.jsp" %>