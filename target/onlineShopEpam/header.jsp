<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Online Shop</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--enable mobile device-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--fontawesome css-->
<style>
    <%@include file="css/font-awesome.min.css"%>
    <!--bootstrap css-->
<%--    //<link rel="stylesheet" href="/css/bootstrap.min.css">--%>
    <%@include file="css/bootstrap.min.css"%>
    <!--animate css-->
<%--    <link rel="stylesheet" href="css/animate-wow.css">--%>
    <%@include file="css/bootstrap.min.css"%>
    <!--main css-->
<%--    <link rel="stylesheet" href="css/style.css">--%>
    <%@include file="css/style.css"%>
<%--    <link rel="stylesheet" href="css/bootstrap-select.min.css">--%>
    <%@include file="css/bootstrap-select.min.css"%>
<%--    <link rel="stylesheet" href="css/slick.min.css">--%>
    <%@include file="css/slick.min.css"%>
    <!--responsive css-->
<%--    <link rel="stylesheet" href="css/responsive.css">--%>
    <%@include file="css/responsive.css"%>
</style>

</head>
<body>
<header id="header" class="top-head">
    <!-- Static navbar -->
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4 col-sm-12 left-rs">
                    <div class="navbar-header">
                        <button type="button" id="top-menu" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="home" class="navbar-brand"><img src="images/logo.png" alt="" /></a>
                    </div>

                </div>
                <div class="col-md-8 col-sm-12">
                    <div class="right-nav">
                        <div class="login-sr">
                            <div class="login-signup">
                                <ul>
                                    <li><a href="login"><fmt:message key="button.login"/></a></li>

                                    <li>

                                        <a  href="logout"><fmt:message key="button.logout"/></a></li>
                                </ul>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>
        <!--/.container-fluid -->
    </nav>
</header>