<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration Confirmation Page</title>
</head>
<body>
<form:form action="/login" method="get">

    login:${deleteUserForm.login}
    <br>
    password:${deleteUserForm.password}
    <br>
    email:${deleteUserForm.email}
    <br>
    <hr>
    <footer>
        <input type="submit" class="btnLogin" value="Confirm" tabindex="4">
    </footer>
</form:form>

</body>
</html>