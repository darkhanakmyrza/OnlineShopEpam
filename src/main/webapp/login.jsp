<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.01.2021
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login" method="post">
    <div class="container">
        <h1>Login</h1>


        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="login" id="email" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="psw" required>


        <button type="submit" class="loginbtn">Login</button>
    </div>

    <div class="container registration">
        <p>Register account? <a href="registration">Sign in</a>.</p>
    </div>
</form>
</body>
</html>
