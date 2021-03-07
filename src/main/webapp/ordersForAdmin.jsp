<%@ include file="header.jsp" %>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



<div class="container">

    <h1 style="text-align: center">All orders</h1>

    <div>
        <div class="one">
            <div class="two">User email</div>
            <div class="two">Ordered time</div>
            <div class="two">Current order status</div>
        </div>
        <c:forEach var = "order" items="${orders}">

            <div class="one">
                <a href="orderDetail?orderId=${order.get(0)}">
                    <div class="two">${order.get(2)}</div>
                    <div class="two">${order.get(1)}</div>
                    <div class="two">${order.get(3)}</div>
                </a>
            </div>


        </c:forEach>

    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>
<%--</body>--%>
<%--</html>--%>
<%@ include file="footer.jsp" %>
