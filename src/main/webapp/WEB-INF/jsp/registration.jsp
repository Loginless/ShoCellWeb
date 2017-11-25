
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet">
    <title>Registration</title>
</head>
<body>

<form id="registerForm" commandName="registerForm" method="post" action="${pageContext.request.contextPath}/registerProcess">
    <label><b>Login</b></label>
    <input type="text" placeholder="Enter new Login" name="login" required>
    <br>

    <label><b>Password</b></label>
    <input type="text" placeholder="Enter Password" name="password" required>
    <br>

    <label><b>Email</b></label>
    <input type="email" placeholder="Enter Email" name="email" required>
    <br>

    <input type="submit" value="Register new user" name="Register">

</body>
</html>