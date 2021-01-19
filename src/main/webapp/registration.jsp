<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.01.2021
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="registration" method="post">
<div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="firstName"><b>firstName</b></label>
    <input type="text" placeholder="Enter first name" name="firstName" id="firstName" required>

    <label for="lastName"><b>lastName</b></label>
    <input type="text" placeholder="Enter last name" name="lastName" id="lastName" required>




    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="psw" required>

    <hr>

    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
    <button type="submit" class="registerbtn">Register</button>
</div>

<div class="container signin">
    <p>Already have an account? <a href="login">Sign in</a>.</p>
</div>
</form>
</body>
</html>
