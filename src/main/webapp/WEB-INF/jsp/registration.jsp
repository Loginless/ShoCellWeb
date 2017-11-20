
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/registration.css" />" rel="stylesheet">
    <title>Registration</title>
</head>
<body>

<form:form id="regForm" modelAttribute="registerForm" action="registerProcess" method="post">

    <table align="center">
        <tr>
            <td>
                <form:label path="login">Login</form:label>
            </td>
            <td>
                <form:input path="login" name="login" />
                <%--<form:errors path="login" cssClass="error" />--%>

            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
            </td>
            <td>
                <form:password path="password" name="password" />
                <%--<form:errors path="password" cssClass="error" />--%>

            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">Email</form:label>
            </td>
            <td>
                <form:input path="email" name="email" />
            </td>

        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="register" name="register">Register</form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="index.jsp">Home</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>