<%@ include file="header.jsp" %>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS  -->
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>

<div class="container">
    <h1 style="text-align: center">My orders</h1>
    <div>
        <div class="one">
            <div class="two">Ordered time</div>
            <div class="two">Current order status</div>
        </div>
        <c:forEach var = "order" items="${orders}">

            <div class="one">
                <a href="orderDetail?orderId=${order.get(0)}">
                    <div class="two">${order.get(1)}</div>
                    <div class="two">${order.get(2)}</div>

                </a>
            </div>
        </c:forEach>
    </div>
</div>


<%@ include file="footer.jsp" %>
