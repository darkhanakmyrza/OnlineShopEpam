



<%@ include file="header.jsp" %>
<div class="modal fade lug" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Change</h4>
            </div>

        </div>
    </div>
</div>
<div id="sidebar" class="top-nav">
    <ul id="sidebar-nav" class="sidebar-nav">
        <li><a href="#">Help</a></li>
        <li><a href="howitworks.html">How it works</a></li>
        <li><a href="#">chamb for Business</a></li>
    </ul>
</div>
<div class="page-content-product">
    <div class="main-product">
        <div class="container">

            <div class="row clearfix">
                <div class="container">
                    <div class="find-box">


                    </div>
                </div>
                <div class="find-box">
                    <h1>Products in my cart.</h1>
                    <h4>Sum of products $<c:out value="${sumOfPrice}"/></h4>

                </div>
            </div>

            <div class="row clearfix">
                <c:forEach var = "product" items="${productIdsInCart }">
                <div class="col-lg-3 col-sm-6 col-md-3">
                    <a href="product?id=${product.getId() }">
                        <div class="box-img">
                            <h4>${product.getName()}</h4>
                            <img src="${product.getImage_url()}" alt="" />

                            <form action="deleteProductFromCart" method="post">
                                <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>" />
                                <button  class="btn btn-danger">Delete product from cart</button>
                            </form>
                        </div>
                    </a>
                </div>
                </c:forEach>
                <form action="order.jsp" method="post">
                    <button  class="btn btn-success">Order this products</button>
                </form>
            </div>

        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>

