<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 15.01.2021
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Registration</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="registration" method="post">--%>
<%--<div class="container">--%>
<%--    <h1>Register</h1>--%>
<%--    <p>Please fill in this form to create an account.</p>--%>
<%--    <hr>--%>

<%--    <label for="email"><b>Email</b></label>--%>
<%--    <input type="text" placeholder="Enter Email" name="email" id="email" required>--%>

<%--    <label for="firstName"><b>firstName</b></label>--%>
<%--    <input type="text" placeholder="Enter first name" name="firstName" id="firstName" required>--%>

<%--    <label for="lastName"><b>lastName</b></label>--%>
<%--    <input type="text" placeholder="Enter last name" name="lastName" id="lastName" required>--%>




<%--    <label for="psw"><b>Password</b></label>--%>
<%--    <input type="password" placeholder="Enter Password" name="password" id="psw" required>--%>

<%--    <hr>--%>

<%--    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>--%>
<%--    <button type="submit" class="registerbtn">Register</button>--%>
<%--</div>--%>

<%--<div class="container signin">--%>
<%--    <p>Already have an account? <a href="login">Sign in</a>.</p>--%>
<%--</div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>login</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <style>
        <%@include file="css/font-awesome.min.css"%>
    </style>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
            integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
            integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
            crossorigin="anonymous"></script>

</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form class="form-signin" method="post" action="registration">
                <h2 class="form-signin-heading">Join us now!</h2>

                <input type="email" class="form-control setMargin" placeholder="Email address" name="email" required
                       autofocus>




                <input name="firstName" id="FirstName" class="form-control setMargin" placeholder="FirstName"
                       required autofocus>



                <input name="lastName" id="LastName" class="form-control setMargin" placeholder="LastName" required
                       autofocus>




                <input name="password" type="password" id="inputPassword" class="form-control setMargin"
                       placeholder="Password" required>


                <div class="setMargin">
                    <button name="button" value="Register" class="btn btn-outline-success my-2 my-sm-0"
                            type="submit">Register</button>
                </div>


            </form>
            <div class="setMargin">
                <a href="login" class="btn btn-info" role="button" name="button" value="Register">Login</a>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>

</html>
