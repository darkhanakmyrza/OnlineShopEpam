<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.03.2021
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-md-6">
    <form class="form-signin" method="post" action="createOrder">
        <h2 class="form-signin-heading">Join us now!</h2>

        <input  class="form-control setMargin" placeholder="country" name="country" required
               autofocus>
        <input name="city" class="form-control setMargin" placeholder="city"
               required autofocus>
        <input name="street"  class="form-control setMargin" placeholder="street" required
               autofocus>

        <input name="phone"  id="phone" class="form-control setMargin"
               placeholder="phone" required>

        <div class="setMargin">
            <button name="button" value="Register" class="btn btn-outline-success my-2 my-sm-0"
                    type="submit">Register</button>
        </div>


    </form>

</div>
</body>
</html>
