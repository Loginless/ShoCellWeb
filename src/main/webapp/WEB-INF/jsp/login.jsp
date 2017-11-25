<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>
</head>
<body>
<h1>Log-in</h1><br>

<form id="loginForm" commandName="loginForm" method="post" action="${pageContext.request.contextPath}/loginProcess">
    <label><b>Login</b></label>
    <input type="text" placeholder="Enter Login" name="login" required>
    <br>

    <label><b>Password</b></label>
    <input type="text" placeholder="Enter Password" name="password" required>
    <br>

    <input type="submit" value="Log-in" name="Login">

    <br><br>
    <label><b>Doesn't have account? Register new user.</b></label>
    <td><a href="registration">Register</a>

</body>
</html>
